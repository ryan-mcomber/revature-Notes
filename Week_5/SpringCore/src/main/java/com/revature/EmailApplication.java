package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		// to instantiate an Email Client bean
		EmailClient emailClient = applicationContext.getBean("emailClient",EmailClient.class);
		
		//EmailClient emailClient = new EmailClient();
		emailClient.sendEmail("Hi"+"This is my first email.");
		emailClient.sendEmail("Hi"+"This is my second email.");

	}

}
