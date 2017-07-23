package com.conferor.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.conferor.helper.StringGenerator;

public class CreateTextFile {
	public static void main(String[] args) throws IOException {
		String filename = "resources/passwords.txt";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 20; i++) {
			sb.append(StringGenerator.generateFixedLengthString(10)).append("\t");
			sb.append(StringGenerator.generateDynamicLengthString()).append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		
		toFileClassic(filename, sb.toString());
		toFileNew(filename, sb.toString());
	}
	
	public static void toFileClassic(String filename, String text) throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.write(text);
		}
	}
	
	public static void toFileNew(String filename, String text) throws IOException {
		Files.write(Paths.get(filename), text.getBytes());
	}
}
