package com.arcazer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemoryCheckerTest {

	@Test
	@DisplayName("Useless test for code coverage")
	void testCodeCoverage() {
		assertDoesNotThrow(() -> MemoryChecker.simpleMemoryCheck());
	}

}
