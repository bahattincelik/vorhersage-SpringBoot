package com.example.vorhersageSpringBoot.service;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HailoServiceTest {
	@Autowired
	private HailoService hailoService;

	@Test
	public void createRandom() {
		int expected = 123;
		int actual = hailoService.createRandom();

		assertEquals(expected, actual);
	}
}
