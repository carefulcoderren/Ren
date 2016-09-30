package com.ren;
import javax.swing.*;
//我修改了这个文件
import java.awt.*;
import java.io.File;
public class JLabelTest {
	public static void main(String[] s)
	{
		myframe frame = new myframe();
		frame.setBounds(50, 50, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		
	}

}
class myframe extends JFrame
{
	public myframe()
	{
		
		String lujing = "E:" + File.separator + "1.gif";
		Icon ic = new ImageIcon(lujing);
		JLabel label = new JLabel("RenHeng",ic,JLabel.LEFT);
		Font fnt = new Font("Serief",Font.ITALIC,23);
		label.setFont(fnt);
		label.setForeground(Color.white);
		label.setBackground(Color.white);
		this.add(label);
	
		
	}

}