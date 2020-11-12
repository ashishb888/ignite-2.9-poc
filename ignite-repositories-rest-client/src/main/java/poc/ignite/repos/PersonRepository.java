package poc.ignite.repos;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

import poc.ignite.domain.Person;

@RepositoryConfig(cacheName = "person-cache")
@Repository
public interface PersonRepository extends IgniteRepository<Person, Integer> {

}
