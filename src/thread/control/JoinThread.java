package thread.control;

public class JoinThread extends Thread
{
	int startN;
	int sum;
	
	public JoinThread(int N)	{
		this.startN = N;
		sum = 0;
	}
	
	public void run() {
		for (int i = startN; i < 2000+startN ; i++ )
		{
//			System.out.println(this.getName()+ " is running");
			sum += i;
		}
	}
	
	public int getSum() {
		return sum;
	}
	
	
	public static void main(String[] args)throws Exception
	{
		int sum = 0;
		JoinThread[] ts = new JoinThread[5];
		for (int i = 0; i < 5 ; i++ )
		{
			ts[i] = new JoinThread(i*2000);
			ts[i].start();
			// main线程调用了jt线程的join()方法，main线程
			// 必须等jt执行结束才会向下执行
//			ts[i].join();
//			sum += ts[i].getSum();
		}
		
		for (int i = 0; i < 5 ; i++ )
		{
			ts[i].join();
			System.out.println(ts[i].isAlive());
			sum += ts[i].getSum();
		}
		System.out.println("sum is : " +  sum);
	}
}
