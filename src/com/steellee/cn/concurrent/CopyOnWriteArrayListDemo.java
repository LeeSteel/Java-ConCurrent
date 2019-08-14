package com.steellee.cn.concurrent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * 
 * @Title: CopyOnWriteArrayListTest.java
 * @Package com.steellee.cn.concurrent
 * @Description: 这个类是用来验证 CopyOnWriteArrayList 的弱一致性迭代器
 * @author: 李钢 2580704698@qq.com
 * @date: 2019年7月14日 下午1:06:52
 * @version V1.0
 * @Copyright: Copyright (c) 2019
 *
 */
public class CopyOnWriteArrayListDemo {
	private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		
		arrayList.add("hello");
		arrayList.add("alibaba");
		arrayList.add("welcome");
		arrayList.add("to");
		arrayList.add("hangzhou");

		Thread threadOne = new Thread(() -> {
			// 修改list中下标为1的元素
			arrayList.set(1, "baba");
			arrayList.remove(2);
			arrayList.remove(3);
		});

		// 保证在修改线程启动前获取迭代器
		Iterator<String> itr = arrayList.iterator();

		// 启动线程
		threadOne.start();

		// 等待线程执行完毕
		threadOne.join();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
