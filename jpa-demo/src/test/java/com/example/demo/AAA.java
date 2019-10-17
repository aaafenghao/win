package com.example.demo;

public class AAA {
	
	public static void main(String[] args) {
		String aa = "INSERT INTO ACT_GE_BYTEARRAY(ID_, REV_, NAME_, DEPLOYMENT_ID_, ?, GENERATED_) VALUES ('990007', 1, 'flow6.flow6.png', '990005', 'abc', 1);";
		String[] split = aa.split("VALUES");
		String[] split2 = split[1].split(",");
		String id = split2[0].trim();
		System.out.println(id.substring(2,id.length()-1));
	}

}
