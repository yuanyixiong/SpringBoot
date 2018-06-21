package online.shixun.demo.eshop.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Java Mail 使用QQ邮件客户端发送邮件
 */
public final class JavaMailUtile_QQ {

    /**
     * 连接QQ邮箱
     *
     * @param username 发件人QQ邮箱账号
     * @param password 发件人QQ邮箱密码,需要开启QQ邮箱POP3/SMTP服务所提供的授权码
     * @throws GeneralSecurityException
     */
    private static Session connectionMail(String username, String password) throws GeneralSecurityException {
        // 指定发送邮件的主机为,QQ 邮件服务器 smtp.qq.com
        String host = "smtp.qq.com";
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        //关于QQ邮箱，还要设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        // 获取默认session对象
        return Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、密码
                return new PasswordAuthentication(username, password);
            }
        });
    }

    /**
     * 发送文本邮件
     *
     * @param tos      收件人QQ邮箱地址
     * @param from     发件人QQ邮箱地址
     * @param username 发件人QQ邮箱账号
     * @param password 发件人QQ邮箱密码,需要开启QQ邮箱POP3/SMTP服务所提供的授权码
     * @param title    邮件标题
     * @param text     邮件文本
     * @throws Exception
     */
    public static void sendText(List<String> tos, String from, String username, String password, String title, String text) throws GeneralSecurityException, MessagingException {
        //登陆邮箱
        Session session = connectionMail(username, password);

        // 创建默认的 MimeMessage 对象。
        MimeMessage message = new MimeMessage(session);
        // Set From: 头部头字段
        message.setFrom(new InternetAddress(from));
        // Set To: 头部头字段
        Address[] addresses = new Address[tos.size()];
        for (int i = 0; i < tos.size(); i++) {
            addresses[i] = new InternetAddress(tos.get(i));
        }
        message.addRecipients(Message.RecipientType.TO, addresses);
        // Set Subject: 头字段
        message.setSubject(title);
        // 邮件显示的文本
        message.setText(text);
        // 发送消息
        Transport.send(message);
    }

    /**
     * 发送文本邮件
     *
     * @param to       收件人QQ邮箱地址
     * @param from     发件人QQ邮箱地址
     * @param username 发件人QQ邮箱账号
     * @param password 发件人QQ邮箱密码,需要开启QQ邮箱POP3/SMTP服务所提供的授权码
     * @param title    邮件标题
     * @param text     邮件文本
     * @throws Exception
     */
    public static void sendText(String to, String from, String username, String password, String title, String text) throws GeneralSecurityException, MessagingException {
        List<String> tos = new ArrayList<>();
        tos.add(to);
        JavaMailUtile_QQ.sendText(tos, from, username, password, title, text);
    }

    /**
     * 发送附件邮件
     *
     * @param tos      收件人QQ邮箱地址
     * @param from     发件人QQ邮箱地址
     * @param username 发件人QQ邮箱账号
     * @param password 发件人QQ邮箱密码,需要开启QQ邮箱POP3/SMTP服务所提供的授权码
     * @param title    邮件标题
     * @param text     邮件文本
     * @param text     附件
     * @throws Exception
     */
    public static void sendFile(List<String> tos, String from, String username, String password, String title, String text, List<String> filenames) throws GeneralSecurityException, MessagingException {

        //登陆邮箱
        Session session = connectionMail(username, password);

        // 创建默认的 MimeMessage 对象。
        MimeMessage message = new MimeMessage(session);
        // Set From: 头部头字段
        message.setFrom(new InternetAddress(from));
        // Set To: 头部头字段
        Address[] addresses = new Address[tos.size()];
        for (int i = 0; i < tos.size(); i++) {
            addresses[i] = new InternetAddress(tos.get(i));
        }
        message.addRecipients(Message.RecipientType.TO, addresses);
        // Set Subject: 头字段
        message.setSubject(title);

        // 创建多重消息
        Multipart multipart = new MimeMultipart();

        // 创建消息-文本部分
        BodyPart textPart = new MimeBodyPart();
        textPart.setText(text);
        multipart.addBodyPart(textPart);

        // 创建消息-附件部分
        for (String filename : filenames) {
            MimeBodyPart partFile = new MimeBodyPart();
            partFile.setDataHandler(new DataHandler(new FileDataSource(filename)));
            partFile.setFileName(filename);
            multipart.addBodyPart(partFile);
        }

        // 发送完整消息
        message.setContent(multipart);
        //发送消息
        Transport.send(message);
    }

    /**
     * 发送附件邮件
     *
     * @param to       收件人QQ邮箱地址
     * @param from     发件人QQ邮箱地址
     * @param username 发件人QQ邮箱账号
     * @param password 发件人QQ邮箱密码,需要开启QQ邮箱POP3/SMTP服务所提供的授权码
     * @param title    邮件标题
     * @param text     邮件文本
     * @param text     附件
     * @throws Exception
     */
    public static void sendFile(String to, String from, String username, String password, String title, String text, List<String> filenames) throws GeneralSecurityException, MessagingException {
        List<String> tos = new ArrayList<>();
        tos.add(to);
        JavaMailUtile_QQ.sendFile(tos, from, username, password, title, text, filenames);
    }


    /**
     * 发送连接邮件
     *
     * @param tos      收件人QQ邮箱地址
     * @param from     发件人QQ邮箱地址
     * @param username 发件人QQ邮箱账号
     * @param password 发件人QQ邮箱密码,需要开启QQ邮箱POP3/SMTP服务所提供的授权码
     * @param title    邮件标题
     * @param html     html标签
     * @throws Exception
     */
    public static void sendHTML(List<String> tos, String from, String username, String password, String title, String html) throws GeneralSecurityException, MessagingException {

        //登陆邮箱
        Session session = connectionMail(username, password);

        // 创建默认的 MimeMessage 对象。
        MimeMessage message = new MimeMessage(session);
        // Set From: 头部头字段
        message.setFrom(new InternetAddress(from));
        // Set To: 头部头字段
        Address[] addresses = new Address[tos.size()];
        for (int i = 0; i < tos.size(); i++) {
            addresses[i] = new InternetAddress(tos.get(i));
        }
        message.addRecipients(Message.RecipientType.TO, addresses);
        // Set Subject: 头字段
        message.setSubject(title);
        // 发送 HTML 消息, 可以插入html标签
        message.setContent(html, "text/html;charset=UTF-8");
        // 发送消息
        Transport.send(message);
    }

    /**
     * 发送连接邮件
     *
     * @param to       收件人QQ邮箱地址
     * @param from     发件人QQ邮箱地址
     * @param username 发件人QQ邮箱账号
     * @param password 发件人QQ邮箱密码,需要开启QQ邮箱POP3/SMTP服务所提供的授权码
     * @param title    邮件标题
     * @param html     html标签
     * @throws Exception
     */
    public static void sendHTML(String to, String from, String username, String password, String title, String html) throws GeneralSecurityException, MessagingException {
        List<String> tos = new ArrayList<>();
        tos.add(to);
        JavaMailUtile_QQ.sendHTML(tos, from, username, password, title, html);
    }

}
