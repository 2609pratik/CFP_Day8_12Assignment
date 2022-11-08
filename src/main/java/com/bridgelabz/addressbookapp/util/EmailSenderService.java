package com.bridgelabz.addressbookapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailsender;
	
	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message=new SimpleMailMessage();
//		try {
			message.setFrom("pratikbhagadkar2609@gmail.com");
			message.setTo(toEmail);
			message.setText(body);
			message.setSubject(subject);
			mailsender.send(message);
//		}catch(Exception e) {
//		 }
		System.out.println("Mail sent to the User...!");
		
	}
}