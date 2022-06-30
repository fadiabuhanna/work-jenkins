

import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.*;



public class Try 
{

	static void path(String SFTPUSER, String SFTPHOST, int SFTPPOTR) {
		Session session = null;
		ChannelExec channel = null;
		try{
			//session = new JSch().getSession("fadi", "127.0.0.1", 2222);
			session = new JSch().getSession(SFTPUSER, SFTPHOST, SFTPPOTR);
			session.setPassword("123123123");
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			
			channel = (ChannelExec) session.openChannel("exec");
			channel.setCommand("ls -R");
			ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
			channel.setOutputStream(responseStream);
			channel.connect();
			
			while (channel.isConnected()) {
				Thread.sleep(100);
			}
			
			String responseString = new String(responseStream.toByteArray());

			
			System.out.println(new String(responseStream.toByteArray()));
			
			session.disconnect(); //stop
		
		}
		catch(Exception e){
			System.out.println("exception");
		}
	}
	
	
	public static void main(String[] args){
		
		 try{
            String SFTPUSER="fadi";
			String SFTPHOST="127.0.0.1";
			int SFTPPOTR = Integer.parseInt("2222");
			path(SFTPUSER,SFTPHOST,SFTPPOTR);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
	}
}


