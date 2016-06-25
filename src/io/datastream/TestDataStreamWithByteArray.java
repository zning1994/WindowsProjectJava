package io.datastream;

/**
Q：为何提供内存数组流，直接用数组呢？
*/
import java.io.*;
public class TestDataStreamWithByteArray {
	public static void main(String[] args) {
		//往内存数组中写入数据，节点是内存数组
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			//写入内存数组
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);

			//从内存数组中读取数据
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			System.out.println("可用字节数为：" + bais.available());

			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			dos.close();
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}