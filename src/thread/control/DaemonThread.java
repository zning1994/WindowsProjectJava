package thread.control;

public class DaemonThread extends Thread
{
	// �����̨�̵߳��߳�ִ��������ͨ�߳�û���κ�����
	public void run()
	{
		for (int i = 0; i < 1000 ; i++ )
		{
			System.out.println(getName() + "  " + i);
		}
	}
	
	public static void main(String[] args)
	{
		DaemonThread t = new DaemonThread();
		// �����߳����óɺ�̨�߳�
		t.setDaemon(true);
		// ������̨�߳�
		t.start();
		for (int i = 0 ; i < 10 ; i++ )
		{
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
		}
		// -----����ִ�е��˴���ǰ̨�̣߳�main�̣߳�����------
		// ��̨�߳�ҲӦ����֮����
	}
}
