package com.ren;

import java.io.*;

public class TestIO
{
	public static void main(String []args)
	{
		File file=new File("E:/ttq.txt");
		try
		{
			InputStreamReader is=new InputStreamReader(System.in);
			BufferedReader in=new BufferedReader(is);
			

                        FileWriter fw=new FileWriter(file);
			
			PrintWriter qq=new PrintWriter(fw);
			
			String s=in.readLine();
			
			while(!s.equals(""))
			{
				qq.println(s);
				s=in.readLine();
			}
			in.close();
			fw.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}