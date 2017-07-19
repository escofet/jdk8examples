package com.sopra.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListDir {
	public static void main(String[] args) {
		printDir(".");
		
		printAllFiles(".");
	}
	
	public static void printDir(String rootPath) {
		String[] paths = new File(rootPath).list();
		for(String path : paths) {
			if( Files.isDirectory(Paths.get(path), LinkOption.NOFOLLOW_LINKS) ) {
				System.out.println(String.format("%40s is a directory", path));
			} else {
				System.out.println(String.format("%40s is a file", path));
			}
		}
	}
	
	public static void printAllFiles(String rootPath) {
		try(Stream<Path> paths = Files.walk(Paths.get(rootPath))) {
		    paths.filter(Files::isRegularFile)
		        .forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("Some logging here!!");
		}
	}
}
