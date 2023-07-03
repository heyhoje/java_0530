package day24.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex2_Client {

	public static void main(String[] args) {
		int port = 5001;//1.��Ʈ��ȣ ����
		String ip = "192.168.30.199";//1-1. ���� IP����
		Socket socket = new Socket();//2. ���� ����
		try{
			//3. ��������(IP,port) ���� ��û
			socket.connect(new InetSocketAddress(ip,port));

			Thread sendThread = new Thread(()->{
				Scanner sc = new Scanner(System.in);

				try{
					while(true){
						String str = sc.nextLine();
						byte [] bytes = str.getBytes();
						OutputStream os = socket.getOutputStream();
						os.write(bytes);
						os.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			sendThread.start();
			Thread readThread = new Thread(()->{
				try {
					InputStream is = socket.getInputStream();
					while(true) {
						byte [] bytes = new byte[1024];
						is.read(bytes);
						String str = new String(bytes);
						System.out.println("server : " + str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			readThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
