package com.lockerme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject {

	
	static final String folderpath="F:\\SL\\Phase1 Proj\\LockedMeFiles";
	public static void main(String[] args) {
	
		int proceed =1;
		do
		{
		//Variable Declaration
				
				int ch;
				// menu
				
				
				ch=displayMenu();
				
				
				switch(ch) {
				case 1 :getAllFiles();
				break;
				case 2 :createFiles();
				break;
				case 3 :deleteFile();
				break;
				case 4 :searchFile();
				break;
				case 5 :System.exit(0);
				break;
				default : System.out.println("Invalid option");
				break;
					
				}
				
		}
		while(proceed>0);
			}
		public static int displayMenu() {
			Scanner obj = new Scanner(System.in);
			int ch;
			
		System.out.println("***********************************************************************");
		System.out.println("\t\t LockedMe.com")	;	
		System.out.println("***********************************************************************");
		System.out.println("\t\t Radhika K B");
		System.out.println("***********************************************************************");
		System.out.println("1. Display all Files");
		System.out.println("2. Add new File");
		System.out.println("3. Delete a File");
		System.out.println("4. Search a File");
		System.out.println("5. Exit");
		System.out.println("***********************************************************************");
		System.out.println("***********************************************************************");
		System.out.println("Enter your choice:");
		ch=Integer.parseInt(obj.nextLine());
		return ch;
	}
		
		public static void getAllFiles()
		{
		
			// Get file names
			List<String> fileNames = FileManager.getAllFiles(folderpath);
			   if(fileNames.size()==0)
				   System.out.println("No files in the directory");
			   else {
				   System.out.println("File List is below:\n");
			   
			      for(String f:fileNames)
			    	  System.out.println(f);
			   }
	}
		/**
		 * Code for Creating file
		 */
		public static void createFiles()
		{
			// Variable Declaration
		      Scanner obj = new Scanner(System.in);
		      String fileName;
		      int linesCount;
		      List<String> content = new ArrayList<String>();
		   
		      // Read file name from User 
		      System.out.println("Enter file name:");
		      fileName=obj.nextLine();
		    
		      // Read number of lines from User 
		      System.out.println("Enter how many Lines in the file: ");
		      linesCount=Integer.parseInt(obj.nextLine());
		      
		      for(int i=1;i<=linesCount;i++)
		      {
		    	  System.out.println("Enter line "+i+":");
		    	  content.add(obj.nextLine());
		    	  
		      }
		      // save the content into the File
		      boolean isSaved = FileManager.createFiles(folderpath, fileName, content);
		      
		      if(isSaved)
		    	  System.out.println("File and data saved sucessfully");
		      else
		    	  System.out.println("Some error occured. Please contact admin@radhika.com");
			
		      
		      
		      
			//close scanner object
			


		}
		/**
		 * Code for Deleting File
		 */
		public static void deleteFile()
		{
			// code for deleting the file
			
			String fileName;
			Scanner obj =new Scanner(System.in);
			System.out.println("Enterfile name to be deleted ");
			fileName=obj.nextLine();
			
			boolean isDeleted =FileManager.deleteFile(folderpath, fileName);
			
			if(isDeleted)
				System.out.println("File deleted sucessfully");
			else
				System.out.println("Either file not there or some access issue");
		}
		/**
		 * Code for Searching file
		 */
		public static void searchFile()
		{
			// code for Searching the file
			
			String fileName;
			Scanner obj =new Scanner(System.in);
			System.out.println("Enter file name to be searched ");
			fileName=obj.nextLine();
			
			boolean isFound =FileManager.searchFile(folderpath, fileName);
			
			if(isFound)
				System.out.println("File is present in the folder");
			else
				System.out.println("File is not present in the folder");
	
		}
}

		
		
