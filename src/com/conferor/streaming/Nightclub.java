package com.conferor.streaming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.conferor.helper.Person;
import com.conferor.helper.PersonPredicates;

public class Nightclub {
	public static void main(String[] args) {
		List<Person> lineup = Arrays.asList(
			new Person("Mike", 28, 100.0),
			new Person("Ron", 22, 120.0),
			new Person("Enma", 19, 110.0)
		);
		
		// Check who can enter the club: age > 20 & got enough money
		lineup.stream()
			.filter(p -> p.getAge() > 20 && p.getAvailableMoney() > 40)
			.forEach(p -> System.out.println(p.getName() + " can enter the club"));
		
		// Check if in old enough for the club
		lineup.stream()
			.filter(isOlderThan(20))
			.forEach(p -> System.out.println(p.getName() + " can enter the club"));
		
		/*
		More general solution with predicates
		First, explicit predicate as lambda:
		*/
		System.out.println("Person with n in their name");
		PersonPredicates.filterPersonsByCriterion(
			lineup,
			p -> p.getName().contains("n")
		).forEach(System.out::println);
		
		// Secondly, existing list of declared predicates 
		List<Predicate<Person>> myPredicates = Arrays.asList(
			PersonPredicates.isOlderThan(20),
			PersonPredicates.hasEnoughMoney(30)
		);
		System.out.println("Persons older than 20 and with enough money to pay");
		PersonPredicates.filterPersonsByCriteria(lineup, myPredicates)
			.forEach(System.out::println);;
	}
	
	public static Predicate<Person> isOlderThan(int age) {
        return p -> p.getAge() > age;
    }
}
