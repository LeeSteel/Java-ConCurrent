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
public class LockSupportTest2 {

	/**
	 * @throws InterruptedException
	 * @Title: main @Description: 主方法 @param: @param args @return: void @throws
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			System.out.println("child thread begin park !");
				// 调用LockSupport 方法 挂起自己
				LockSupport.park();
			System.out.println("child thread unpark !");
		});
		// 启动子线程
		thread.start();

		// 主线程休眠1秒
		Thread.sleep(1000L);
		System.out.println("main thread begin unpark !");

		// 调用unpark 方法让 子线程获取到 许可证
		LockSupport.unpark(thread);

	}

}
