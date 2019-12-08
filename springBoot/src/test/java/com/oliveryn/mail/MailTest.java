package com.oliveryn.mail;

import com.oliveryn.utils.SendMailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void test1(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("你好");
        message.setTo("1710779902@qq.com");
        message.setFrom("oliver_yeung@163.com");

        mailSender.send(message);
    }

    @Test
    public void test2()throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setText("<h1>我套你猴子</h1>",true);
        messageHelper.setTo("1710779902@qq.com");
        messageHelper.setFrom("oliver_yeung@163.com");

        //上传文件
        messageHelper.addAttachment("aaa.jpg",new File("F:\\aaa.jpg"));
        mailSender.send(mimeMessage);
    }

    @Test
    public void test3(){
        Map<String, String> map = SendMailUtil.packMap("hello world!", "1710779902@qq.com", "oliver_yeung@163.com");
        try {
            SendMailUtil.sendText(mailSender,map);
        }catch (Exception e){
            System.out.println("发送失败！");
        }
        System.out.println("发送成功!");
    }

    @Test
    public void test4(){
        Map<String, String> map = SendMailUtil.packMap("1234", "327062279@qq.com", "oliver_yeung@163.com", "aaa.jpg", "F:\\aaa.jpg");
        try {
            SendMailUtil.sendAttachment(mailSender,map);
        }catch (Exception e){
            System.out.println("发送失败！");
        }
        System.out.println("发送成功！");
    }
}
