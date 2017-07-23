package com.conferor.helper;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonPredicates {
	public static Predicate<Person> hasEnoughMoney(double minComsumption) {
        return p -> p.getAvailableMoney() >= minComsumption;
    }
	
	public static Predicate<Person> isOlderThan(int age) {
        return p -> p.getAge() > age;
    }
     
    public static List<Person> filterPersonsByCriterion (List<Person> persons, Predicate<Person> predicate) {
        return persons.stream()
        		.filter(predicate)
        		.collect(Collectors.toList());
    }
    
    public static List<Person> filterPersonsByCriteria(List<Person> persons, List<Predicate<Person>> predicates) {
    	Predicate<Person> compositePredicate = predicates.stream()
    												.reduce(w -> true, Predicate::and);
    	return persons.stream()
                .filter(compositePredicate)
                .collect(Collectors.toList());
    }
}
