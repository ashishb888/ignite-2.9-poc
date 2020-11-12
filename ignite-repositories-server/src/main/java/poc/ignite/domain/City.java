package poc.ignite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
	private int id;
	private String counrtyCode;
	private String name;
    private String district;
    private int population;
}
