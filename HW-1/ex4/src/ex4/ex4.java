package ex4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex4 {
	
	
	private static String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}
	
	
	

	public static void main(String[] args) {
		String red = "<th style= \" background-color: red \"></th>\n";
		String green = "<th style= \" background-color: green \"></th>\n";
		String blue = "<th style= \" background-color: blue \"></th>\n";
		String tamplate =  "$tamplate";
		
		
		try{
			System.out.print("Please enter a number from 1 to 50");
	        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	        String s = bufferRead.readLine();
	        int n = Integer.parseInt(s);
	        String htmlString =  readFile("template.html");
	       
	        int i = 0;
	        while(i < n){
	        	switch(i % 3) {
	        	  case 0:
	        		  htmlString = htmlString.replace(tamplate, blue + tamplate);
	        	    break;
	        	  case 1:
	        		  htmlString = htmlString.replace(tamplate, red + tamplate);
		        	    break;
	        	  case 2:
	        		  htmlString = htmlString.replace(tamplate, green + tamplate);
	        		  break;
	        	}
	        	i++;
	        }
	        
	        htmlString = htmlString.replace(tamplate, "");
	        
	        BufferedWriter writer = new BufferedWriter(new FileWriter("ex4.html"));
	        writer.write(htmlString);  
	        writer.close();

		}catch (IOException e) {
			System.out.println(e);
		}
	        
	        
	}
}


