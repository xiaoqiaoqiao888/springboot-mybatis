package com.rails.lambda;

import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {

		Function<Integer, String> function = e -> {
			return String.valueOf(e + 6);
		};

		String apply = function.apply(6);
		System.out.println(apply);
	}
}
