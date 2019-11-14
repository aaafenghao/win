package com.example.demo.xml;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;



public class XmlParse {
	
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.webxml.com.cn/WebServices/TrainTimeWebService.asmx/getStationAndTimeByStationName?StartStation=%E5%8C%97%E4%BA%AC&ArriveStation=%E4%B8%8A%E6%B5%B7&UserID=");
		URLConnection openConnection = url.openConnection();
		InputStream inputStream = openConnection.getInputStream();
		String res = new String(IOUtils.toByteArray(inputStream));
//		System.out.println(res);
		XmlParse.resolve(res);
	}
	
	public static void resolve(String wsdl) throws Exception {
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		
//		InputStream in = new ByteArrayInputStream(wsdl.getBytes("UTF-8"));
//		InputStreamReader isr = new InputStreamReader(in, "utf-8");
//
//	    InputSource is = new InputSource(isr);
//	    Document document = builder.parse(is);
		
		Document document = DocumentHelper.parseText(wsdl);
		Element root = document.getRootElement();
		Element diffgr = root.element("diffgram");
		Element getStationAndTime = diffgr.element("getStationAndTime");
		@SuppressWarnings("unchecked")
		List<Element> elements = getStationAndTime.elements("TimeTable");
		for (int i = 0; i < elements.size(); i++) {
			Element item = elements.get(i);
			String TrainCode = item.element("TrainCode").getStringValue();
			String FirstStation = item.element("FirstStation").getStringValue();
			String LastStation = item.element("LastStation").getStringValue();
			String StartStation = item.element("StartStation").getStringValue();
			String StartTime = item.element("StartTime").getStringValue();
			String ArriveStation = item.element("ArriveStation").getStringValue();
			String ArriveTime = item.element("ArriveTime").getStringValue();
			String KM = item.element("KM").getStringValue();
			String UseDate = item.element("UseDate").getStringValue();
			System.out.println(String.format("%s %s %s %s %s %s %s %s %s", TrainCode,FirstStation,LastStation,
					StartStation,StartTime,ArriveStation,ArriveTime,KM,UseDate));
		}
	    
	
	} 

}
