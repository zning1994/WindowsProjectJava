package thread.control;


import java.util.*;

public class SleepTest
{
	public static void main(String[] args)
	{
		try {
			for (int i = 0; i < 10 ; i++ )
			{
				System.out.println("��ǰʱ��: " + new Date());
				// ����sleep�����õ�ǰ�߳���ͣ1s��
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

