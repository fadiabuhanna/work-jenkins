
import java.io.File; 

public class Try 
{
	static void func(String folderName){
		
		try{
			File folder = new File(folderName);
			File[] files = folder.listFiles();
			
			for (File file : files) {

					System.out.println(file.getName());
					if(file.isDirectory())
						func(file.getAbsolutePath());
			}
		}
		catch(Exception e){
			System.out.println("this folder: " + folderName + " not empty!");
		}
		
		
	}
	
  public static void main(String[] args) {
    func("test");
  }
  
}
