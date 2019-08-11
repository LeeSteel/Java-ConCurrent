package com.steellee.cn.concurrent.locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * 
 * @Title: ReentrantLockList.java
 * @Package com.steellee.cn.concurrent.locks
 * @Description: 通过可重入锁实现一个线程安全的List
 * @author: 李钢 2580704698@qq.com
 * @date: 2019年7月24日 下午10:36:58
 * @version V1.0
 * @Copyright: Copyright (c) 2019
 *
 */
public class ReentrantLockOptimizeList {
	/**
	 * 线程不安全的 List
	 */
	private ArrayList<String> array = new ArrayList();
	/**
	 * 独占锁
	 */
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	/**
	 *  读锁
	 */
	private final Lock readLock = lock.readLock();
	/**
	 * 	写锁
	 */
	private final Lock writeLock = lock.writeLock();

	/**
	 * 添加元素
	 * 
	 * @Title: add
	 * @Description: 添加元素
	 * @param e
	 * @return: void
	 */
	public void add(String e) {
		writeLock.lock();
		try {
			array.add(e);

		} finally {
			writeLock.unlock();
		}

	}

	/**
	 * 删除元素
	 * 
	 * @Title: remove
	 * @Description: 删除元素
	 * @param: e
	 * @return: void
	 */
	public void remove(String e) {
		writeLock.lock();
		try {
			array.remove(e);
		} finally {
			writeLock.unlock();
		}

	}

	/**
	 * 获取元素
	 * 
	 * @Title: get
	 * @Description: 获取元素
	 * @param: index
	 * @param: @return
	 * @return: String
	 */
	public String get(int index) {
		readLock.lock();
		try {
			return array.get(index);
		} finally {
			readLock.unlock();
		}

	}

}
