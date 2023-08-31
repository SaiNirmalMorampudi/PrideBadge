package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.person.Person;
import com.example.demo.person.service.PersonService;

@SpringBootApplication
public class CollectionsInJpaApplication implements CommandLineRunner {
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(CollectionsInJpaApplication.class, args);
	}

	@Override 
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//createPersons(); 
		getPersonByIds();
		
	}
	 
	private void createPersons() {
		List<Person> personList=Arrays.asList( 	//this is more optimal than new ArrayList();
		new Person("Kiran","Kumar","kiran@gmail.com",20),
		new Person("Ram","Kumar","ram@gmail.com",20),
		new Person("Lakshman","Kumar","lak@gmail.com",20),
		new Person("Ganesh","Kumar","ganesh@gmail.com",20)
		);
		 
		Iterable<Person> list=personService.saveAllPersons(personList);
		
		for(Person person:list) {
			System.out.println("person object: "+person.toString());
		}
		
	}
	
	private void getPersonByIds() {
		List<Integer> personList=new ArrayList<Integer>();
		personList.add(1);
		personList.add(2);
		personList.add(12);
		personList.add(5);
		personList.add(6);
		personList.add(20);
		personList.add(40);
		personList.add(11);
		personList.add(15);
		personList.add(3);
		personList.add(4);
		Iterable<Person> personsList=personService.getAllPersonByIds(personList);
		for(Person person: personsList ) {
			System.out.println("person obj: "+person.toString());
		}
	
	}
}
