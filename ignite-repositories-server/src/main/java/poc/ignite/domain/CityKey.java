package poc.ignite.domain;

import org.apache.ignite.cache.affinity.AffinityKeyMapped;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityKey {
	private int id;
	@AffinityKeyMapped
	private String counrtyCode;
}
