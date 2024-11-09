package com.main;

import java.io.File;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.service.IMailService;

@SpringBootTest
class MailMasterApplicationTests {

	@Autowired
	IMailService service;

	@Test
	@Disabled
	void senEmail() {
		service.sendEmail("pifihic841@opposir.com", "Test1", "Testing for 1st time");
	}

	@Test
	@Disabled
	void senEmailToMultiplePeople() {
		service.sendEmail(new String[] { "pifihic841@opposir.com", "chinuthecoder@gmail.com" }, "Test2",
				"Sending email to multiple people");
	}

	@Test
	@Disabled
	void sendEmailWithHtml() {
		String htmlContent = "<h1>Its ProCoder</h1>" + "<p style='color:yellow'>I can do anything. I am a ProCoder</p>";
		service.sendEmailWithHtml("chinuthecoder@gmail.com", "Test2", htmlContent);
	}

	@Test
	void sendEmailWithFile() {
		File file = new File("C:/Users/Hitesh_Dewangan/Desktop/New Resume/HITESH DEWANGAN - JD.pdf");
		service.sendEmailWithFile("chinuthecoder@gmail.com", "Test3", "Sending with differnet types of file", file);
	}

}
