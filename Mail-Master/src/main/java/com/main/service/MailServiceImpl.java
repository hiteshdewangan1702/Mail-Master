package com.main.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements IMailService {

	@Autowired
	private JavaMailSender mail;
	private Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

	@Override
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setFrom("hiteshdewangan3777@gmail.com");
		msg.setSubject(subject);
		msg.setText(message);
		mail.send(msg);
		logger.info("email has been sent to " + to);
	}

	@Override
	public void sendEmail(String[] to, String subject, String message) {
		for (String s : to) {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(s);
			msg.setFrom("hiteshdewangan3777@gmail.com");
			msg.setSubject(subject);
			msg.setText(message);
			mail.send(msg);
			logger.info("email has been sent to : " + s);
		}
	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
		MimeMessage mimeMessage = mail.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setTo(to);
			helper.setFrom("hiteshdewangan3777@gmail.com");
			helper.setSubject(subject);
			helper.setText(htmlContent, true);
			mail.send(mimeMessage);
			logger.info("email has been sent to : " + to);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, File file) {
		MimeMessage msg = mail.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo(to);
			helper.setFrom("hiteshdewangan3777@gmail.com");
			helper.setText(message);
			helper.setSubject(subject);
//			FileSystemResource res = new FileSystemResource(file);
//			helper.addAttachment(res.getFilename(), file);
			helper.addAttachment(file.getName(), file);
			mail.send(msg);
			logger.info("email has been sent to : " + to);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
