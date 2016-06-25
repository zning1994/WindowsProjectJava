package thread.control;

public class YieldTest extends Thread
{
	public YieldTest(String name)
	{
		super(name);
	}

	public void run()
	{
		for (int i = 0; i < 50 ; i++ )
		{
			System.out.println(getName() + "  " + i);
			// 当i等于20时，使用yield方法让当前线程让步,只会让给优先级更高或者相等的执行
			if (i == 20)
			{
				Thread.yield();
			}
		}
	}
	public static void main(String[] args)throws Exception
	{
		YieldTest yt1 = new YieldTest("High");
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();
		
		YieldTest yt2 = new YieldTest("Low");
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt2.start();
	}
}
