package com.edu.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestServletContextListener implements ServletContextListener
{
	public TestServletContextListener()
	{
		System.out.println("TestservletContextListener 按眉 积己");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		System.out.println("ServletContext 按眉 檬扁拳");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		System.out.println("ServletContext 按眉 秦力");
	}
}
