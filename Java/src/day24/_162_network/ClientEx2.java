package day24._162_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx2 {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.30.206";
		Socket socket = new Socket()
			socket.connect(new InetSocketAddress(ip, port));
		
		Thread sendThread = new Thread(() -> {//thread로 만들어야 상대의 답을 기다리지 않고 중간중간 보낼 수 있다
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			byte[] bytes = str.getBytes();
			try( ){
				OutputStream os = socket.getOutputStream();
						os.write(bytes);
				os.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}); 
		sendThread.start();
		
		Thread readThread = new Thread(() -> {
			try (InputStream is = socket.getInputStream()) {
				byte[] bytes = new byte[1024];
				is.read(bytes);
				String str = new String(bytes);
				System.out.println("client : " + str);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}); 
		readThread.start();
			
		
		
	}

}
