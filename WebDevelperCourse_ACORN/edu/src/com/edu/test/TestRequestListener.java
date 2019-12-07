package com.edu.test;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class TestRequestListener implements ServletRequestListener
{
	public TestRequestListener()
	{
		System.out.println("TestRequestListener 按眉 积己");
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent sre)
	{
		System.out.println("HttpServletRequest 按眉 檬扁拳");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre)
	{
		System.out.println("HttpservletRequest 按眉 秦力");
	}
	
}
