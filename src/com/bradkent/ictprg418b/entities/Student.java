package com.bradkent.ictprg418b.entities;

public class Student 
{
	private String m_Name;
	
	// Primary School have dedicated seating per student!
	private int m_Across;
	private int m_Down;
	
	// Getters 
	public String getM_Name() { return m_Name  ; }
	public int getM_Across () { return m_Across; }
	public int getM_Down   () { return m_Down  ; }
	
	// Setters ~ Do not allow setting of name!
	//public void setM_Name  (String m_Name) { this.m_Name   = m_Name  ; }
	public void setM_Across(int m_Across ) { this.m_Across = m_Across; }
	public void setM_Down  (int m_Down   ) { this.m_Down   = m_Down  ; }
}
