package com.bradkent.ictprg418b.doa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DataBase 
{
	private final static String fileName = "classroom.csv";// "test.txt";
	private final static int numLength  = 2 ;
	private final static int nameLength = 10;
	private final static int deskLength = 20;
	
	public static String[][] randomAccessFile()
	{
		int index = 0;
		String[][] newSize;
		try {
			File file = new File("DataBase/" + fileName);//classroom.csv");
			RandomAccessFile raf = new RandomAccessFile(file, "rw");

			
			String[][] data = new String[100][4];
			
			String msg = ""; 
			while((msg = raf.readLine()) != null && index < 100 ) {
				data[index++] = msg.split(",");
			}
			
			 newSize = new String[index][4];
			
			for(int i = 0; i < index; i++) {
				newSize[i] = data[i];
			}
			System.out.println("Returning");
			return newSize;
// Reading a a line 
		 /* String msg = raf.readLine();
			System.out.println(msg);
		*/
			
// Reading in whole file into bytes the into string 
		/*	byte[] b = new byte[(int) raf.length()];
			raf.read(b);
			
			String bytes = new String(b, "UTF-8");
			System.out.println(bytes);
		*/
			
// Read file via seek()
//		 	//raf.seek(0);
		  /*raf.seek(raf.length());
		  raf.writeUTF("Hello World");
		  raf.seek(raf.length()- 1);
		  raf.writeUTF("Hello World");*/
		  //raf.seek(12);
			//raf.seek();
//		  raf.close();
//			byte[] temp = new byte[5];
		//	for(int i = 0; i < 5; i++) {
//				temp[i] = (char)raf.readInt();
//				System.out.print(temp[i]);
				//System.out.print((char)raf.readByte());
		//	}
			
			
			
//			  raf.seek(0);
//			  String data = "Hello World";
//			  int temp = nameLength - data.length();
////			  raf.writeBytes(data.getBytes());//UTF(data);
//			  raf.writeBytes(data);
//			  raf.seek(raf.getFilePointer());
//			  for(int i = temp; i < 20; i++)
//				  raf.writeByte(0);
//			
//			  raf.seek(raf.length() -1);
//			  raf.writeBytes(data);
//			 for(int i = temp; i < 20; i++)
//				  raf.writeByte(0);
			
			
//			raf.seek(0);
//			raf.writeBytes("Hello World");
//			raf.seek(100);
//			raf.writeBytes("MyName Jeff");
//			raf.seek(120);
//			raf.writeBytes("Yennefer");
//			
//			raf.seek(140);
//			raf.writeBytes("Ciri is hott");
//			for(int i = 0; i < 8; i ++)
//				raf.writeByte(0);
//			raf.close();
//			
//			raf = new RandomAccessFile(file, "rw");
//			raf.seek(100);
////			String ms = raf.readLine();
////			System.out.println(ms);
//			
//			raf.seek(120);
//			byte[] tt = new byte[20];
//			for(int i = 0; i < 20; i++) {
//				tt[i] = raf.readByte();
//				System.out.print((char)tt[i]);
//			}
//			
//		
//			
			//System.out.println(x);
			
			
//			raf.seek(20);
//			byte[] hh = new byte[20];
//			for(int i = 0; i < 20; i++) {
//				hh[i] = raf.readByte();
//			}
//			String gg = new String(hh, "UTF-8");
//			System.out.println(gg);
			
			
			//System.out.println("Hello World".getBytes().length);
			
//			raf = new RandomAccessFile(file, "rw");
//			System.out.println(raf.readUTF());
			
			//String ee = new String(temp, "UTF-8");
			//System.out.println(ee);
		} catch (IOException e) { e.printStackTrace(); }
		return null;
	}
	
	
	

	/*// Get data from file 
	String[][] data = new String[50][4];
	int longestStr = 0;	String line;
	while( (line  = raf.readLine()) != null && index < 50) {  
		data[index++] = line.split(",");
    }*/
	
	
// TODO: Write to File 
}
