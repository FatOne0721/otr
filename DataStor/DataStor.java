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
			   generateCsvFile("c:\\trucks.csv"); 
		   }
		 
		   private static void generateCsvFile(String sFileName)
		   {
			try
			{
			    FileWriter writer = new FileWriter(sFileName);
		 
			   /* Generic example code follows
			    writer.append("DisplayName");
			    writer.append(',');
			    writer.append("Age");
			    writer.append('\n');
		 
			    writer.append("MKYONG");
			    writer.append(',');
			    writer.append("26");
		            writer.append('\n');
		 
			    writer.append("YOUR NAME");
			    writer.append(',');
			    writer.append("29");
			    writer.append('\n');
		 
			    generate whatever data you want */
		 
			    writer.flush();
			    writer.close();
			}
			catch(IOException e)
			{
			     e.printStackTrace();
			} 
		    }
		   public static void config(String cFileName){
			   try
				{
				    FileWriter writer = new FileWriter(cFileName);
			 
				   /* Generic example code follows
				    writer.append("DisplayName");
				    writer.append(',');
				    writer.append("Age");
				    writer.append('\n');
			 
				    writer.append("MKYONG");
				    writer.append(',');
				    writer.append("26");
			            writer.append('\n');
			 
				    writer.append("YOUR NAME");
				    writer.append(',');
				    writer.append("29");
				    writer.append('\n');
			 
				    generate whatever data you want */
			 
				    writer.flush();
				    writer.close();
				}
				catch(IOException e)
				{
				     e.printStackTrace();
				} 
		}
	}
	