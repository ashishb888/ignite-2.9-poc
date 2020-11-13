package poc.ignite.controller;

import java.util.Set;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.ignite.domain.Person;
import poc.ignite.repos.PersonRepository;

@RequestMapping("/persons")
@RestController
public class PersonRestController {

	@Autowired
	private Ignite ignite;
	@Autowired
	private PersonRepository ps;
	private IgniteCache<Integer, Person> personCache;

	@PostConstruct
	private void postConstruct() {
		personCache = ignite.cache("person-cache");
	}

	@GetMapping("/count")
	public Long count() {
		return ps.count();
	}

	@GetMapping
	public Iterable<Person> findAll() {
		return ps.findAll();
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable Integer id) {
		// Does not work. Not supported yet
		// return ps.findById(id).orElse(new Person(-1, "UNKNOWN"));

		return personCache.get(id);
	}

	@PostMapping
	public Person save(@RequestBody Person person) {
		return ps.save(person.getId(), person);
	}

	// Batch insert
	@PostMapping("/batch")
	public Iterable<Person> savePersons(@RequestBody TreeMap<Integer, Person> entities) {
		// personCache.putAll(entities);
		return ps.save(entities);
	}

	@DeleteMapping
	public String deleteAllById(@RequestBody Set<Integer> ids) {
		ps.deleteAll(ids);
		// personCache.removeAll(ids);

		return "Done";
	}

	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable Integer id) {
		return personCache.remove(id);
	}

	@PutMapping
	public Person updateAPerson(@RequestBody Person person) {
		return ps.save(person.getId(), person);
	}
}
