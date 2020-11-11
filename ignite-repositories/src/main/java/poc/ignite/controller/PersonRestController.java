package poc.ignite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.ignite.domain.Person;
import poc.ignite.repos.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonRestController {

	@Autowired
	private PersonRepository ps;

	@GetMapping
	public Iterable<Person> getAllPersons() {
		return ps.findAll();
	}
}
