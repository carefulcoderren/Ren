package com.ren;//目的:使用get方法发送请求并将响应存储到本地
//如果返回的头信息没有指定长度或长度大于1M则抛出如上异常。
//则需把 getResponseBodyAsString（）换成 getResponseBodyAsStream（）即可
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
public class HttpTest {
	
	public static void main(String[] s)
	{
		//建立客户端
		HttpClient client = new HttpClient();
		//创建一个get方法
		GetMethod getmethod = new GetMethod("http://www.baidu.com");
		int StateCode = 0;
		InputStream in = null;//响应结果的流
		String reresult = null;//流中对result的读取
		BufferedWriter bufw = null;
		BufferedReader bufr = null;
		try {
			//发送请求获得响应
			StateCode = client.executeMethod(getmethod);
			if(StateCode==200)//此状态码代表请求成功
			{
				//System.out.println("response="+getmethod.getResponseBodyAsString());//显示响应信息
				in = getmethod.getResponseBodyAsStream();
				bufw = new BufferedWriter(new FileWriter("D:/1.txt"));//将响应保存到本地
				bufr = new BufferedReader(new InputStreamReader(in));//将字节流in变为字
				reresult = bufr.readLine();
				while(reresult!=null)
				{
					bufw.write(reresult);
					reresult = bufr.readLine();
					bufw.newLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
