package com.main.service;

import java.io.File;

public interface IMailService {

	public void sendEmail(String to, String subject, String message);

	public void sendEmail(String to[], String subject, String message);

	public void sendEmailWithHtml(String to, String subject, String htmlContent);

	public void sendEmailWithFile(String to, String subject, String message, File file);

}
