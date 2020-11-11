package poc.ignite.service;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.ignite.domain.Person;

@Slf4j
@Service
public class CacheService {

	@Autowired
	private Ignite ignite;

	private void loadCaches() {
		log.debug("loadCaches service");

		IgniteCache<Integer, Person> personCache = ignite.cache("person-cache");

		for (int i = 1; i <= 50; i++) {
			personCache.put(i, new Person(i, "p" + i));
		}
	}

	private void createCaches() {
		log.debug("createCaches service");

		CacheConfiguration<Integer, Person> personCacheConfig = new CacheConfiguration<>("person-cache");
		personCacheConfig.setIndexedTypes(Integer.class, Person.class);
		personCacheConfig.setCacheMode(CacheMode.PARTITIONED);
		personCacheConfig.setSqlSchema("ip");

		ignite.addCacheConfiguration(personCacheConfig);
		ignite.getOrCreateCache(personCacheConfig.getName());
	}

	public void start() {
		createCaches();
		loadCaches();
	}
}
