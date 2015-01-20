/*	Steven Quaethem
	Dante Sales
	Natalie Torres Diaz
	SDV 1420
	Lab 3_1 
	Jan 05, 2015 */

import java.io.*;
	
	public class DataStor {
		public static void main(String [] args)
		   {
			BufferedWriter br = new BufferedWriter(new FileWriter("c:\\truck.csv"));
			/* The idea is to take array element 29 (truckNumber) and append it to the
			 * file name just after truck. Thus allowing for a csv file for 
			 * each vehicle in the fleet.
			 */
			StringBuilder sb = new StringBuilder();
			for (String element : truckerArray) {
			 sb.append(element);
			 sb.append(",");
			}

			br.write(sb.toString);
			br.close();
		   }
		}