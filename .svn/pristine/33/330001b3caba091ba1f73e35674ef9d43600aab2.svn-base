package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * <p>
 * Title:SmsUtil
 * </p>
 * <p>
 * Description: 通过短信接口发送短信
 * </p>
 * <p>
 * Company:shentie
 * </p>
 * 
 * @author ：lzw
 * @date ：2016年3月11日下午11:02:16
 * @version：V1.0.0
 */
public class SmsUtil {
	/**
	 * 杭州普讯网络短信接口
	 * @param mobile
	 * @param sms
	 * @return 0：失败；1：成功
	 */
	public static int sendSms(String mobile, String sms) {
		HttpClient client = new HttpClient();
		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		String sendstr = ConfigUtil.get("sms.realsend");
		if(!"true".equals(sendstr)){//模拟发短信
			return 1;
		}
		PostMethod method = new PostMethod(ConfigUtil.get("sms.host")); // 测试环境

		method.addRequestHeader("Connection", "close");
		method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=GBK");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String usr = ConfigUtil.get("sms.usr");
		String pwd = ConfigUtil.get("sms.pwd");
		String extdsrcid = "";

		NameValuePair[] param = { new NameValuePair("usr", usr), new NameValuePair("pwd", pwd), new NameValuePair("mobile", mobile), new NameValuePair("sms", sms), new NameValuePair("extdsrcid", extdsrcid) };

		// 将表单的值放入postMethod中
		method.setRequestBody(param);

		// 执行postMethod
		int statusCode = 0;
		try {
			statusCode = client.executeMethod(method);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// HttpClient对于要求接受后继服务的请求，像POST和PUT等不能自动处理转发
		if (statusCode != HttpStatus.SC_OK) {
			//logger.info("Tianjin,Method failed:" + method.getStatusLine());
			return 0;
		}

		// 读取内容
		InputStream resInputStream = null;
		try {
			resInputStream = method.getResponseBodyAsStream();
			// 处理内容
			BufferedReader reader = new BufferedReader(new InputStreamReader(resInputStream));
			String tempBf = null;
			StringBuffer html = new StringBuffer();
			while ((tempBf = reader.readLine()) != null) {
				html.append(tempBf);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
		//logger.info("result:" + html.toString());
	}

	// —————————————————————————————————————

	public static void main(String[] args) {

		sendSms("13588756278", "您的验证码是：1111。请不要把验证码泄露给其他人。");
		// sendSmsAll(List<PageData> list)

		// sendSms1();
	}

	// 短信商 一 http://www.dxton.com/
	// =====================================================================================
	/**
	 * 给一个人发送单条短信
	 * 
	 * @param mobile
	 *            手机号
	 * @param code
	 *            短信内容
	 */
	public static void sendSms1(String mobile, String code) {

		String account = "", password = "";
		String strSMS1 = Tools.readTxtFile(Const.SMS1); // 读取短信1配置
		if (null != strSMS1 && !"".equals(strSMS1)) {
			String strS1[] = strSMS1.split(",fh,");
			if (strS1.length == 2) {
				account = strS1[0];
				password = strS1[1];
			}
		}
		String PostData = "";
		try {
			PostData = "account=" + account + "&password=" + password + "&mobile=" + mobile + "&content=" + URLEncoder.encode(code, "utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("短信提交失败");
		}
		// System.out.println(PostData);
		String ret = SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
		System.out.println(ret);
		/*
		 * 100 发送成功 101 验证失败 102 手机号码格式不正确 103 会员级别不够 104 内容未审核 105 内容过多 106
		 * 账户余额不足 107 Ip受限 108 手机号码发送太频繁，请换号或隔天再发 109 帐号被锁定 110 发送通道不正确 111
		 * 当前时间段禁止短信发送 120 系统升级
		 */

	}

	public static String SMS(String postData, String postUrl) {
		try {
			// 发送POST请求
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setUseCaches(false);
			conn.setDoOutput(true);

			conn.setRequestProperty("Content-Length", "" + postData.length());
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(postData);
			out.flush();
			out.close();

			// 获取响应状态
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("connect failed!");
				return "";
			}
			// 获取响应内容体
			String line, result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			while ((line = in.readLine()) != null) {
				result += line + "\n";
			}
			in.close();
			return result;
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return "";
	}

	// ===================================================================================================================

	/**
	 * 
	 * 短信商 二 http://www.ihuyi.com/
	 * ==============================================
	 * =======================================
	 * 
	 */
	private static String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";

	/**
	 * 给一个人发送单条短信
	 * 
	 * @param mobile
	 *            手机号
	 * @param code
	 *            短信内容
	 */
	public static void sendSms2(String mobile, String code) {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

		String content = new String(code);

		String account = "", password = "";
		String strSMS2 = Tools.readTxtFile(Const.SMS2); // 读取短信2配置
		if (null != strSMS2 && !"".equals(strSMS2)) {
			String strS2[] = strSMS2.split(",fh,");
			if (strS2.length == 2) {
				account = strS2[0];
				password = strS2[1];
			}
		}

		NameValuePair[] data = {// 提交短信
		new NameValuePair("account", account), new NameValuePair("password", password), // 密码可以使用明文密码或使用32位MD5加密
				new NameValuePair("mobile", mobile), new NameValuePair("content", content), };

		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult = method.getResponseBodyAsString();

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);

			if (code == "2") {
				System.out.println("短信提交成功");
			}

		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 给多个人发送单条短信
	 * 
	 * @param list
	 *            手机号验证码
	 */
	public static void sendSmsAll(List<PageData> list) {
		String code;
		String mobile;
		for (int i = 0; i < list.size(); i++) {
			code = list.get(i).get("code").toString();
			mobile = list.get(i).get("mobile").toString();
			sendSms2(mobile, code);
		}
	}
	// =================================================================================================

}
