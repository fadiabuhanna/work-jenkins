import java.io.File; 
import java.util.Arrays;

public class PrintDirectory 
{
	static void readFolder(String folderName){
		
		try{
			File folder = new File(folderName);
			File[] filesArray = folder.listFiles();
			
			
			for (File file : filesArray) {

				System.out.println(file.getName());
				
				if(file.isDirectory())
					readFolder(file.getAbsolutePath());
					
			}
			
		}
		catch(Exception e){
			System.out.println("this folder: \"" + folderName + "\" does not exist!");
		}
		
		
	}
	
  public static void main(String[] args){
	System.out.println(System.getProperty("user.dir"));
	readFolder("args[0]");
  }
  
}
