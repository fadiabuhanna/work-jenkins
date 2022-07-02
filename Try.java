

//This class implements an output stream in which the data is written into a byte array
import java.io.ByteArrayOutputStream;

import com.jcraft.jsch.*;



public class PrintDirectory 
{

	static void path(String USER, String HOST, int POTR) {
		Session session = null;
		ChannelExec channel = null;
		try{
			//session = new JSch().getSession("fadi", "127.0.0.1", 2222);
			session = new JSch().getSession(USER, HOST, POTR);
			session.setPassword("123123123");
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			
			channel = (ChannelExec) session.openChannel("exec");
			
			// ls -R: Takes all folders and files (Recursive)
			channel.setCommand("ls -R"); 
			ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
			channel.setOutputStream(responseStream);
			channel.connect();
			
			//Have to wait a few seconds to fetch the folders and files
			while (channel.isConnected()) {
				Thread.sleep(100);
			}
			
			String responseString = new String(responseStream.toByteArray());

			// print the list of content - folders and files
			System.out.println(new String(responseStream.toByteArray()));
			
			session.disconnect(); //stop
		
		}
		catch(Exception e){
			System.out.println("exception");
		}
	}
	
	
	public static void main(String[] args){
		
		 try{

			 String USER = System.getProperty("UserName");
			 String HOST = System.getenv("HostIp");
			 String PORT = System.getenv("Port");

   			int PORT_NUMBER = Integer.parseInt(PORT);
			 
			path(USER,HOST,PORT_NUMBER);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
	}
}

