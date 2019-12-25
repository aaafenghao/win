package com.example.demo.collection;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.TreeMap;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TreeMapTest {
	
	public static void main(String[] args) {
		TreeMap<String, String> tree = new TreeMap<String, String>();
		
		int pid = TreeMapTest.getPid();
		System.out.println("当前进程ID:"+pid);
		
	    Node node = new Node();
	    node.setId("1");
	    node.setName("fenghao");
	    
//	    ToStringStyle defaultStyle = ToStringBuilder.getDefaultStyle();
//	    System.out.println(defaultStyle);
	    System.out.println("------------------");
	    String reflectionToString = ToStringBuilder.reflectionToString(node,ToStringStyle.NO_CLASS_NAME_STYLE);
	    System.out.println(reflectionToString);
	}
	
	static class Node{
		String id;
		String name;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	public static int getPid() {
		RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
		String name = runtime.getName();
		System.out.println(name);
		return Integer.parseInt(name.split("@")[0]);
	}

}
