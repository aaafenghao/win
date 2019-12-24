package com.example.demo.source;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	
	static final int MAXIMUM_CAPACITY = 1 << 30;
	
	
	
	public static void main(String[] args) {
//		int tableSizeFor = HashMapTest.tableSizeFor(33);
//		System.out.println(tableSizeFor);
		Map<Integer,String> aa = new HashMap<Integer, String>();
	}
	/**
	 * 先无符号右移,然后按位或
	 *
	 * @param cap
	 * @return
	 */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;//9   0000 1001
        n |= n >>> 1;   //0000 1001 >>>1 = 0000 0100|0000 1001 = 0000 1101 = 2^0 + 2^2 + 2^3 = 13
        n |= n >>> 2;   //0000 1101 >>>2 = 0000 0011|0000 1101 = 0000 1111 = 2^0 + 2^1 + 2^2 + 2^3 = 15
        n |= n >>> 4;   //0000 1111 >>>4 = 0000 0000|0000 1111 = 0000 1111 = 2^0 + 2^1 + 2^2 + 2^3 = 15
        n |= n >>> 8;   //0000 1111 >>>8 = 0000 0000|0000 1111 = 0000 1111 = 2^0 + 2^1 + 2^2 + 2^3 = 15
        n |= n >>> 16;  //0000 1111 >>>16 = 0000 0000|0000 1111 = 0000 1111 = 2^0 + 2^1 + 2^2 + 2^3 = 15
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
