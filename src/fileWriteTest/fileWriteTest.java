package fileWriteTest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class fileWriteTest {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input desired distance");
		double dist = scan.nextFloat();
		System.out.println("Input max acceleration");
		double amax = scan.nextFloat();
		System.out.println("Input max velocity");
		double vmax = scan.nextFloat();
		System.out.println("Input clock speed");
		double clk = scan.nextFloat();
		
		ArrayList<Double> test1 = new ArrayList<Double>();
		//ArrayList<Double> list = new ArrayList<>(Arrays.asList(1.1,2.2,3.3));
		test1.add(vmax);
		test1.add(clk);
		test1.add(amax);
		test1.add(dist);
	
		PrintWriter writer;
		try {
			writer = new PrintWriter("the-file-name.txt", "UTF-8");
			writer.println(test1);
			writer.println("The second line");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
		
	
	


