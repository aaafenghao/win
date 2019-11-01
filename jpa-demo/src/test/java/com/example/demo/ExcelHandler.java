package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.demo.utils.ExcelUtils;

public class ExcelHandler {
	
	public static void main(String[] args) throws IOException {
		int j = 5100;
		String sql1 = "INSERT INTO `t_node_param_info` VALUES (%s, NOW(), 10, '1970-01-01 00:00:00', 0, 0, '1970-01-01 00:00:00', 10, '1', '', 'flow1', 'flow1_node4', '%s', '%s','%s', '', '', '', '');";
		String sql2 = "INSERT INTO `t_node_param_info` VALUES (%s, NOW(), 10, '1970-01-01 00:00:00', 0, 0, '1970-01-01 00:00:00', 10, '1', '', 'flow1', 'flow1_node6', '%s', '%s', '%s', '', '', '');";
		String sql = "INSERT INTO `t_flow_param_info` VALUES ('%s', '2018-05-16 19:25:56', '10', '2018-05-16 20:01:09', '0', '10', '1970-01-01 00:00:00', '10', '', 'flow1', '%s');";
		List<List<Object>> readExcelFirstSheet = ExcelUtils.readExcelFirstSheet(new File("D:/节点参数维护_修改后.xls"));
		for (int i = 1; i < readExcelFirstSheet.size(); i++) {
			List<Object> item = readExcelFirstSheet.get(i);
			Object object = item.get(1);//套账号
			Object filePath = item.get(2);
			Object fileName = item.get(3);
//			System.out.println(String.format(sql, j+1,object.toString()));
//			System.out.println(String.format(sql1, j+1,object.toString(),fileName.toString(),filePath.toString()));
			System.out.println(String.format(sql2, j+1,object.toString(),fileName.toString(),filePath.toString()));
			j=j+1;
		}
	}
	

	 



}
