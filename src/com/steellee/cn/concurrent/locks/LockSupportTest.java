package com.steellee.cn.concurrent.locks;

import java.util.concurrent.locks.LockSupport;

/**
 * 
 * @Title: LockSupportTest.java
 * @Package com.steellee.cn.concurrent.locks
 * @Description: LockSupport 类的测试类
 * @author: 李钢 2580704698@qq.com
 * @date: 2019年7月14日 下午1:14:47
 * @version V1.0
 * @Copyright: Copyright (c) 2019
 * 
 */
public class LockSupportTest {

	public static void main(String[] args) {
		System.out.println("begin park!");

		/**
		 * 使用当前线程获取到Locksupport 许可证
		 */
		LockSupport.unpark(Thread.currentThread());

		/**
		 * 如果 调用 park 方法的线程 已经拿到了与 LockSupport 关联的许可证 , 
		 * 则调用LockSupport.park()时会马上返回,
		 * 否则调用线程会被禁止参与线程的调度,也就是会被阻塞挂起
		 */
		LockSupport.park();

		System.out.println("end park!");

	}
}
