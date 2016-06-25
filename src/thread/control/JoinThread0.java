package thread.control;

public class JoinThread0 extends Thread
{
	public JoinThread0(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0; i < 100 ; i++ )
		{
			System.out.println(getName() + "  " + i);
		}
	}
	public static void main(String[] args)throws Exception
	{
		for (int i = 0; i < 100 ; i++ )
		{
			if (i == 20)
			{
				JoinThread0 jt = new JoinThread0("被Join的线程");
				jt.start();
				// main线程调用了jt线程的join()方法，main线程
				// 必须等jt执行结束才会向下执行
				jt.join(); 
			}
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
		}
	}
}
