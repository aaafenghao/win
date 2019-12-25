package com.example.demo.xml;

import javax.wsdl.Definition;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;

public class WsdlTest {
	
	public static void main(String[] args) throws Exception {
		WSDLFactory factory = WSDLFactory.newInstance();
		WSDLReader reader = factory.newWSDLReader();
//		reader.setFeature("javax.wsdl.verbose",true);  
//		reader.setFeature("javax.wsdl.importDocuments",true);
		Definition def = reader.readWSDL("http://www.webxml.com.cn/WebServices/TrainTimeWebService.asmx/getStationAndTimeByStationName?StartStation=%E5%8C%97%E4%BA%AC&ArriveStation=%E4%B8%8A%E6%B5%B7&UserID=");
		WSDLWriter writer = factory.newWSDLWriter();
		writer.writeWSDL(def, System.out);
		
	}

}
