package com.ren;//Ŀ��:ʹ��get�����������󲢽���Ӧ�洢������
//������ص�ͷ��Ϣû��ָ�����Ȼ򳤶ȴ���1M���׳������쳣��
//����� getResponseBodyAsString�������� getResponseBodyAsStream��������
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
		//�����ͻ���
		HttpClient client = new HttpClient();
		//����һ��get����
		GetMethod getmethod = new GetMethod("http://www.baidu.com");
		int StateCode = 0;
		InputStream in = null;//��Ӧ�������
		String reresult = null;//���ж�result�Ķ�ȡ
		BufferedWriter bufw = null;
		BufferedReader bufr = null;
		try {
			//������������Ӧ
			StateCode = client.executeMethod(getmethod);
			if(StateCode==200)//��״̬���������ɹ�
			{
				//System.out.println("response="+getmethod.getResponseBodyAsString());//��ʾ��Ӧ��Ϣ
				in = getmethod.getResponseBodyAsStream();
				bufw = new BufferedWriter(new FileWriter("D:/1.txt"));//����Ӧ���浽����
				bufr = new BufferedReader(new InputStreamReader(in));//���ֽ���in��Ϊ��
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
