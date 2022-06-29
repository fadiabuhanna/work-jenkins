
import java.io.File; 

import java.io.InputStream;

import java.io.ByteArrayOutputStream;
import com.jcraft.jsch.*;


public class Try 
{

	
	public static void main(String[] args){
		//SSHClient ssh = new SSHClient();
		System.out.println("HELLO");
		
		System.out.println(System.getProperty("user.dir"));
		

		    Session session = null;
			ChannelExec channel = null;
		try{
		session = new JSch().getSession("fadi", "127.0.0.1", 2222);
        session.setPassword("123123123");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        
        channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand("ls");
        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
        channel.setOutputStream(responseStream);
		System.out.println("1");
        channel.connect();
		System.out.println("2");
		
		        while (channel.isConnected()) {
            Thread.sleep(100);
        }
        
        String responseString = new String(responseStream.toByteArray());
        System.out.println(responseString);
		
		session.disconnect();
		
		}catch(Exception e){
			System.out.println("hello");
		}

	}
}
