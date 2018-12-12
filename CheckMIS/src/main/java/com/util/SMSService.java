package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.common.util.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;



@Service
public class SMSService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SMSService.class);

	@Value("${sms.gateway}")
	private String gateway = "http://202.91.244.252/puxun/SmsSend";
	@Value("${sms.ext}")
	private String ext = "222222";
	private String host;
	private String scheme;
	private String path;
	@Value("${sms.user_id}")
	private String userId = "6619";
	@Value("${sms.user_pwd}")
	private String userPwd = "sdt~6619";
	private int port;

	@PostConstruct
	public void init() {
		String name = this.getClass().getSimpleName();
		LOGGER.info(name + ":init...");
		try {
			UriComponents uc = UriComponentsBuilder.fromUriString(gateway)
					.build();
			host = uc.getHost();
			scheme = uc.getScheme();
			port = uc.getPort();
			path = uc.getPath();
			LOGGER.info("SMS Gateway:" + uc.toUriString());
			LOGGER.info(name + ":initend");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	private String parseStrToMd5L32(String str){  
        String reStr = null;  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            byte[] bytes = md5.digest(str.getBytes());  
            StringBuffer stringBuffer = new StringBuffer();  
            for (byte b : bytes){  
                int bt = b&0xff;  
                if (bt < 16){  
                    stringBuffer.append(0);  
                }   
                stringBuffer.append(Integer.toHexString(bt));  
            }  
            reStr = stringBuffer.toString();  
        } catch (NoSuchAlgorithmException e) {  
        	LOGGER.error(e.getMessage(), e);  
        }  
        return reStr;  
    }
	
	private String parseStrToMd5U32(String str){  
        String reStr = parseStrToMd5L32(str);  
        if (reStr != null){  
            reStr = reStr.toUpperCase();  
        }  
        return reStr;  
    }

	public void sendMessage(String mobile, String message) {

		LOGGER.debug("sendMessage: ...");

		if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(message)) {
			throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
					"参数不正确");
		}

		try {
			URIBuilder builder = new URIBuilder();
			final URIBuilder uriBuilder = builder.setHost(host)
					.setScheme(scheme).setPath(path).setPort(port);

			DefaultHttpClient client = new DefaultHttpClient();

			// client.getCredentialsProvider().setCredentials(
			// new AuthScope(host, port),
			// new UsernamePasswordCredentials(username, password));

			HttpPost httpPost = new HttpPost(uriBuilder.build());
			httpPost.setHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=GBK");

			StringBuffer entity = new StringBuffer(255);
			entity.append("user_id=").append(userId).append('&');
			entity.append("user_pwd=").append(parseStrToMd5U32(userPwd + "&" + mobile)).append('&');
			entity.append("mobile=").append(new String(Base64.encodeBase64(mobile.getBytes()))).append('&');
//			entity.append("msg_content=")
//					.append(new String(message.getBytes(), "GBK")).append('&');
			entity.append("msg_content=")
					.append(message).append('&');
			entity.append("ext=").append(ext);
  
			httpPost.setEntity(new StringEntity(entity.toString(), "GBK"));

			LOGGER.debug("requestline: {}", httpPost.getRequestLine());
			LOGGER.debug("body: {}", entity.toString());

			final HttpResponse response = client.execute(httpPost);

			int statusCode = response.getStatusLine().getStatusCode();
			LOGGER.debug("Statuscode: {}", statusCode);

			if (statusCode != 200) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"Failed with HTTP error code : " + statusCode);
			}

			// Get the user object from entity
			final HttpEntity replyXML = response.getEntity();

			String reply = EntityUtils.toString(replyXML);

			LOGGER.debug("Reply {}", reply);

			if (reply.startsWith("-100,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-100,短信接口:系统繁忙");
			} else if (reply.startsWith("-101,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-101,短信接口:用户非法或密码不对");
			} else if (reply.startsWith("-102,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-102,短信接口:指定访问ip错误");
			} else if (reply.startsWith("-103,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-103,短信接口:短信内容超过500字或为空");
			} else if (reply.startsWith("-104,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-104,短信接口:余额不足");
			} else if (reply.startsWith("-105,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-105,短信接口:手机号码超过100个或手机号码为空");
			} else if (reply.startsWith("-106,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-106,短信接口:短信内容内有敏感词");
			} else if (reply.startsWith("-107,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-107,短信接口:提交次数过多");
			} else if (reply.startsWith("-108,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-108,短信接口:用户不存在");
			} else if (reply.startsWith("-109,")) {
				throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
						"-109,短信接口:每个短信包手机号码数少于20个");
			}

		} catch (Exception ex) {
			throw new BizServiceException(EErrorCode.COMM_INTERNAL_ERROR,
					"Failed with HTTP call " + ex.getMessage(), ex);
		}
	}
	
//	public String  sendValidCode(String type){
////		type 用来区分验证码类型
//		
//		
//	}

	public static void main(String args[]) {
		SMSService s = new SMSService();
		s.init();
		s.sendMessage("15067163716", "生管系统短信提醒测试！");
	}
}
