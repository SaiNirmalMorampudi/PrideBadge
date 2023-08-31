package com.example.demo.person.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.person.Person;

@Repository
public interface PersonDao extends CrudRepository<Person,Integer>{

	Iterable<Person> findByLastNameOrFirstName(String lastName, String firstName);

	Person findByLastNameAndFirstName(String lastName, String firstName);

	List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);

	List<Person> findByAgeLessThanEqual(Integer age);

	List<Person> findByFirstNameLike(String firstName);

	List<Person> findByLastNameAndAgeLessThanEqual(String lastName, int age);

	List<Person> findByCreatedDateBetween(Date startdate, Date endDate);

}
