package com.email.service;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;
@Service
public class EmailService {

	public boolean sendEmail(String subject, String message, String to) {
		
		boolean f = false;
		String from="swaggerjack889@gmail.com";
		
		// variable for gmail host ---> smtp.gmail.com
     	String host ="smtp.gmail.com";
     	
     	//get the system properties
     	Properties properties = System.getProperties();
     	System.out.println("PROPERTIES "+properties);
     	
     	//setting important info to properties object
     	
     	//set host
     	properties.put("mail.smtp.host", host);
     	properties.put("mail.smtp.port", "465");
     	properties.put("mail.smtp.ssl.enable", "true");
     	properties.put("mail.smtp.auth", "true");
     	
     	//Step 1: to get the session object...
     	Session session= Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("swaggerjack889@gmail.com", "Brahma@1998"); 
			}
		
     	
     	});
     	
     	session.setDebug(true);
     	 
     	//step2:  compose the message (text, image/audio/video)
     	MimeMessage m = new MimeMessage(session);
     	
     	
     	
     	try {
     		//from email
     		m.setFrom(from);
     		
     		//adding receipent to msg
     		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
     		
     		//adding subject to msg
     		m.setSubject(subject);
     		
     		//adding text to message
     		m.setText(message);
     		
     		
     		//send
     		//step3: send the message using transport class
     		Transport.send(m);
     		
     		System.out.println("Sent Success....................");
     		f = true;
     		
     		
     		
     	} catch (Exception e) {
     		
			e.printStackTrace();
		}
     	    
       		return f;
     		  		
     }
     	
	
}
