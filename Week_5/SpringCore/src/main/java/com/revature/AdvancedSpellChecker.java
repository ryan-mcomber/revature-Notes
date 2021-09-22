package com.revature;

public class AdvancedSpellChecker extends BasicSpellChecker{
	public void checkSpelling(String emailMessage) {
		if (emailMessage!=null) {
			System.out.println("Checking Spelling...");
			System.out.println("Advanced Spell check complete");
		}else {
			throw new RuntimeException("An exception occured while checking spelling.");
		}
	}
}
