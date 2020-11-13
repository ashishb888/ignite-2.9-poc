package poc.ignite;

import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import poc.ignite.domain.Person;

public class Test {

	public static void main(String[] args) throws Exception {
		TreeMap<Integer, Person> map = new TreeMap<>();
		
		map.put(101, new Person(101, "p 101"));
		map.put(102, new Person(101, "p 102"));
		map.put(103, new Person(101, "p 103"));
		
		System.out.println(map);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String s = mapper.writeValueAsString(map);
		
		System.out.println(s);
	}

}
