package spring.mvc.test1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.mvc.test1.models.Person;

public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Person person = new Person();
		
		person.setId(resultSet.getInt("id"));
		person.setName(resultSet.getString("namePesron"));
		person.setAge(resultSet.getInt("age"));
		person.setEmail(resultSet.getString("email"));
		
		return person;
	}
	
}
