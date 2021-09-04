package com.microservice.socialmultiplication.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RandomGeneratorServiceTest {

	@Autowired
	private RandomGeneratorService randomGeneratorService;

	@SuppressWarnings("deprecation")
	@Test
	public void generateRandomFactorTest() {
		List<Integer> randomFactor = IntStream.range(0, 1000).map(i -> randomGeneratorService.generateRandomFactor())
				.boxed().collect(Collectors.toList());
	
		System.out.println("List is " + randomFactor);
		assertThat(randomFactor).containsOnlyElementsOf(IntStream.range(11,100).boxed().collect(Collectors.toList()));
	}
}