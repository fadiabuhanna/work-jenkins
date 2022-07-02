//This class implements an output stream in which the data is written into a byte array
import java.io.ByteArrayOutputStream;

import com.jcraft.jsch.*;



public class PrintDirectory 
{

	static void path_function(String USER, String HOST_ip, int host_POTR, String password, String ROOT) {
		
		Session session = null;
		ChannelExec channel = null;
		try{
			//session = new JSch().getSession("fadi", "127.0.0.1", 2222);
			
			//The code connects to remote HOST_ip using a protocol ssh and I used a jsch directory to connect through java
			// Connecting from: user, HOST_ip, port, password
			session = new JSch().getSession(USER, HOST_ip, host_POTR);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			
			//The Linux exec command executes a Shell command without creating a new process
			channel = (ChannelExec) session.openChannel("exec");
			
			// ls -R: Takes all folders and files (Recursive)
			if(!ROOT) channel.setCommand("ls");
			else channel.setCommand("ls "+ ROOT);
			ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
			channel.setOutputStream(responseStream);
			channel.connect();
			
			//Waiting for it to connect
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
			 String PASSWORD = System.getenv("password");
			 String ROOT = System.getenv("root");
			path_function(USER,HOST,PORT_NUMBER,PASSWORD,ROOT);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
	}
}
