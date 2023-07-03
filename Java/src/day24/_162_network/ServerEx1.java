package day24._162_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx1 {

	public static void main(String[] args) {
		int port = 5001; // 1. ��Ʈ��ȣ ����
		
		ServerSocket severSocket = null;
		Scanner sc = new Scanner(System.in);
		
		try {// ����ó��
			//2. �������� ����
			severSocket = new ServerSocket(port);
			
			//3. ���(���� ��û�Ҷ����� ��ٸ�)
			while(true) {
				System.out.println("[Waiting...]"); 
				
				// 4. �����û�� ���� ����(��û�� accept�����)
				Socket socket = severSocket.accept(); 
				System.out.println("[Connect!]");
				
				// 5. �۾�
				//  1)Ŭ���̾�Ʈ���� ���� �����͸� �������� ���� InputStream ����
				InputStream is = socket.getInputStream();
				byte[] bytes = new byte[1024]; // �˳��ϰ� 1Ű�ι���Ʈ�� 
				// ������ ���� �迭
				int readCount = is.read(bytes); // �о�� ������ ����
				String str = new String(bytes);
				System.out.println("[Date : " + str + " ]");
				
				//  2) Ŭ���̾�Ʈ�� �����͸� ������ ���� OutputStream ����
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
