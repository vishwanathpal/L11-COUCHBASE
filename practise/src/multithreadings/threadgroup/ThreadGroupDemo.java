package multithreadings.threadgroup;

public class ThreadGroupDemo {

	public static void main(String[] args) {

		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		Thread[] t = new Thread[system.activeCount()];
		system.enumerate(t);
		for(Thread ts : t) {
			System.out.println(ts.getName()+"...."+ts.isDaemon());
		}
	}
}