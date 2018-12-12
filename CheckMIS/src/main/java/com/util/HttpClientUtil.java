package com.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSONObject;



public class HttpClientUtil {
	
	/**
	 * 向指定URL发送GET方法的请求
	 * @param url：发送请求的URL
	 * @param param：请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL：所代表远程资源的响应结果
	 * @throws Exception
	 */
	public static String sendGet(String url, String param, String charset) throws Exception {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + (StringUtil.isEmpty(param) ? "" : ("?" + param));
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();//打开和URL之间的连接
			
			//设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			connection.connect();//建立实际的连接
			Map<String, List<String>> map = connection.getHeaderFields();//获取所有响应头字段
			//遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));//定义 BufferedReader输入流来读取URL的响应
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
				result += "\n";
			}
		} catch (Exception e) {
			throw new Exception("发送GET请求出现异常！" + e.getMessage());
		} finally {
			closeBufferedReader(in);
		}
		return result;
	}
	
	public static String sendPostForStream(String url, String param, String charset) throws Exception {
		return sendPostForStream(url, param, charset,null,null);
	}
	
	public static String sendPostForStream(String url, String param, String charset,String encodeType,String contentType) throws Exception {
		DataOutputStream out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();//打开和URL之间的连接
			//设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			if(null!=contentType){
				conn.setRequestProperty("Content-Type",contentType);
			}
			
			//发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			//获取URLConnection对象对应的输出流
			out = new DataOutputStream(conn.getOutputStream());
			byte[] paramBytes = param.getBytes();
			out.write(paramBytes);//发送请求参数
			out.flush();//flush输出流的缓冲
			//定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			throw new Exception("发送POST请求出现异常！" + e.getMessage());
		} finally {
			closeDataOutputStream(out, in);
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * @param url：发送请求的 URL
	 * @param param：请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 * @throws Exception
	 */
	public static String sendPost(String url, String param, String charset) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();//打开和URL之间的连接
			//设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			//发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			out = new PrintWriter(conn.getOutputStream());//获取URLConnection对象对应的输出流
			out.write(param);//发送请求参数
			out.flush();//flush输出流的缓冲
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));//定义BufferedReader输入流来读取URL的响应
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			throw new Exception("发送POST请求出现异常！" + e.getMessage());
		} finally {
			closeStream(out, in);
		}
		
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url：发送请求的 URL
	 * @param param：请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 * @throws Exception
	 */
	public static String sendPost(String url, String param, String charset, String contenttype) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();//打开和URL之间的连接
			
			//设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			if (StringUtil.isEmpty(contenttype)) {
				conn.setRequestProperty("content-type", contenttype);
			}
			
			//发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			out = new PrintWriter(conn.getOutputStream());//获取URLConnection对象对应的输出流
			if(StringUtil.isEmpty(param)){//发送请求参数
				param = "";
			}
			out.write(param);//发送请求参数
			out.flush();//flush输出流的缓冲
			
			//定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			throw new Exception("发送POST请求出现异常！" + e.getMessage());
		} finally {
			closeStream(out, in);
		}
		return result;
	}
	
	public static String sendPost(String url, String param, Map<String,String> header, String charset, String contenttype) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();//打开和URL之间的连接
			
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			if (StringUtil.isEmpty(contenttype)) {
				conn.setRequestProperty("content-type", contenttype);
			}
			if(header != null && !header.isEmpty()){
				for(String key : header.keySet()){
					conn.setRequestProperty(key, header.get(key));
				}
			}
			//发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			out = new PrintWriter(conn.getOutputStream());//获取URLConnection对象对应的输出流
			if(StringUtil.isEmpty(param)){//发送请求参数
				param = "";
			}
			out.write(param);
			out.flush();//flush输出流的缓冲
			
			//定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			throw new Exception("发送POST请求出现异常！" + e.getMessage());
		} finally {
			closeStream(out, in);
		}
		return result;
	}
	public static String sendPostRequestJSON(String requestUrl, String json) {
		/*requestUrl为合作机构提供的接口，json为发送数据*/
		   HttpClient client = new DefaultHttpClient();
		   HttpPost post = new HttpPost(requestUrl);
		   JSONObject response = null;
		   try {
		       String encoderJson = URLEncoder.encode(json.toString(), HTTP.UTF_8);
		       StringEntity string = new StringEntity(encoderJson);
		       string.setContentEncoding("UTF-8");
		       string.setContentType("application/json");
		      
		       post.setEntity(string);
		       HttpResponse res = client.execute(post);
		       if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
		           HttpEntity entity = res.getEntity();
		           InputStreamReader in = new InputStreamReader(entity.getContent(), "utf-8");
		           BufferedReader bufferedReader = new BufferedReader(in);  
		           StringBuilder sv=new StringBuilder();
		           String line=null;
		           while((line=bufferedReader.readLine())!=null){
		        	   sv.append(line);
		           }
		           return sv.toString();
		          // response = new JSONObject(new JSONTokener(new InputStreamReader(entity.getContent(), "utf-8")));
		        }
		     } catch (UnsupportedEncodingException e) {
		            e.printStackTrace();
		     } catch (ClientProtocolException e) {
		            e.printStackTrace();
		     } catch (IOException e) {
		            e.printStackTrace();
		     } catch (IllegalStateException e) {
		            e.printStackTrace();
		     } catch (Exception e) {
		            e.printStackTrace();
		     }
		     return null;
	}
	public static void closeStream(PrintWriter out, BufferedReader in) {
		try {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeBufferedReader(BufferedReader in) {
		try {
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeDataOutputStream(DataOutputStream out, BufferedReader in) {
		try {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}
