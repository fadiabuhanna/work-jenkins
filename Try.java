
import java.io.File; 

public class Try 
{
	static void readFolder(String folderName){
		
		try{
			File folder = new File(folderName);
			File[] files = folder.listFiles();
			
			for (File file : files) {

					System.out.println(file.getName());
					if(file.isDirectory())
						readFolder(file.getAbsolutePath());
			}
		}
		catch(Exception e){
			System.out.println("this folder: \"" + folderName + "\" does not exist!");
		}
		
		
	}
	
  public static void main(String[] args) 
	System.out.println(System.getProperty("user.dir"));
	readFolder(args[0]);
  }
  
}
