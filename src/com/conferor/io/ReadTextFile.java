package com.conferor.io;
/*
Read Text File in Java 8
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ReadTextFile {
	public static void main(String[] args) throws IOException {
		String filename = "resources/passwords.txt";
		System.out.println(readFileInString(filename));
		System.out.println("*****************************************************************");
		System.out.println(readFileByLine(filename));
		System.out.println("*****************************************************************");
		System.out.println(readFileInStreaming(filename));
		System.out.println("*****************************************************************");
		System.out.println(readFileInBuffer(filename));
		System.out.println("*****************************************************************");
		System.out.println(readFileSkipBlanks(filename));
	}
	
	public static String readFileInString(String filename) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filename)));
	}
	
	public static String readFileByLine(String filename) throws IOException {
		StringJoiner joiner = new StringJoiner("\n");
		Files.lines(Paths.get(filename)).forEach(line -> {
			joiner.add(line);
		});
		return joiner.toString();
	}
	
	public static String readFileInStreaming(String filename) throws IOException {
		return Files.lines(Paths.get(filename)).collect(Collectors.joining("\n"));
	}
	
	public static String readFileInBuffer(String filename) throws IOException {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
			return br.lines().collect(Collectors.joining("\n"));
		}
	}
	
	public static String readFileSkipBlanks(String filename) throws IOException {
		return Files.lines(Paths.get(filename))
			.map(line -> line.trim())
			.filter(line -> !line.isEmpty())
			.collect(Collectors.joining("\n"));
	}
}
