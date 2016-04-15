package com.notification.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
/**
 * 执行入口类，初始化Spring
 * @author Administrator
 *
 */
public class execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");//启动spring容器
	}

}
