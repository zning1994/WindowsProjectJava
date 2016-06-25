package thread.lifecycle;

public class StartDead extends Thread
{
	private int i ;
	// ��дrun������run�����ķ���������߳�ִ����
	public void run()
	{
		for ( ; i < 100 ; i++ )
		{
			System.out.println(getName() +  " " + i);
		}
	}
	public static void main(String[] args)
	{
		StartDead sd = new StartDead();
		for (int i = 0; i < 300;  i++)
		{
			System.out.println(Thread.currentThread().getName()	+  " " + i);
			if (i == 20)	{
				// �����߳�
				sd.start();
				// �ж��������̵߳�isAlive()ֵ�����true
				System.out.println(sd.isAlive());
			}
			// ֻ�е��̴߳����½�����������״̬ʱisAlive()��������false��
			// ��i > 20������߳̿϶��Ѿ��������ˣ����sd.isAlive()Ϊ��ʱ��
			// ��ֻ��������״̬�ˡ�
			if (i > 20 && !sd.isAlive())
			{
				// ��ͼ�ٴ��������߳�
				sd.start();
			}
		}
	}
}

