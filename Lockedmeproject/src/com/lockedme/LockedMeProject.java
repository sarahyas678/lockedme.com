package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LockedMeProject
{
    static final String folderpath= "C:\\Users\\sarah\\OneDrive\\Desktop\\simplilearn\\phase 1 project\\LockedMeFiles";
    public static void main(String[] args)
{
    	
    	int proceed=1;
    	
   do
   {
		//Variable decleration
		int ch;
		
		// display Menu
         ch=displayMenu();
     
     
     
     switch(ch)
     {
	     case 1 : getAllFiles();
	               break;
	     case 2 : createFiles();
	               break;
	     case 3 : deleteFile();
	               break;
	     case 4 : searchFile();
	               break;
	     case 5 : System.exit(0);
	               break;
	     default : System.out.println("Invalid Option");
	               break;
	     
     }
     
	}while(proceed>0);
} 
	
	
	/**
	 * @return 
	 * 
	 */
	public static int displayMenu()

	{
		Scanner obj = new Scanner(System.in);
		int ch;
		
		 System.out.println("******************************************");
	      System.out.println("\t\tLockedMe.com");
	      System.out.println("******************************************");
	      System.out.println("1. Display all files");
	      System.out.println("2. Add new file");
	      System.out.println("3. Delete a file");
	      System.out.println("4. Search a file");
	      System.out.println("5. Exit");
	      System.out.println("******************************************");
	      System.out.println("Enter your choice:");
	      ch=Integer.parseInt(obj.nextLine());
		   
		       
		 return ch;
	}
	/**
	 * 
	 */
	public static void getAllFiles()
	{
		// get file names
		List<String> fileNames = FileManager.getAllFiles(folderpath);
		
		for(String f:fileNames)
		System.out.println(f);

	}
	/**
	 * 
	 */
	public static void createFiles()
	{
		//Variable declaration
		Scanner obj = new Scanner(System.in);
			String fileName;
			int linesCount;
			List<String> content = new ArrayList<String>();
			
			//Read File name from user
			System.out.println("Enter file name:");
			fileName=obj.nextLine(); 
			
			//Read number of lines from user
			System.out.println("Enter how many lines in the file:");
			linesCount=Integer.parseInt(obj.nextLine());
			
			//Read Lines from user
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter line " +i+":");
				content.add(obj.nextLine());
			
			}
			
			//save the content into the file
			boolean isSaved = FileManager.createFiles(folderpath, fileName,content);

			if(isSaved)
			    System.out.println("File and data saved successfully");
			else
				System.out.println("some error occured. please contact admin@sarah.com");
			
	}
	/**
	 * 
	 */
	public static void deleteFile()
	{
	// code for deleting file
			String fileName;
			Scanner obj = new Scanner(System.in);
			System.out.println("Enter file name to be deleted:");
			fileName=obj.nextLine();
			
			boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
			
			if(isDeleted)
				System.out.println("File deleted successfully");
			else
				System.out.println("Either file not there or some acess issue");
			
	}
	/**
	 * 
	 */
	public static void searchFile()
	{
		 // code for searching a file
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be searched:");
		fileName=obj.nextLine();
		
		boolean isFound = FileManager.searchFile(folderpath, fileName);
		
		if(isFound)
			System.out.println("File is present in the folder");
		else
			System.out.println("File is not present in the folder");
		
	}
}



