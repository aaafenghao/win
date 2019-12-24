package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpTest {
	
	public static void main(String[] args) throws Exception{
		String httpGet = HttpTest.httpGet("http://192.168.103.30:8750/ms-business-script-param/default/master/dev/rpa/script/flow4/flow4_read_pub_data.json");
		System.out.println(httpGet);
	}

	  public static String httpGet(String url) throws Exception{
	        String line;
	        StringBuffer sb=new StringBuffer();
	        BufferedReader in = null;
	        String urlNameString = url;
	        URL realUrl = new URL(urlNameString);
	        // 打开和URL之间的连接
	        URLConnection conn = realUrl.openConnection();
	        // 设置通用的请求属性 设置请求格式
	        conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
	        //设置超时时间,单位为ms
	        conn.setConnectTimeout(10000);
	        conn.setReadTimeout(10000);
	        // 建立实际的连接
	        conn.connect();
	        System.out.println( conn.getContentEncoding());
	        // 定义 BufferedReader输入流来读取URL的响应,设置接收格式
	        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        while ((line = in.readLine()) != null) {
	            sb.append(line);
	        }
	        if (in != null) {
	            in.close();
	        }
	        return sb.toString();
	    }
}
