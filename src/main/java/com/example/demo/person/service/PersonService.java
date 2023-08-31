  package com.example.demo.person.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.person.Person;
import com.example.demo.person.dao.PersonDao;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;
	
	public Iterable<Person> saveAllPersons(Iterable<Person> personList){
		return personDao.saveAll(personList); //Inserts if record is not there
	}
	public Iterable<Person> getAllPersonByIds(Iterable<Integer> personIds){
		return personDao.findAllById(personIds); //findAllById can only be us
	}
	public Iterable<Person> findByLastNameOrFirstName(String lastName, String firstName){
		return personDao.findByLastNameOrFirstName(lastName,firstName);
	}
	
	public  Person findByLastNameAndFirstName(String lastName, String firstName) {
		return personDao.findByLastNameAndFirstName(lastName,firstName);
	}
	
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName){
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}
	
	public List<Person> findByAgeLessThanEqual(Integer age){
		return personDao.findByAgeLessThanEqual(age);
	}
	
	public List<Person> findByFirstNameLike(String firstName){
		return personDao.findByFirstNameLike(firstName);
	}
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int age){
		return personDao.findByLastNameAndAgeLessThanEqual(lastName,age);
	}
	public List<Person> findByCreatedDateBetween(Date startdate,Date endDate){
		return personDao.findByCreatedDateBetween(startdate,endDate);
	}
}
 