package com.revature;

public class EmailClient {
	
	private BasicSpellChecker basicSpellChecker;
	public EmailClient() {
		this.basicSpellChecker = new BasicSpellChecker();
		
	}
	
	public EmailClient(BasicSpellChecker basicSpellChecker) {
		super();
		this.basicSpellChecker = basicSpellChecker;
	}

	void sendEmail(String emailMessage) {
		basicSpellChecker.checkSpelling(emailMessage);
	}

}
