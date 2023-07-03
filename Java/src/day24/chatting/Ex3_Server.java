package day24.chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex3_Server {

	public static void main(String[] args) {
		int port = 5001;//1. ��Ʈ��ȣ ����

		//2. ServerSocket ����
		try(ServerSocket serverSocekt = new ServerSocket(port);){
			while(true) {
				//3. ���� ��� �� ��û�� ���� ����
				Socket socket = serverSocekt.accept();
				//������ Ŭ���̾�Ʈ�� �а� ���⸦ ��.
				//������ Ŭ���̾�Ʈ�� ����� �ٸ��� Server Ŭ������ �߰��ؼ�
				//�Ʒ� �κ��� Client�� �ƴ� Server�� ����
				Client client = new Client(socket);
				//read()/send() ���� �߿����� ����. ������ �����带 �̿��ؼ�
				client.read();
				client.send();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
