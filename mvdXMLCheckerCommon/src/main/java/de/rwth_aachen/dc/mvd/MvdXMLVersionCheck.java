package de.rwth_aachen.dc.mvd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MvdXMLVersionCheck {
    public static boolean checkMvdXMLSchemaVersion(String filename, String schemaName) {
	try {
	    File myObj = new File(filename);
	    Scanner myReader = new Scanner(myObj);
	    for (int i = 0; i < 5; i++)
		if (myReader.hasNextLine())
		    if (checSchemaLine(myReader.nextLine(), schemaName))
			return true;

	    myReader.close();
	} catch (FileNotFoundException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	}
	return false;
    }

    private static boolean checSchemaLine(String line, String schemaName) {
	String[] tokens = line.split("[ =>]");
	for (String t : tokens) {
	    if (t.equals("\"" + schemaName + "\""))
		return true;
	}
	return false;
    }
    

    public static boolean checkMvdXMLSchemaVersion(String filename) {
   	Scanner file_reader=null;
   	try {
   	    File myObj = new File(filename);
   	    file_reader = new Scanner(myObj);
   	    for (int i = 0; i < 5; i++)
   		if (file_reader.hasNextLine())
   		    if (checSchemaLine(file_reader.nextLine()))
   			return true;

   	    file_reader.close();
   	} catch (FileNotFoundException e) {
   	    System.out.println("An error occurred.");
   	    e.printStackTrace();
   	}
   	finally {
   	    if(file_reader!=null)
   		file_reader.close();
   	}
   	return false;
       }

    
    private static boolean checSchemaLine(String line)
    {
	String[] tokens=line.split("[ =>]");
	for(String t:tokens)
	{
	    if(t.equals("\"http://buildingsmart-tech.org/mvd/XML/1.1\""))		
		return true;
	}
	return false;
    }
    
}
