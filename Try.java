
import java.io.File; 

public class PrintDirectory 
{
	static void readFolder(String path){
		
		try{
			File folder = new File(path);
			File[] filesArray = folder.listFiles();
			
			for (File file : filesArray) {
				
				if(file.isDirectory()){
					System.out.println("directory: " + file.getName());
					readFolder(file.getAbsolutePath());
				}
				else System.out.println("file: " + file.getName());
			}
		}
		catch(Exception e){
			System.out.println("this folder: \"" + path + "\" does not exist!");
		}
		
	}
	public static void main(String[] args){
		System.out.println(System.getProperty("user.dir"));
		System.out.println("hello");
		readFolder(args[0]);
	}
}
