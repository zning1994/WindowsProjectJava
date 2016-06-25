package network.UDP;

import java.net.*;
import java.util.Random;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class TestUDPClient2 extends JFrame implements Runnable, ActionListener {
	Button b = new Button("��ȡͼ��");
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
		byte b[]="�뷢ͼ��".trim().getBytes();
	    try{
	    	InetAddress address=InetAddress.getByName("127.0.0.1");
	    	DatagramPacket data= new DatagramPacket(b, b.length, address, 1234);//�������ݰ��������ݰ���Ŀ���ַ�Ͷ˿ڷֱ���address��1234�����е�����Ϊ����b�е�ȫ���ֽڡ�
	    	DatagramSocket mailSend= new DatagramSocket(); //�������������ݵ�DatagramSocket����
	    	mailSend.send(data);  // mailSend��������data��
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
	    	mailReceive = new DatagramSocket(1234); //�����ڶ˿�5678������ȡ���ݰ���DatagramSocket����
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