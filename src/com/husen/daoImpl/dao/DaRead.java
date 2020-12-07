package com.husen.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DaRead {

	public static void main(String[] args) throws Exception {
		InputStream inputStream = new FileInputStream("Encode2.da");
		byte[] bs = new byte[5];
		 //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //循环取出数据
        Map<Integer, Character> map = new HashMap<Integer,Character>();
        List<Integer> list = new ArrayList<Integer>();
        while ((n = inputStream.read(bs,0,bs.length)) != -1) {
            //转换成字符串
            char str = (char)bs[0];
            byte[] bs2 = new byte[4];
            for(int i=0;i<4;i++) {
            	bs2[i] = bs[i+1];
            }
            
            int j = Byte2Int(bs2);
            list.add(j);
            map.put(j, str);
        }
        Collections.sort(list);
        System.out.println(list);
        for(Integer i:list) {
        	System.out.print(map.get(i));
        }
	}
	.
	public static int Byte2Int(byte[] bytes) {
		return (bytes[0]&0xff)<<24
			| (bytes[1]&0xff)<<16
			| (bytes[2]&0xff)<<8
			| (bytes[3]&0xff);
	}
}
