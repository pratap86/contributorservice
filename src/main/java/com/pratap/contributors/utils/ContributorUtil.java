package com.pratap.contributors.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class ContributorUtil {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String generatedContributorId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {

		StringBuilder returnVal = new StringBuilder(length);
		
		for(int i = 0; i < length; i++) {
			returnVal.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(returnVal);
	}
}
