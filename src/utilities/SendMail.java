package utilities;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class SendMail {

	
	
	public static String to="koppanadham.manojkumar@gmail.com",cc="k.mahendra52@gmail.com",subject="",attachmentPath="",attachmentPath1="";
	
	@Test
	public static void sendMailReport() throws Exception
	{
		subject="Pobyt Service calls Submitted Test Results";
		attachmentPath=System.getProperty("user.dir")+"\\test-output\\emailable-report.html" ;
		//attachmentPath=System.getProperty("user.dir")+"/MailTemplates/ADCWeekendReport.html" ;
		attachmentPath1=System.getProperty("user.dir")+"\\src\\testngReports\\ScreenShots\\dashBordfuturesVerfying07-10-18-11-05-03.png";
		
		String userName="manojstriker.testing@gmail.com";
		String passWord= "manoj1993striker";
		String host="smtp.gmail.com";
		String port="465";
		String starttls="true";
		String auth="true";
		boolean debug=true;
		String socketFactoryClass="javax.net.ssl.SSLSocketFactory";
		String fallback="false";


		//Object Instantiation of a properties file.
		Properties props = new Properties();
		props.put("mail.smtp.user", userName);
		props.put("mail.smtp.host", host);

		if(!"".equals(port)){
			props.put("mail.smtp.port", port);
		}

		if(!"".equals(starttls)){
			props.put("mail.smtp.starttls.enable",starttls);
			props.put("mail.smtp.auth", auth);
		}

		if(debug){
			props.put("mail.smtp.debug", "true");
		}
		else{
			props.put("mail.smtp.debug", "false");
		}

		if(!"".equals(port)){
			props.put("mail.smtp.socketFactory.port", port);
		}

		if(!"".equals(socketFactoryClass)){
			props.put("mail.smtp.socketFactory.class",socketFactoryClass);
		}

		if(!"".equals(fallback)){
			props.put("mail.smtp.socketFactory.fallback", fallback);
		}

		try{

			//Session session = Session.getDefaultInstance(props, null);

			
			
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication(userName, passWord);
			    }
			});
			
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(subject);

			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			DataSource source = new FileDataSource(attachmentPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			multipart.addBodyPart(messageBodyPart);
			
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			DataSource source1 = new FileDataSource(attachmentPath1);
			messageBodyPart1.setDataHandler(new DataHandler(source1));
			messageBodyPart1.setFileName("PobytServiceCallsStatusReport.xlsx");
			multipart.addBodyPart(messageBodyPart1);

			msg.setContent(multipart);
			msg.setFrom(new InternetAddress(userName));

			msg.addRecipients(Message.RecipientType.TO, to);
			msg.addRecipients(Message.RecipientType.CC, cc);
			msg.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(host, userName, passWord);
			
			System.out.println("connected mail ");
			
			transport.sendMessage(msg, msg.getAllRecipients());
			
			transport.close();
			System.out.println("Mail Sent");
		} 

		catch (Exception e){
			e.printStackTrace();
							
		}
	}
}
