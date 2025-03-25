package dsa;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicIntegerObj {

	AtomicInteger c = new AtomicInteger();

	void performTask() {
		System.out.println("C value is " + c.incrementAndGet());
	}
}

public class AtomicIntegerMain {

	public static void main(String[] args) {
		AtomicIntegerObj lockEg = new AtomicIntegerObj();
		Runnable task = () -> {
			lockEg.performTask();
		};
		for (int i = 0; i < 100; i++) {
			Thread t1 = new Thread(task, "Thread " + i);
			t1.start();
		}
	}
}
