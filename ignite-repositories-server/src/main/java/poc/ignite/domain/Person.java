package poc.ignite.domain;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	@QuerySqlField(index = true)
	private int id;
	@QuerySqlField
	private String name;
}
