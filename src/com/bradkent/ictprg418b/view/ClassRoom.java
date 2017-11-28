package com.bradkent.ictprg418b.view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClassRoom 
{
	// Class Constant Fields
	private static final int M_SCREEN_X = 1100;
	private static final int M_SCREEN_Y = 620;
	private static final String M_APPLICATION_TITLE = "Classroom Robots";
	
	// 1/3 of Applicaiton ~ Classroom Info
	private HBox     m_topLabelRoot;
	private Label [] m_topLabels  = new Label[4];
	private String[] m_labelNames = {"Teacher: ", "Class: ", "Room: ", "Date: "};
	// 2/3 of Applicatioin ~ Classroom Room Layout
	private TextField[] m_classroom = new TextField[ 10 * 19]; // Num of Txt Fields = Columns * Rows 
	private FlowPane m_classroomLayout;
	private VBox     m_rootBranch;
	// 3/3 of Application ~ Buttons that mutate Data
	private HBox m_buttonRoot;
	private Button[] m_dataModBtns     = new Button[6];
	private String[] m_dataModsBtnSyms = {"Clear", "Save", "Sort", "Find", "RAF", "Exit"};
	private TextField m_searchTerm = new TextField();
	
	private PopUp searchScreen = new PopUp();
	
	// FX Application 
	private Scene m_scene;
	private Stage m_stage;
	
	// Entery Point for Controller 
	public void setUpView(Stage primaryStage)
	{
		setUpStage(primaryStage);
	}
	
	public Button   [] getButtons  () { return m_dataModBtns    ; }
	public String   [] getBtnNames () { return m_dataModsBtnSyms; }
	public TextField[] getClassroom() { return m_classroom      ; }
	public Label    [] getTopLabels() { return m_topLabels      ; }
	
	public String getSearchTerm() { return m_searchTerm.getText(); }
	public PopUp getSearchScreen() { return searchScreen; }
	public void close()
	{
		m_stage.close();
	}
	
	// Field-Setup ~ Starts at Stage ~ Stack init 
	private Node setUpButtons()
	{
		m_buttonRoot = new HBox();
		for(int i = 0; i < m_dataModBtns.length - 3; i++) {
			m_dataModBtns[i] = new Button(m_dataModsBtnSyms[i]);
			m_dataModBtns[i].setMinWidth(135);
			m_buttonRoot.getChildren().add(m_dataModBtns[i]);
		}
		m_searchTerm.setText("Name");
		m_buttonRoot.getChildren().add(m_searchTerm);
		
		for(int i = 3; i < m_dataModBtns.length; i++) {
			m_dataModBtns[i] = new Button(m_dataModsBtnSyms[i]);
			m_dataModBtns[i].setMinWidth(135);
			m_buttonRoot.getChildren().add(m_dataModBtns[i]);
		}
		return m_buttonRoot;
	}
	private TextField[] setUpClassLayout() 
	{
		for(int y = 0; y < m_classroom.length; y++) { 
				m_classroom[y] = new TextField();
				m_classroom[y].setMaxSize(100, 15);
				//m_classroom[y].setText( String.valueOf((y)));
		}
		return m_classroom;
	}
	private Node setUpContentRoot()
	{
		m_classroomLayout = new FlowPane();
	    m_classroomLayout.setMaxWidth(100 * 10);
		m_classroomLayout.getChildren().addAll(setUpClassLayout());
		
		return m_classroomLayout;
	}
	private Node setUpLabels() 
	{
		m_topLabelRoot = new HBox(50);
		m_topLabelRoot.setMinHeight(30);
		m_topLabelRoot.setMaxWidth(1000);
		m_topLabelRoot.setPadding(new Insets(10, 0, 10, 20));
		m_topLabelRoot.setStyle("-fx-background-color: #296097; -fx-font-size: 15; -fx-font-weight:500;");
		for(int i = 0; i < m_topLabels.length; i++) {
			m_topLabels[i] = new Label(m_labelNames[i]);
			m_topLabels[i].setMinWidth(150);
		}
		m_topLabelRoot.getChildren().addAll(m_topLabels);
		return m_topLabelRoot;
	}
	private Parent setUpRootBranch()
	{
		m_rootBranch = new VBox();
		m_rootBranch.setSpacing(10);
		m_rootBranch.setPadding(new Insets(10, 40, 0, 40));
		
		m_rootBranch.getChildren().addAll(setUpLabels(), setUpContentRoot(), setUpButtons());
		return m_rootBranch;
	}
	private Scene setUpScene()
	{
		m_scene = new Scene(setUpRootBranch(), M_SCREEN_X, M_SCREEN_Y);
		return m_scene;
	}
	private void setUpStage(Stage primaryStage)
	{
		m_stage = primaryStage;
		m_stage.setResizable(false);
		m_stage.setTitle(M_APPLICATION_TITLE);
		m_stage.setScene(setUpScene());
		m_stage.show();
	}
	
	public class PopUp
	{
		private static final int SCREEN_X = 300;
		private static final int SCREEN_Y = 500; 

		private GridPane gridPane;
		private VBox     root;
		private Stage stage;
		private Scene scene;
		private Label [] colIds   = new Label[3];
		private String[] colNames = {"Student", "Across", "Down"};
		private HBox labelRoot;
		
		public GridPane getGridPane() { return gridPane; }
		
		public void start()
		{
			setUpRoot();
			scene = new Scene(root, SCREEN_X, SCREEN_Y);
			
			stage = new Stage();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Search Results");
			stage.show();
		}
		
		private void setUpRoot()
		{
			gridPane = new GridPane();
			gridPane.setPadding(new Insets(10, 0, 10, 30));
			//gridPane.getColumnConstraints().add(new ColumnConstraints(100));
			
			for(int i = 0; i < 3; i++) 
				colIds[i] = new Label(colNames[i]);
			
			labelRoot = new HBox(30);
			labelRoot.setStyle("-fx-background-color: #2960ff");
			labelRoot.setPadding(new Insets(10, 0, 10, 30));
			labelRoot.getChildren().addAll(colIds);
			
			root = new VBox();
			root.getChildren().addAll(labelRoot, gridPane);
		}
		
		
	}
}
