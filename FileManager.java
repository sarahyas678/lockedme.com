package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager
{
	/**
	 * This method will return the file name from the folder
	 * @param folderpath
	 * @return List<String>
	 */
   public static List<String> getAllFiles(String folderpath)
   {
	   //Creating File Object
	   File fl = new File(folderpath);
	   
	   //Getting all files into FileArray
	   File[] listofFiles = fl.listFiles();
	   
	   //Declare a list to store file names
	   List<String>fileNames = new ArrayList<String>();
	   
	   for(File f:listofFiles)
		   fileNames.add(f.getName());
		   
		//return the list
	    return fileNames;
		   
   }
   /**
    * This method will create or append content into the file specified
    * @param folderpath
    * @param fileName
    * @param content
    * @return boolean
    */
   public static boolean createFiles(String folderpath,String fileName,List<String> content)
   {
	   try 
	   {
		   File fl = new File(folderpath, fileName);
		   FileWriter fw = new FileWriter(fl);
		   
				   for(String s:content)
				   {
					   fw.write(s+"\n");
				   }
				   fw.close();
				   return true;
	   }
	   catch(Exception Ex)
	   {
		   return false;
	   }
	}
   
   /**
    * this method will delete the file name if it exists
    * @param folderpath
    * @param fileName
    * @return
    */
    public static boolean deleteFile(String folderpath, String fileName)
    {
    	//adding folderpath with file name and creating file object
    	File file = new File(folderpath+"\\"+fileName);
    	
    	try 
    	{
    		if(file.delete())
    			return true;
    		else
    			return false;
    	}
    	catch(Exception Ex)
    	{
    		return false;
    	}
    	
    }
    /**
     * this method will search the file from the folder
     * @param folderpath
     * @param fileName
     * @return
     */
     public static boolean searchFile(String folderpath, String fileName)
     {
    	 //adding folderpath with file name and creating file object
    	 File file = new File(folderpath+"\\"+fileName);
    	 
    	 if(file.exists())
    		 return true;
    	 else
    		 return false;
     }
    
   
}

