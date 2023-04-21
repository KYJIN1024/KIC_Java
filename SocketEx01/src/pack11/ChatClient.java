package pack11;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length !=1 ) {
			System.out.println("USAGE: java chatClient tester1");
			System.exit(0);
		}
		
		try {
			Socket socket = new Socket("192.168.0.42", 8888);
			System.out.println("서버에 연결되었습니다.");
			
			Thread sender = new Thread(new ClientSender(socket, args[0]));
			Thread receiver = new Thread(new ClientReceiver(socket));
			
			sender.start();
			receiver.start();
			} catch(ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	static class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream out;
		private String name;
		
		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void run() {
			BufferedReader br = null;
			try {
			br = new BufferedReader(new InputStreamReader(System.in));
			if(out != null) {
			out.writeUTF(name);
			}
			
			System.out.println("보낼 메시지>");
			
			while(out != null) {
			out.writeUTF( "[" + name + "]" + br.readLine());
			}
			} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} finally {
			if (br != null) try { br.close(); } catch(IOException e) {}
			}
		}
	}
	
	static class ClientReceiver extends Thread{
		private Socket socket;
		private DataInputStream in;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void run() {
			while(in != null) {
				
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	}
}
			
			
		
		
	