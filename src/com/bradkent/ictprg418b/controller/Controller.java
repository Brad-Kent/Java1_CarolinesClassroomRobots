package com.bradkent.ictprg418b.controller;

import com.bradkent.ictprg418b.manager.StudentManager;
import com.bradkent.ictprg418b.view.ClassRoom;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller extends Application
{
	private String[][] data;
	private ClassRoom m_view;
	private StudentManager manager = StudentManager.getInstance();

	private String[][] students;
	public Controller()
	{
		m_view = new ClassRoom();
		loadData();
		students = new String[data.length - 5][3];
		m_view.getSearchScreen().start();
	}
	// #Region Super Methods 
	public static void launchApp()
	{
		launch(Controller.class);
	}
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		m_view.setUpView(primaryStage);
		
		setUpLabelData();
		setUpStudents();
		setUpButtons();
		setUpPopUpData() ;
	}
	
	// Data Loading and Setting
	private void loadData()
	{
		data = manager.getData();
		if (data == null) {
			System.out.print("Data Array is Null D:");
			return;
		}
//		for(String[] student : data) {
//			for(String sData : student)
//				System.out.print(sData + " ");
//			System.out.println();
//		}
	}
	private void setUpLabelData()
	{
		for(int i = 0; i < 4; i++) {
			m_view.getTopLabels()[i].setText(m_view.getTopLabels()[i].getText() + ": " + data[i][1]);
		}
	}
	private void setUpStudents()
	{
		// X = 10, Y = 18
		// get Student localtion
		int X, Y; String fillKey = "BKGRND FILL";
		for(int i = 4; i < data.length; i++) {
			X = Integer.valueOf(data[i][0]);
			Y = Integer.valueOf(data[i][1]);
			int txtIndex = Y * 10 + X;
			if(data[i][2].equals(fillKey))
				//m_view.getClassroom()[txtIndex].setText("Fill w/ " + data[i][3]);
			    m_view.getClassroom()[txtIndex].setStyle("-fx-background-color: #00b8ff");
			else
				m_view.getClassroom()[txtIndex].setText(data[i][2]);
		}
	}
	
	// Button Events
	private void setUpButtons()
	{
		int i = 0;
		m_view.getButtons()[i++].setOnAction(e -> buttonEvent(e, 0));
		m_view.getButtons()[i++].setOnAction(e -> buttonEvent(e, 1));
		m_view.getButtons()[i++].setOnAction(e -> buttonEvent(e, 2));
		m_view.getButtons()[i++].setOnAction(e -> buttonEvent(e, 3));
		m_view.getButtons()[i++].setOnAction(e -> buttonEvent(e, 4));
		m_view.getButtons()[i++].setOnAction(e -> buttonEvent(e, 5));	
	}
	private void buttonEvent(ActionEvent e, int id)
	{
		// "Clear", "Save", "Sort", "Find", "RAF", "Exit"
		switch(id) {
		case 0:
			clearClassroom();
			break;
		case 1:
			break;
		case 2:
			
			setUpPopUpData();
			break;
		case 3:
			findStudent();
			break;
		case 4:
			break;
		case 5:
			m_view.close();
			break;
		}
	}
	private void findStudent()
	{
		String student = m_view.getSearchTerm();
		int index = 0;
		while(students[index][0]!= null) {
			index++;
		}
		 System.out.println("Index: " + index);
		
	    int low = 0;
	    int high = index - 1;//students.length;
	    int mid = -1;
        
	    while (low <= high) {
	        mid = (low + high) / 2;
	
	        if (students[mid][2].compareToIgnoreCase(student) < 0) 
	            low = mid + 1;
	         else if (students[mid][2].compareToIgnoreCase(student) > 0) 
	            high = mid - 1;
	         else 
	            break;// mid;
	    }
	    if(mid == -1)
	    		return;
	    System.out.println("Found: " + students[mid][2] + " at: " + mid);
	    m_view.getSearchScreen().getGridPane().getChildren().get(mid * 3).setStyle("-fx-background-color: #296097;");
	    m_view.getSearchScreen().getGridPane().getChildren().get(mid * 3 + 1).setStyle("-fx-background-color: #296097;");
	    m_view.getSearchScreen().getGridPane().getChildren().get(mid * 3 + 2).setStyle("-fx-background-color: #296097;");
	}
	private void setUpPopUpData() 
	{
		
	
		String fillKey = "BKGRND FILL";
		int index = 0;
		for(int i = 5; i < data.length - 5; i++) {
			if(data[i][2].equals(fillKey)) {
				while( i < data.length - 5 && data[i][2].equals(fillKey)) {
					i++;
				}
			}else {
				students[index] = data[i]; 
				index++;
			}
		}
		 
		java.util.Arrays.sort(students, new java.util.Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if( o1[0] == null || o2[0] ==  null)
					return 0;
				return o1[2].compareToIgnoreCase(o2[2]);
			}
		});
		
		for(int i = 0; i < index; i++)
			System.out.println(students[i][2]);
		
		Label[][] labels = new Label[index][3];
		for(int i = 0; i < index; i++) {
			for(int y = 0; y < 3; y++) {
				labels[i][y] = new Label(students[i][y]);
				labels[i][y].setMinWidth(80);
				m_view.getSearchScreen().getGridPane().add(labels[i][y], y, i);
			}
		}
		
	}
	private void clearClassroom() 
	{
		for(TextField txt : m_view.getClassroom()) {
			txt.clear(); 
			txt.setStyle(null);
		}
	}
	
}
