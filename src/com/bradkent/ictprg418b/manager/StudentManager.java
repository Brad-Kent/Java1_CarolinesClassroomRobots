package com.bradkent.ictprg418b.manager;

import com.bradkent.ictprg418b.doa.DataBase;

public class StudentManager
{
	// Singleton Design Pattern
	private static StudentManager instance = new StudentManager();
	
	// Constructors 
	private StudentManager() {}
	
	// Getters 
	public static StudentManager getInstance()
	{
		return instance;
	}
	
	public String[][] getData()
	{
		return DataBase.randomAccessFile();
	}
	

}
