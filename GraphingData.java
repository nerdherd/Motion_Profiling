//author: Ted Lin
//contributors: Vincent Viloria

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphingData {

	public static void main(String[] args) {
		double time;
		
		//given desired distance, max acceleration, max velocity, and clock speed
		Scanner scan = new Scanner(System.in);
		System.out.println("Input desired distance");
		double dist = scan.nextFloat();
		System.out.println("Input max acceleration");
		double amax = scan.nextFloat();
		System.out.println("Input max velocity");
		double vmax = scan.nextFloat();
		System.out.println("Input clock speed");
		double clk = scan.nextFloat();
		
		//initializing desired data for or s-curve motion profiles
		double x;    		// x = time in x-axis
		double v;	 		// v = velocity in y-axis 
		double distance;	// distance = distance in y-axis
		
		ArrayList<Double> timedata = new ArrayList<Double>();
		ArrayList<Double> velocitydata = new ArrayList<Double>();
		ArrayList<Double> distancedata = new ArrayList<Double>();
		
		//calculate data
		for (time = 0; time < vmax/amax; time += clk){
			x = (float)(0.5 * amax * Math.pow(time, (double)2));
			v = amax * time;
			distance = x*v;
			timedata.add(x);
			velocitydata.add(v);
			distancedata.add(distance);

		}
		for (time = vmax/amax; time < dist/vmax; time += clk){
			x = (float)(0.5 * Math.pow(vmax, 2) / amax) + (vmax * (time - (vmax/amax)));
			v = (vmax);
			distance = x*v;
			timedata.add(x);
			velocitydata.add(v);
			distancedata.add(distance);

		}
		
		for (time = dist/vmax; time <= (vmax/amax)+(dist/vmax); time += clk){
			x = (float)(dist - 0.5 * amax * Math.pow((time-((vmax/amax)+(dist/vmax))), 2));
			v = amax * ((vmax/amax)+(dist/vmax)-time);
			distance = x*v;
			timedata.add(x);
			velocitydata.add(v);
			distancedata.add(distance);
			
			
		}
		
		//Code below based off of Isaac and Ronan's File writer for TBH
		//Initializes writing to files
		try {
			FileWriter writer = new FileWriter("CSV data file.txt");
			
			//Headings
			writer.append("Time");
			writer.append("\t");
			writer.append("Distance");
			writer.append("\t");
			writer.append("Velocity");
			writer.append("\r");
			
			//Start for loop
			for(int i=0; i < (vmax/amax)+(dist/vmax); i++){
				
				//Rows
				writer.append(String.valueOf(timedata.get(i)));
				writer.append("\t");
				writer.append(" "+ String.valueOf(velocitydata.get(i)));
				writer.append("\t");
				writer.append(" "+ String.valueOf(distancedata.get(i)));
				writer.append("\r");
				
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}


