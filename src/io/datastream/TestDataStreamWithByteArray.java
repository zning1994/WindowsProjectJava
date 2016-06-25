package io.datastream;

/**
Q��Ϊ���ṩ�ڴ���������ֱ���������أ�
*/
import java.io.*;
public class TestDataStreamWithByteArray {
	public static void main(String[] args) {
		//���ڴ�������д�����ݣ��ڵ����ڴ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			//д���ڴ�����
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);

			//���ڴ������ж�ȡ����
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			System.out.println("�����ֽ���Ϊ��" + bais.available());

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