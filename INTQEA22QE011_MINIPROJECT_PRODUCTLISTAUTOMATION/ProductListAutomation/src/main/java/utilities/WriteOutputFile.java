package utilities;

import java.io.BufferedReader;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;  
  
public class WriteOutputFile {
	static PrintStream ps_console;
 	public static void write() {
 		//desc:  shift the printstream to the Output.txt file 
 		
		try {
			 ps_console = System.out;
			File f=new File(".\\.\\Output.txt");  		    
	        FileOutputStream i=new FileOutputStream(f);  
	        System.setOut(new PrintStream (i));
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	 
	public static void writeOnConsole() {
		// desc:  Shift the printstream to the console.
		try {
	        System.setOut(ps_console);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void printOutputTxtfile() {
		// desc:  Print all content of the Output file on console 
		try  
		{  
		File file=new File("Output.txt");            //creates a new file instance  
		FileReader fr=new FileReader(file);          //reads the file  
		BufferedReader br=new BufferedReader(fr);    //creates a buffering character input stream  
		StringBuffer sb=new StringBuffer();          //constructs a string buffer with no characters  
		String line;  
		while((line=br.readLine())!=null)  
		{  
		sb.append(line);      //appends line to string buffer  
		sb.append("\n");     //line feed   
		}  
		fr.close();    //closes the stream and release the resources  
		System.out.println(sb.toString());   //returns a string that textually represents the object  
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}  
		
	}
	 
}  

	


