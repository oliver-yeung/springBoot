package com.oliveryn.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import tk.mybatis.mapper.common.Mapper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SendMailUtil {

    public static Map<String,String> packMap(String text,String addresser,String recipients){
        Map map = new HashMap();
        map.put("text",text);
        map.put("addresser",addresser);
        map.put("recipients",recipients);
        return map;
    }

    public static Map<String,String> packMap(String text,String addresser,String recipients,String attachmentFileName,String pathName){
        Map map = new HashMap();
        map.put("text",text);                                    //发送文本
        map.put("addresser",addresser);                          //收件人
        map.put("recipients",recipients);                        //发件人
        map.put("attachmentFileName",attachmentFileName);        //副本名称
        map.put("pathName",pathName);                            //副本目录
        return map;
    }
    /**
     *
     * @param mailSender  发送邮件的bean对象
     */
    public static void sendText(JavaMailSenderImpl mailSender,Map<String,String> map){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(map.get("text"));
        message.setTo(map.get("addresser"));
        message.setFrom(map.get("recipients"));

        mailSender.send(message);
    }

    //String text,String recipients,String addresser,String attachmentFileName,String pathName
    public static void sendAttachment(JavaMailSenderImpl mailSender, Map<String,String> map)throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setText(map.get("text"));
        messageHelper.setTo(map.get("addresser"));
        messageHelper.setFrom(map.get("recipients"));

        //上传文件
        messageHelper.addAttachment(map.get("attachmentFileName"),new File(map.get("pathName")));
        mailSender.send(mimeMessage);


    }
}
