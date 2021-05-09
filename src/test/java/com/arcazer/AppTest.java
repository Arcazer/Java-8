package com.arcazer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * learn hamcrest and junit5
 */
class AppTest {

	private int testSupplier() {
		return 2;
	}

	private boolean isEvenCheck(int value) {
		return value % 2 == 0;
	}

	private boolean isOddCheck(int param) {
		return param % 2 != 0;
	}

	@Test
	void testApp() {
		assertThat(2, is(equalTo(testSupplier())));
	}

	/**
	 * Simple parameters
	 * 
	 * @param param
	 */
	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8 })
	@DisplayName("Expressive name for a is number even method check")
	void isEven(int param) {
		assertThat("EvenCheck expected number to be even but is not", isEvenCheck(param));
	}

	/**
	 * More complicated arguments. Passed via MethodSource. MethodSource without
	 * argument will search for Method with the same name.
	 * 
	 * @param param
	 * @param isResultExpected
	 */
	@ParameterizedTest
	@MethodSource
	@DisplayName("Expressive name for a is number odd method check")
	void isOdd(int param, boolean isResultExpected) {
		assertThat("OddCheck expected number to be odd but is not", isOddCheck(param), is(isResultExpected));
	}

	private static Stream<Arguments> isOdd() {
		return Stream.of(
				Arguments.of(3, true),
				Arguments.of(5, true),
				Arguments.of(7, true),
				Arguments.of(9, true),
				Arguments.of(2, false),
				Arguments.of(4, false));

	}

}
