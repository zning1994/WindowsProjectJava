package thread.control;


import java.util.*;

public class SleepTest
{
	public static void main(String[] args)
	{
		try {
			for (int i = 0; i < 10 ; i++ )
			{
				System.out.println("当前时间: " + new Date());
				// 调用sleep方法让当前线程暂停1s。
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

