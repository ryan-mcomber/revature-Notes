package com.revature;

public class BasicSpellChecker {
	public void checkSpelling(String emailMessage) {
		if (emailMessage!=null) {
			System.out.println("Checking Spelling...");
			System.out.println("Spell check complete");
		}else {
			throw new RuntimeException("An exception occured while checking spelling.");
		}
	}
}
