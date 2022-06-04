package hust.soict.dsai.aims;

public class MemoryDaemon implements Runnable {
	private long memoryUsed = 0;
	Thread t;
	public MemoryDaemon() {
		// TODO Auto-generated constructor stub
		t = new Thread(this,"Thread");
		t.start();
	}

	@Override
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
		
		while (true) {
			used = rt.totalMemory() - rt.freeMemory();
			if (used != memoryUsed) {
				System.out.println("\tMemory used = " + used);
				memoryUsed = used;
			}
		}
	}

}
