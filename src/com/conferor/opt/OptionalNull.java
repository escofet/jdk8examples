package com.conferor.opt;

import java.util.Optional;

public class OptionalNull {
	public static void main(String[] args) {
		// Optional as an alternative to null (for present or not elements)
		String nullStr = "albert";
		
		try {
			if(nullStr.contains("al")) {
				System.out.println(String.format("%s contains al", nullStr));
			}
		} catch (NullPointerException ex) {
			System.out.println("Some logging here");
		}
		
		Optional<String> myOptionalStr = Optional.ofNullable(nullStr);
		
		myOptionalStr.ifPresent(System.out::println);
		
		System.out.println(myOptionalStr.orElse("Default String"));
	}
}
