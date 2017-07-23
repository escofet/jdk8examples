package com.conferor.streaming;
/*
Infitine Streams examples 
*/

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStreams {
	public static void main(String[] args) {
		// Iterator on 20 consecutives integers starting from zero
		List<Integer> intList = Stream.iterate(0, x -> x + 1)
									.limit(20)
									.collect(Collectors.toList());
		intList.forEach(x -> {
			System.out.print(x);
			System.out.print(" ");
		});
		System.out.println();
		
		// Generator of 20 random uuids
		Supplier<UUID> randomUUIDs = UUID::randomUUID;
		List<UUID> uuidList = Stream.generate(randomUUIDs)
									.limit(20)
									.collect(Collectors.toList());
		uuidList.forEach(System.out::println);
		
		// Randon infinite stream of integers (upper bound)
		new Random().ints()
			.peek(System.out::println)
			.anyMatch(x -> x > 1234567890);
	}
}
