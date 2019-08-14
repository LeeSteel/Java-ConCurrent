package com.steellee.cn.concurrent.locks;

import java.util.concurrent.locks.LockSupport;

/**
 * 
 * @Title: LockSupportTest2.java
 * @Package com.steellee.cn.concurrent.locks
 * @Description: LockSupport 类的测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2019年7月14日 下午1:24:55
 * @version V1.0
 * @Copyright: Copyright (c) 2019
 * 
 */
public class LockSupportDemo3 {

	/**
	 * 
	 * @Title: main   
	 * @Description: 主方法
	 * @author: 李钢 2580704698@qq.com     
	 * @date:   2019年8月14日 下午10:36:10 
	 * @param args
	 * @throws InterruptedException      
	 * @return: void
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			System.out.println("child thread begin park !");
			// 循环调用 park 方法,挂起自己,只有被中断才会退出循环
			while (!Thread.currentThread().isInterrupted()) {
				// 调用LockSupport 方法 挂起自己
				LockSupport.park();
			}
			System.out.println("child thread unpark !");
		});
		// 启动子线程
		thread.start();

		// 主线程休眠1秒
		Thread.sleep(1000L);
		System.out.println("main thread begin unpark !");

		// 中断子线程
		thread.interrupt();

	}

}
