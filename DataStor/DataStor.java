/*	Steven Quaethem
	Dante Sales
	Natalie Torres Diaz
	SDV 1420
	Lab 3_1 
	Jan 26, 2015 */

import java.io.*;
import java.util.*;
	
public class DataStor {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "milesPerWeek,fuelPricePerGallon,fuelMileage,fuelAdditionalTax," +
			"maintenanceExpensePerMile,tireExpensePerMile,workersCompensationPerMile,mealExpense,coDriverExpense,helperExpense," +
			"lodgingExpense,miscellaneousExpense,totalVariableExpense,tractorPayment,tractorInsurance,basePlate,highwayUse," +
			"miscellaneousOther,totalFixedExpense,loadedPay,emptyPay,handling,stopCharge,loadedMiles,emptyMiles,fuelSurcharge," +
			"freightHandled,accessorials,totalIncome,truckNumber";
	//Truck data index
	private static final int MILESPERWEEK = 0;
	private static final int FUELPRICEPERGALLON = 1;
	private static final int FUELMILAGE = 2;
	private static final int FUELADDITIONALTAX = 3;
	private static final int MAINTENANCEEXPENSEPERMILE = 4;
	private static final int TIREEXPENSEPERMILE = 5;
	private static final int WORKERSCOMPENSATIONPERMILE = 6;
	private static final int MEALEXPENSE = 7;
	private static final int CODRIVEREXPENSE = 8;
	private static final int HELPEREXPENSE = 9;
	private static final int LODGINGEXPENSE = 10;
	private static final int MISCELLANEOUSEXPENSE = 11;
	private static final int TOTALVARIABLEEXPENSE = 12;
	private static final int TRACTORPAYMENT = 13;
	private static final int TRACTORINSURANCE = 14;
	private static final int BASEPLATE = 15;
	private static final int HIGHWAYUSE = 16;
	private static final int MISCELLANEOUSOTHER = 17;
	private static final int TOTALFIXEDEXPENSE = 18;
	private static final int LOADEDPAY = 19;
	private static final int EMPTYPAY = 20;
	private static final int HANDLING = 21;
	private static final int STOPCHARGE = 22;
	private static final int LOADEDMILES = 23;
	private static final int EMPTYMILES = 24;
	private static final int FUELSURCHARGE = 25;
	private static final int FREIGHTHANDLED = 26;
	private static final int ACCESSORIALS = 27;
	private static final int TOTALINCOME = 28;
	private static final int TRUCKNUMBER = 29;		

	public static void writeCsvFile(String fileName) {
		
		//Import truckerArray from main program
		
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new truck object list to the CSV file
			
			

			
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
		public static void readCsvFile(String fileName) {

			BufferedReader fileReader = null;
	     
	        try {
	        	
	        	//Create a new list of student to be filled by CSV file data 
	        	List truckerArray = new ArrayList();
	        	
	            String line = "";
	            
	            //Create the file reader
	            fileReader = new BufferedReader(new FileReader(fileName));
	            
	            //Read the CSV file header to skip it
	            fileReader.readLine();
	            
	            //Read the file line by line starting from the second line
	            while ((line = fileReader.readLine()) != null) {
	                //Get all tokens available in line
	                String[] tokens = line.split(COMMA_DELIMITER);
	                if (tokens.length > 0) {
	                	//Create a new truck object and fill his  data
						Truck truck = new Truck(tokens[MILESPERWEEK]), tokens[FUELPRICEPERGALLON], tokens[FUELMILAGE], tokens[FUELADDITIONALTAX], 
								tokens[MAINTENANCEEXPENSEPERMILE], tokens[TIREEXPENSEPERMILE], tokens[WORKERSCOMPENSATIONPERMILE], tokens[MEALEXPENSE], 
								tokens[CODRIVEREXPENSE], tokens[HELPEREXPENSE], tokens[LODGINGEXPENSE], tokens[MISCELLANEOUSEXPENSE], tokens[TOTALVARIABLEEXPENSE], 
								tokens[TRACTORPAYMENT], tokens[TRACTORINSURANCE], tokens[BASEPLATE], tokens[HIGHWAYUSE], tokens[MISCELLANEOUSOTHER], 
								tokens[TOTALFIXEDEXPENSE], tokens[LOADEDPAY], tokens[EMPTYPAY], tokens[HANDLING], tokens[STOPCHARGE], tokens[LOADEDMILES], 
								tokens[EMPTYMILES], tokens[FUELSURCHARGE], tokens[FREIGHTHANDLED], tokens[ACCESSORIALS], tokens[TOTALINCOME], tokens[TRUCKNUMBER]);
						truckerArray.add(truck);
					}
	            }
	            
	        } 
	        catch (Exception e) {
	        	System.out.println("Error in CsvFileReader !!!");
	            e.printStackTrace();
	        } finally {
	            try {
	                fileReader.close();
	            } catch (IOException e) {
	            	System.out.println("Error while closing fileReader !!!");
	                e.printStackTrace();
	            }
	        }
	}
}
