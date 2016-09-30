package com.ren;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
public class DatabaseConnection01{
	// ����MySQL�����ݿ���������
	public static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	//public static final String DBDRIVER = "src.org.gjt.mm.mysql.Driver" ;
	// ����MySQL���ݿ�����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/mysql" ;
	// MySQL���ݿ�������û���
	public static final String DBUSER = "root" ;
	// MySQL���ݿ����������
	public static final String DBPASS = "root" ;
	public static void main(String args[]){
		Connection conn = null ;		// ���ݿ�����
		try{
			Class.forName(DBDRIVER) ;	// ������������
		}catch(ClassNotFoundException e){
			e.printStackTrace() ;
		}
		try{
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;
		}catch(SQLException e){
			e.printStackTrace() ;
		}
		System.out.println(conn) ;	// �����ʱ���Դ�ӡ��ʾ��������
		try{
			conn.close() ;			// ���ݿ�ر�
		}catch(SQLException e){
			e.printStackTrace() ;
		}
	}
};