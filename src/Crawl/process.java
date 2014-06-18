package Crawl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class process {
public static void main(String[] args){
	String directory = "/Users/hanjia/Desktop/GIS/Final project/data/2012.txt";
	String namedir = "/Users/hanjia/Desktop/GIS/Final project/data/name.txt";
	
	ArrayList<String> addressline =new ArrayList<String>();
	ArrayList<String> namelist =new ArrayList<String>();
	try {
		FileReader fr = new FileReader(directory);
		BufferedReader br = new BufferedReader(fr);
		FileReader namefr = new FileReader(namedir);
		BufferedReader namebr = new BufferedReader(namefr);
		
		BufferedWriter outref= new BufferedWriter(new FileWriter("/Users/hanjia/Desktop/GIS/Final project/data/201201.txt"));

		String line ="";
		while((line = br.readLine())!=null){
			String address = line.trim();

			if(address.contains("null")){
				address = "";
			}
			else if(address.equals("")){
				address = "";
			}
			else{
			int index = address.length() - 1;
			address = address.substring(0, index);
			}
			System.out.println(address);

			address = address.replace("  ", " ");
		//address = address.replace(" CA", ", CA");
		int comma = address.lastIndexOf(",");
		int ca = address.indexOf("CA");
		if(ca < comma){
			address= address.substring(0, comma);
		}
		addressline.add(address);
        }

		String nameline = "";
		while((nameline = namebr.readLine())!=null){
			String name = nameline.trim();
            namelist.add(name);
        }
		
		for(int p = 0; p < namelist.size(); p++){
			String add = addressline.get(p);
			String name = namelist.get(p);
			if(!add.equals("") && add.contains("CA")){
			outref.write(name+ "\t" +add);
			outref.newLine();
			}
		}

		br.close();
		namebr.close();
		outref.close();
	} catch (FileNotFoundException e) {  
		System.out.println("File not found");
	} catch (IOException e) {
		System.out.println("IOException");
	}

}
}
