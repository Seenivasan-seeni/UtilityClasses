package dsa;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockEg {

	ReentrantLock lock = new ReentrantLock();

	void perform() {
		lock.lock(); // 1st lock
		try {
			System.out.println("Lock is acquired for the Thread - " + Thread.currentThread().getName());
			callNextMethod();
		} finally {
			lock.unlock(); // Here, the counter value becomes 0 and next thread will start to acquire the thread
			System.out.println("Lock is released for the Thread - " + Thread.currentThread().getName());
		}
	}

	private void callNextMethod() {
		lock.lock();// 2nd lock for the same thread. It will increase only the counter value in the reentrant lock.
		try {
			System.out.println("Next method is called by using the same lock - " + Thread.currentThread().getName());
		} finally {
			lock.unlock(); // one thread lock is released. So the counter value will be decreased to 1.
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
