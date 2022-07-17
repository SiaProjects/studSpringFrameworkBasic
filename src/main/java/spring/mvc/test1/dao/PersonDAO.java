package spring.mvc.test1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import spring.mvc.test1.models.Person;

@Component
public class PersonDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PersonDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Person> index() {
		return jdbcTemplate.query("SELECT * FROM studPerson", new PersonMapper());
	}

	
	public Person show(int id) {
		return jdbcTemplate.query("SELECT * FROM studPerson WHERE id = ?", new PersonMapper(), id)
				.stream().findAny().orElse(null);
	}

	public void save(Person person) {
		jdbcTemplate.update("INSERT INTO studPerson VALUES(1, ?, ?, ?)", 
				person.getName(), person.getAge(), person.getEmail());
	}

	public void update(int id, Person updatePerson) {
		jdbcTemplate.update("UPDATE studPerson SET namePesron = ?, age = ?, email = ? WHERE id = ?", 
				updatePerson.getName(), updatePerson.getAge(), updatePerson.getEmail(), id);	
	}

	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM studPerson WHERE id = ?", id);
	}

}
