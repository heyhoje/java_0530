package day24.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex1_Client {

	public static void main(String[] args) {
		int port = 5001;//���� ��Ʈ��ȣ
		Scanner sc = new Scanner(System.in);
		//1. ���ϻ���
		try(Socket socket = new Socket();) {
			//2. �����û
			socket.connect(new InetSocketAddress(port));
			System.out.println("[Conect!]");
			//3. �۾�
			//������ ������ ������ ���� OutputStream ����
			OutputStream os = socket.getOutputStream();
			String str = sc.nextLine();//�������� ������
			byte [] bytes = str.getBytes();//Hi�� ����Ʈ�� ��ȯ
			os.write(bytes);
			os.flush();
			InputStream is = socket.getInputStream();
			bytes = new byte[1024];
			int readCount = is.read(bytes);
			str = new String(bytes);
			System.out.println("server : " + str);

			is.close();
			os.close();
		} catch (IOException e) {
			System.out.println("[Connection refused!]");
			//e.printStackTrace();
		}

	}

}
