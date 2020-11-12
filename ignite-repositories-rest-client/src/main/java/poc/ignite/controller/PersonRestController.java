package poc.ignite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	PersonRepository ps;

	@GetMapping
	public Iterable<Person> getAllPersons() {
		return ps.findAll();
	}

	@PostMapping
	public Person saveAPerson(@RequestBody Person person) {
		return ps.save(person.getId(), person);
	}

	@DeleteMapping
	public String deletePersons(@RequestBody Iterable<Integer> ids) {
		ps.deleteAll(ids);

		return "Deleted!";
	}

	@PutMapping
	public Person updateAPerson(@RequestBody Person person) {
		return ps.save(person.getId(), person);
	}
}
