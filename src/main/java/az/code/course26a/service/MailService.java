package az.code.course26a.service;

import az.code.course26a.util.FileConvertUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class MailService {


    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text, MultipartFile file) throws MessagingException, IOException {


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        File imageFile = FileConvertUtil.convertMultipartFileToFile(file);// Add the image attachment
//        File imageFile = new File("/Users/shaiqjafarov/IdeaProjects/Course26A/src/main/resources/gul.png");
        helper.addAttachment(imageFile.getName(), imageFile);

        javaMailSender.send(message);
    }
    public void sendEmail(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }


}
