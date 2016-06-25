package network.UDP;

import java.net.*;
import java.util.Random;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class TestUDPClient2 extends JFrame implements Runnable, ActionListener {
	Button b = new Button("获取图像");
	ImageCanvas canvas;

	TestUDPClient2() {
		super("Client");
		setSize(540, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.addActionListener(this);
		add(b, BorderLayout.NORTH);
		canvas = new ImageCanvas();
		add(canvas, BorderLayout.CENTER);
		validate();
		setVisible(true);
		
		Thread thread = new Thread(this);
		thread.start();
	}

	public void actionPerformed(ActionEvent event)      
	{
		byte b[]="请发图像".trim().getBytes();
	    try{
	    	InetAddress address=InetAddress.getByName("127.0.0.1");
	    	DatagramPacket data= new DatagramPacket(b, b.length, address, 1234);//创建数据包，该数据包的目标地址和端口分别是address和1234，其中的数据为数组b中的全部字节。
	    	DatagramSocket mailSend= new DatagramSocket(); //创建负责发送数据的DatagramSocket对象。
	    	mailSend.send(data);  // mailSend发送数据data。
   		}
	    catch(Exception e){}
	}	
	
	public void run()                              
	{
		DatagramPacket pack=null;
	    DatagramSocket mailReceive=null;
	    byte b[]=new byte[8192];
	    ByteArrayOutputStream out=new ByteArrayOutputStream();
	    try{
	    	pack=new DatagramPacket(b,b.length);
//	    	int port = (new Random()).nextInt(20000)+1024;
//	    	System.out.println(port);
	    	mailReceive = new DatagramSocket(1234); //创建在端口5678负责收取数据包的DatagramSocket对象。
	    	while(true) {
	    		mailReceive.receive(pack); 
	    		String message = new String(pack.getData(), 0, pack.getLength());
	    		if(message.startsWith("end"))
	    			break;
	    		out.write(pack.getData(),0,pack.getLength());
	    	}
	    	byte imagebyte[]=out.toByteArray();
	    	System.out.println(imagebyte.length);
	    	out.close();
	    	Toolkit tool=getToolkit();
	    	Image image=tool.createImage(imagebyte);
	    	canvas.setImage(image);
	    	canvas.repaint();
	    	validate();
	    } catch(IOException e){}
	}

	public static void main(String args[]) {
		new TestUDPClient2();
	}
}

class ImageCanvas extends Canvas {
	Image image = null;

	public ImageCanvas() {
		setSize(200, 200);
	}

	public void paint(Graphics g) {
		if (image != null)
			g.drawImage(image, 0, 0, this);
	}

	public void setImage(Image image) {
		this.image = image;
	}
}