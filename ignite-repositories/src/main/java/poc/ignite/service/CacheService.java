package poc.ignite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.ignite.domain.Person;
import poc.ignite.repos.PersonRepository;

@Slf4j
@Service
public class CacheService {

	@Autowired
	private PersonRepository ps;

	private void loadCaches() {
		log.debug("loadCaches service");

		for (int i = 1; i <= 50; i++) {
			ps.save(i, new Person(i, "p" + i));
		}
	}

	public void start() {
		loadCaches();
	}
}
