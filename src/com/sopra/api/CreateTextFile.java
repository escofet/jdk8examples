package com.sopra.api;

import com.sopra.helper.StringGenerator;

public class CreateTextFile {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.print(StringGenerator.generateFixedLengthString(10));
			System.out.print("\t");
			System.out.println(StringGenerator.generateDynamicLengthString());
		}
	}
}