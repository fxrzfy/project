package com.util;


import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA算法，实现数据的加密解密。
 * @author ShaoJiang
 *
 */
public class RSAUtil {
	
	private static Cipher cipher;
	
	static{
		try {
			cipher = Cipher.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成密钥对
	 * @param filePath 生成密钥的路径
	 * @return
	 */
	public static Map<String,String> generateKeyPair(String filePath){
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			// 密钥位数
			keyPairGen.initialize(1024);
			// 密钥对
			KeyPair keyPair = keyPairGen.generateKeyPair();
			// 公钥
			PublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
			// 私钥
			PrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
			//得到公钥字符串
			String publicKeyString = getKeyString(publicKey);
			//得到私钥字符串
			String privateKeyString = getKeyString(privateKey);
			//将密钥对写入到文件
//			FileWriter pubfw = new FileWriter(filePath+"/publicKey.keystore");
//			FileWriter prifw = new FileWriter(filePath+"/privateKey.keystore");
//			BufferedWriter pubbw = new BufferedWriter(pubfw);
//			BufferedWriter pribw = new BufferedWriter(prifw);
//			pubbw.write(publicKeyString);
//			pribw.write(privateKeyString);
//			pubbw.flush();
//			pubbw.close();
//			pubfw.close();
//			pribw.flush();
//			pribw.close();
//			prifw.close();
			//将生成的密钥对返回
			System.out.println(publicKeyString);
			System.out.println(privateKeyString);
			Map<String,String> map = new HashMap<String,String>();
			map.put("publicKey",publicKeyString);
			map.put("privateKey",privateKeyString);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到公钥
	 * 
	 * @param key
	 *            密钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}
	
	/**
	 * 得到私钥
	 * 
	 * @param key
	 *            密钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	/**
	 * 得到密钥字符串（经过base64编码）
	 * 
	 * @return
	 */
	public static String getKeyString(Key key) throws Exception {
		byte[] keyBytes = key.getEncoded();
		String s = (new BASE64Encoder()).encode(keyBytes);
		return s;
	}   	
	
	/**
	 * 使用公钥对明文进行加密，返回BASE64编码的字符串
	 * @param publicKey
	 * @param plainText
	 * @return
	 */
	public static String encrypt(PublicKey publicKey,String plainText){
		try {			
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] enBytes = cipher.doFinal(plainText.getBytes());			
			return (new BASE64Encoder()).encode(enBytes);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 使用keystore对明文进行加密
	 * @param publicKeystore 公钥文件路径
	 * @param plainText      明文
	 * @return
	 */
	public static String encrypt(String publicKeystore,String plainText){
		try {			
			FileReader fr = new FileReader(publicKeystore);
			BufferedReader br = new BufferedReader(fr);
			String publicKeyString="";
			String str;
			while((str=br.readLine())!=null){
				publicKeyString+=str;
			}
			br.close();
			fr.close();
			cipher.init(Cipher.ENCRYPT_MODE,getPublicKey(publicKeyString));
			byte[] enBytes = cipher.doFinal(plainText.getBytes());			
			return (new BASE64Encoder()).encode(enBytes);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	/**
	 * 使用私钥对明文密文进行解密
	 * @param privateKey
	 * @param enStr
	 * @return
	 */
	public static String decrypt(PrivateKey privateKey,String enStr){
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] deBytes = cipher.doFinal((new BASE64Decoder()).decodeBuffer(enStr));
			return new String(deBytes);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 使用keystore对密文进行解密
	 * @param privateKeystore  私钥路径
	 * @param enStr	                                     密文
	 * @return
	 */
	public static String decrypt(String privateKeystore,String enStr){
		try {
			FileReader fr = new FileReader(privateKeystore);
			BufferedReader br = new BufferedReader(fr);
			String privateKeyString="";
			String str;
			while((str=br.readLine())!=null){
				privateKeyString+=str;
			}
			br.close();
			fr.close();			
			cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(privateKeyString));
			byte[] deBytes = cipher.doFinal((new BASE64Decoder()).decodeBuffer(enStr));
			return new String(deBytes);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static final String PUBKEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPLX2jc7VhHKsd8mO4BkRF6JkZXJ5WMngo8PNC"+
			"bYxbx8f8cBMbTN3eO9pp6NicW9CCcEo6X9eure6YbQu0bNBrrqOkpFUWGl6bAc+8qFsoPIAghCMx"+
			"OAMN+ORga/eAiOfjhrRayNAR0DAHueVsBP5Z6UKL0yzgB6rZxVrwCOmTsQIDAQAB";
	private static final String PRIKEY="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI8tfaNztWEcqx3yY7gGREXomRlc"+
			"nlYyeCjw80JtjFvHx/xwExtM3d472mno2Jxb0IJwSjpf166t7phtC7Rs0Guuo6SkVRYaXpsBz7yo"+
			"Wyg8gCCEIzE4Aw345GBr94CI5+OGtFrI0BHQMAe55WwE/lnpQovTLOAHqtnFWvAI6ZOxAgMBAAEC"+
			"gYA9+1B/ePDVSIbfYPZATR4zMV1NuGWnJRQVjTGR2UDA3ry5kH8E+4K02S5VWQKkta6POTM5EBKb"+
			"wRogDFzbz5ttzJSULVBOneTWos4QAMJme3tSj8eNM8JaNN9mJ7Gc5z7ZYhriLNseKrttn3NfJSeI"+
			"ViYhYwxNHLV1+bn8S5uVHQJBAMK2zn8O9ElChjE4AiRA0FggQGTGfWDW+8cE3UweQ3/bd5MtOL/V"+
			"S67QaSRpByqJTdHHX+JJUAmToN4qaSdV+EsCQQC8PhyOLKjyrBjuwqLXKvGrD26wkGNb4b8Y5CHD"+
			"HkUxlVqEyFLhazaLQa1NUU+0/tHN2MiVdWnjFnw3F1oHrt5zAkAi+atF72256xUnqiPYVzwVWFW4"+
			"xF6pEnTPXvRRQ+5j/QwRh8H1015w3EbGn4cGAPvVfraecwTJc5cl0QBqbGrZAkEAjv97/8ELYrW7"+
			"hvzSaTPVPAZQJs64u97EpWr//tIq7ByyE7Z9x4IDgEwXE2oWa787r+zjiy4Tjw/QsqUJnlaH4wJA"+
			"NJ28Cmc5A2DG3VNLqzNMeHO4nC1FeD4vps+Asc7PNPMoGCVuL6aE4Ur1b9KZxQiGsR2xOIoN9tXW"+
			"6NLYUk2+kQ==";
	
	public static String decrypt(String enStr){
		try {
			cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(PRIKEY));
			byte[] deBytes = cipher.doFinal((new BASE64Decoder()).decodeBuffer(enStr));
			return new String(deBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	public static String encrypt(String plainText){
		try {
			cipher.init(Cipher.ENCRYPT_MODE,getPublicKey(PUBKEY));
			byte[] enBytes = cipher.doFinal(plainText.getBytes());			
			String enstr= (new BASE64Encoder()).encode(enBytes);
//			enstr= enstr.replace("\n","");
//			enstr= enstr.replace("\r\n","");
			enstr=enstr.replaceAll("(\r\n|\r|\n|\n\r)", "");  
			return enstr;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		String s=Base64.encodeBase64URLSafeString(encrypt("你好").getBytes());

		System.out.println(s);
		System.out.println(new String(decrypt(new String(Base64.decodeBase64(s)))));
		//generateKeyPair(null);
		System.out.println(encrypt("123456"));
		//System.out.println(decrypt("AH8ZswI9f8fxWLqt8Cjar+6FOHKsKldvTz+RmNFJ2ovjKwLYURLu7NT+/0oLWVsvh5mHneSDWgktAZ1aQSqqwb9/lj1bSq9ry5PYRS18qiYB38S436Lz5pUCeRouvQYvR9RDExYB5CBIUatBgUI34DNu62nIjtUS/5fPOjAYkqA="));
		System.out.println(decrypt(encrypt("你好")));
	}

}
