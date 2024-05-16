package ru.makarov.springcourse.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.makarov.springcourse.models.Person;

import java.util.List;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import ru.makarov.springcourse.models.Person;

@Component
public class PersonDAO {
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	  public PersonDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Person> index() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("select p from Person p", Person.class).getResultList();
		
	     
	    }

//	  public Optional<Person> show(String email) {
//	        return jdbcTemplate.query("SELECT * FROM Person WHERE email=?", new Object[]{email},
//	                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
//	    }
	
	@Transactional(readOnly=true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }
	
	  @Transactional
	    public void save(Person person) {
	        Session session = sessionFactory.getCurrentSession();
	        session.save(person);
	    }

	 @Transactional
	    public void update(int id, Person updatedPerson) {
	        Session session = sessionFactory.getCurrentSession();
	        Person personToBeUpdated = session.get(Person.class, id);

	        personToBeUpdated.setName(updatedPerson.getName());
	        personToBeUpdated.setAge(updatedPerson.getAge());
	        personToBeUpdated.setEmail(updatedPerson.getEmail());
	        personToBeUpdated.setAddress(updatedPerson.getAddress());
	    }

	 @Transactional
	    public void delete(int id) {
	        Session session = sessionFactory.getCurrentSession();
	        session.remove(session.get(Person.class, id));
	    }
}
