package br.edu.ifsp.campus_match_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String from;

	
	public boolean sendMail(String to, String title, String message) {
		
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(this.from);
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(title);
			simpleMailMessage.setText(message);
			javaMailSender.send(simpleMailMessage);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
