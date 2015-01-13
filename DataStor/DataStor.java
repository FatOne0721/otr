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
	
	/* The following blocks of code are for informational purposes. 
	 * They serve no purpose at this time
	 * 
	 * Determine a home directory

Use System.getProperty("user.home") to determine the home directory of the user running the application.

Create a file HomeDirEx.java 
class HomeDirEx {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
    }
}

The code simply prints the home directory of the user account the application is running under.

Verifying a file/directory exists

The package java.io.File is used to handle get and set simple file information and perform a few simple operations. Verifying the existance of a file is as easy as invoking the exists() method.

Create a file VerifyFileExistsEx.java 
import java.io.File;
class VerifyFileExistsEx {
    public static void main(String[] args) {
        File f = new File(FILENAME); 
        if (f.exists()) {
            System.out.println("File exists");
        } else {
            System.out.println("File does not exist");
        } 
    }
}

The code simply opens a File object pointing at FILENAME. Then the boolean method exists is invoked in the if statement to check the files existence.

Deleting a File

Deleting a file is also handled through the java.io.File package by invoking the delete method.

Create the file DeleteFileEx.java 
import java.io.File;
class DeleteFileEx {
    public static void main(String args[]) {
        File f = new File(FILENAME);
        if (f.exists()) {
            f.delete(); 
        }
    }
}

Simply checks if the file exists and if so delete it.

Move/Rename

When moving file within a filesystem the File objects renameTo method will move a file.

Create MoveFileEx.java 
import java.io.File;
class MoveFileEx {
    public static void main(String args[]) {
        File f = new File(FILENAME);
        if (f.exists()) {
            f.renameTo(new File(NEW_FILENAME));
        }
    }
}

Open a File object, verify it exists, and if so rename it to a new filename. This will not work across filesystems. To do that you need to do a copy and delete. There's no easy interface to copying a file, that will be covered later on with writing files.

Reading a File

Reading a file involves a few steps. First a File object must be opened, then it must be attached to a FileInputStream and the BufferedReader. File input/output streams and associated objects throw errors and must be caught with try/catch statements.

Create the file ReadFileEx.java 
import java.io.*;
class ReadFileEx {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Must specify file on the command line");
            return;
        }

        try {
            FileInputStream fStream = new FileInputStream(args[0]);
            BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
            while (in.ready()) {
                System.out.println(in.readLine());
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File input error");
        }
    }
}

First verify a file was specified on the command line. Next open a new FileInputStream with the first command line argument and attach the FileInputStream to a BufferedReader. The BufferedReader provides the interfaces to pull data from the file. While the BufferedReader buffer is ready to be read from read a line from the file and print to the screen. The boolean method ready will return true as long as there are bytes available in the buffer.

Writing a File

Writing a file is similar to reading files, except a FileOutputStream is opened and attached to a PrintStream.

Beginning of file

Create WriteFileEx.java 
import java.io.*;
class WriteFileEx {
    public static void main(String[] args) {
        FileOutputStream out;
        PrintStream prt;
        if (args.length != 1) {
            System.out.println("Must specify file on the command line");
            return;
        }
        try {
            out = new FileOutputStream(args[0]);
            prt = new PrintStream(out);
            prt.println("Line 1");
            prt.println("Line 2");
            prt.close();
        } catch(Exception e) {
            System.out.println("Write error");
        }
    }
}

First setup a FileOutputSream out and a PrintStream prt. These two variables will be used to write the file. Verify a filename was specified on the command line. Then open the FileOutputStream followed by initializing the PrintStream. Print out a couple of lines to the file. Finally close the file.

Appending

In this example the FileWriter class is going to be used to append text to the end of a file.

Create AppendFileEx.java 
import java.io.*;
class AppendFileEx {
    public static void main(String[] args) {
        FileWriter out;
        if (args.length != 1) {
            System.out.println("Must specify file on the command line");
            return;
        }
        try {
            out = new FileWriter(args[0], true);
            out.write("Append to endn");
            out.close();
        } catch(IOException e) {
            System.out.println("Error appending to file " + args[0]);
        }
    }
}

First declare the FileWriter object out. Next verify the file to append to was specified on the command line, and open the file. If true is appended as an option when initializing the FileWriter append mode is used. Then use the write method to append to the file. Notice that the linefeed must manually be appended when using the write method of FileWriter. Finally close the file.

Copying a File

To copy a file in java you simply have to read in the file and write it back out to the new location.

Create CopyFileEx.java 
import java.io.*;
class CopyFileEx {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Must specify file on the command line");
            return;
        }
        try {
            FileInputStream in = new FileInputStream(args[0]);
            FileOutputStream out = new FileOutputStream(args[1]);
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = in.read(buf)) != -1) {
                out.write(buf, 0, i);
            }
            in.close();
            out.close();
        } catch(IOException e) {
            System.out.println("Error copying file");
        }
    }
}

Verify both the source and destination files are specified, and Open the input and output streams with the command line arguments as the files. Then create a buffer to read the file into. Next use a while loop to read the data into the buffer then write it to the destination file. Clean up and close the files.
	 */
	
	
	