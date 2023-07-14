package rbrt.portfolio.example.mail.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(String sendTo, String subject, String message) throws MailException {
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo(sendTo);
        msg.setSubject(subject);
        msg.setText(message);

        javaMailSender.send(msg);
	}

}
