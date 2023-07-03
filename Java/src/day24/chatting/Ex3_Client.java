package day24.chatting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Ex3_Client {

	public static void main(String[] args) {
		int port = 5001;//1.��Ʈ��ȣ ����
		String ip = "192.168.30.199";//1-1. ���� IP����
		Socket socket = new Socket();//2. ���� ����
		try{
			//3. ��������(IP,port) ���� ��û
			socket.connect(new InetSocketAddress(ip,port));
			//������ �Ϸ�Ǹ�, �б�/���� ����� ����
			Client client = new Client(socket);
			client.read();
			client.send();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
