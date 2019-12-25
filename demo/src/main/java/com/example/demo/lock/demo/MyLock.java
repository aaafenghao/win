package com.example.demo.lock.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *     自定义锁
 * @author pc
 *
 */
public class MyLock implements Lock {
	
	private Helper helper = new Helper();
	
	public ReentrantLock lock = new ReentrantLock();
	
	/**
	 *  辅助类
	 * @author pc
	 *
	 */
	private class Helper extends AbstractQueuedSynchronizer{

		@Override
		protected boolean tryAcquire(int arg) {
			int state = getState();
			if(state == 0) {
				if(compareAndSetState(0, arg)) {
					setExclusiveOwnerThread(Thread.currentThread());
					return true;
				}
			}else if(getExclusiveOwnerThread() == Thread.currentThread()) {
				setState(state+arg);
				return true;
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int arg) {
			int state = getState()-arg;
			if(state == 0) {
				setExclusiveOwnerThread(null);
				setState(state);
				return true;
			}
			setState(state);//锁还没有释放
			return false;
		}
		
		public Condition newConditionObject() {
			return new ConditionObject();
		}
		
	}

	@Override
	public void lock() {
		helper.acquire(1);
		
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		helper.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return helper.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return helper.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		helper.tryRelease(1);
		
	}

	@Override
	public Condition newCondition() {
		return helper.newConditionObject();
	}

}
