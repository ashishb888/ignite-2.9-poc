package poc.ignite.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Country {
	private String code;
	private String name;
	private String continent;
	private String region;
	private int population;
	private BigDecimal surfaceArea;
	private short indepYear;
	private BigDecimal lifeExpectancy;
	private BigDecimal gnp;
	private BigDecimal gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private int capital;
	private String code2;
}
