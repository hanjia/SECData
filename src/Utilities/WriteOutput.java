package Utilities;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;


public class WriteOutput{
	     public static void main(String[] args) throws IOException{
	    	 output("I am su;");
	     }
	
         public static void output(String line) throws IOException{
        	 //Charset charset = Charset.forName("US-ASCII");
        	 try{
        	 File file = new File("C:\\Users\\John\\Desktop\\Test.txt");
        	// boolean success = file.createNewFile();
        	 BufferedWriter bw;
        	
        		 
        		// if (success) {
        			 bw = new BufferedWriter(new FileWriter(file, true));
        			 bw.newLine();
        			 bw.write(line);
        		 //   } else {
        		   // 	bw = new BufferedWriter(new FileWriter(file));
        		 //   	bw.write(line);  // File already exists
        		  //  }

        	     
        	     bw.close();
        	 } 
        	 catch (IOException x) {
        	     System.err.format("IOException: %s%n", x);
        	 }


         }

}
