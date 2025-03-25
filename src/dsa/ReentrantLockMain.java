package dsa;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockEg {

	ReentrantLock lock = new ReentrantLock();

	void perform() {
		lock.lock();
		try {
			System.out.println("Lock is acquired for the Thread - " + Thread.currentThread().getName());
			callNextMethod();
		} finally {
			lock.unlock();
			System.out.println("Lock is released for the Thread - " + Thread.currentThread().getName());
		}
	}

	private void callNextMethod() {
		lock.lock();
		try {
			System.out.println("Next method is called by using the same lock - " + Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}

	}

}

public class ReentrantLockMain {

	public static void main(String[] args) {
		ReentrantLockEg relock = new ReentrantLockEg();
		Runnable task = () -> {
			relock.perform();
		};
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(task, "Thread " + i);
			t.start();
		}

	}

}
