package com.pratap.contributors.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component
public class ContributorUtil {

	private final static Random RANDOM = new SecureRandom();
	private final static String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int LENGTH = 8;
	
	
	
	public static Supplier<String> idGeneratedSupplier = () -> {
	
		StringBuilder returnVal = new StringBuilder(LENGTH);
		
		for(int i = 0; i < LENGTH; i++) {
			returnVal.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(returnVal);
	};
	
}
