package com.example.demo.redis;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

public class RedisLock {
	
	public static void main(String[] args) throws Exception{
		RedissonClient create = Redisson.create();
		RLock lock = create.getLock("test");
		lock.tryLock(10, TimeUnit.SECONDS);
		lock.lock();
	}

}
