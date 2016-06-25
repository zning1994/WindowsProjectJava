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
				JoinThread0 jt = new JoinThread0("��Join���߳�");
				jt.start();
				// main�̵߳�����jt�̵߳�join()������main�߳�
				// �����jtִ�н����Ż�����ִ��
				jt.join(); 
			}
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
		}
	}
}
