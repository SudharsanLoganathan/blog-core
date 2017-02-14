package com.blog.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.blog.model.Comment;
import com.blog.model.UserDetail;


public class MailUtil {
	private MailUtil() {

	}


	public static void sendSimpleMail(Comment comments,UserDetail receiver,String commenter) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("sudharsan13ece110@gmail.com","abilashr"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setFrom("sudharsan13ece110@gmail.com");
		email.setSubject(commenter +" commented on your article");
		email.setMsg(comments.getComments());
		email.addTo(receiver.getEmailId());
		email.setStartTLSEnabled(true);
		email.send();
		System.out.println("Mail sent!");
	}

	}

