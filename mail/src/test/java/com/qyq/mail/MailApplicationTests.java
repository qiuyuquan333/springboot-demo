package com.qyq.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //主题
        message.setSubject("测试邮件");
        //发件人
        message.setFrom("1561719985@qq.com");
        //收件人
        message.setTo("1524078139@qq.com");
        //时间
        message.setSentDate(new Date());
        //正文
        message.setText("这是一段正式文本");
        javaMailSender.send(message);
    }

    @Test
    public void sendAnnexMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("测试邮件主题");
        helper.setFrom("1561719985@qq.com");
        helper.setTo("1524078139@qq.com");
        helper.setSentDate(new Date());
        //添加附件
        helper.addAttachment("G043.jpg",new File("C:\\Users\\ZJY\\Pictures\\G043.jpg"));
        helper.setText("邮件正文-author by QYQ");

        javaMailSender.send(mimeMessage);
    }

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendThymeleafMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("Email 主题");
        helper.setFrom("1561719985@qq.com");
        helper.setTo("1524078139@qq.com");
        helper.setSentDate(new Date());
        helper.addAttachment("QYQ.jpg",new File("C:\\Users\\ZJY\\Pictures\\Heat.jpg"));

        //渲染模板文件
        Context context = new Context();
        context.setVariable("username","YXY");
        context.setVariable("taller","173");
        context.setVariable("weight","60kg");
        String process = templateEngine.process("mail.html", context);
        //设置正文
        helper.setText(process,true);
        javaMailSender.send(mimeMessage);
    }

}
