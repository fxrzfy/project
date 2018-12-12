package com.mail;

public class TestEmail {
	public static void main(String[] args) {
		// 设置邮件服务器
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("********@163.com");
		mailInfo.setPassword("********");// 您的邮箱密码
		mailInfo.setFromAddress("********@163.com");
		// 设置发送信息
		mailInfo.setToAddress("########@163.com");
		mailInfo.setSubject("设置邮箱标题");
		mailInfo.setContent("设置邮箱内容,点击链接激活</br><a href='http://www.baidu.com'>http://www.baidu.com</a>");

		// 发送邮件,可以循环发送
		// boolean sendFlag = SimpleMailSender.sendTextMail(mailInfo);// 发送文体格式
		boolean sendFlag = SimpleMailSender.sendHtmlMail(mailInfo);// 发送html格式
		if (sendFlag) {
			System.out.println("发送成功!");
		}
	}
}
