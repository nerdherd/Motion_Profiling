package fileWriteTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class test2 {

	public static void main(String[] args) {
		
		PrintWriter writer;
		File file = new File("Users/J/Desktop/Jocelyn Hsu/Grade 9/FRC/FileWriterTest.txt"); 
		String text = "Hello world";
		String timeStamp = null; 
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( output != null )
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			File log = new File("log.txt");
				    try{
				    if(log.exists()==false){
				            System.out.println("We had to make a new file.");
				            log.createNewFile();
				    }
				    PrintWriter out = new PrintWriter(new FileWriter(log, true));
				    out.append("******* " + timeStamp.toString() +"******* " + "\n");
				    out.close();
				    }catch(IOException e){
				        System.out.println("COULD NOT LOG!!");
				    }
			/*}public class test2 {

	public static void main(String[] args) {
		
		PrintWriter writer;
		File file = new File("Users/J/Desktop/Jocelyn Hsu/Grade 9/FRC/FileWriterTest.txt"); 
		String text = "Hello world";
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( output != null )
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			/*} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		*/	
		}
		
		
		/*File FileWriterTest = new File("FileWriterTest.txt");
		try{
			if(FileWriterTest.exists()==false){
				System.out.println("We had to make a new file.");
				FileWriterTest.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(FileWriterTest, true));
			out.append("************** " + "\n");
			out.close();
			}
		catch(IOException e){
			System.out.println("COULD NOT LOG!!");*/
		}

	}


