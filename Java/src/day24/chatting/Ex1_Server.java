package day24.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex1_Server {

	public static void main(String[] args) {
		int port = 5001;//1. ��Ʈ��ȣ ����

		ServerSocket severSocket = null;
		Scanner sc = new Scanner(System.in);
		try {
			//2. �������� ����
			severSocket = new ServerSocket(port);
			//3. ���
			while(true) {
				System.out.println("[Waiting...]");
				//4. �����û�� ���� ����
				Socket socket = severSocket.accept();
				System.out.println("[Connect!]");
				//5. �۾�
				//Ŭ���̾�Ʈ���� ���� �����͸� �������� ���� InputStream ����
				InputStream is = socket.getInputStream();
				byte [] bytes = new byte[1024];
				int readCount = is.read(bytes);
				String str = new String(bytes);
				System.out.println("[Data : " + str + " ]");
				//Ŭ���̾�Ʈ�� �����͸� ������ ���� OutputStream ����
				OutputStream os = socket.getOutputStream();
				str = sc.nextLine();
				bytes = new byte[1024];
				bytes = str.getBytes();
				os.write(bytes);
				os.flush();

				os.close();
				is.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
