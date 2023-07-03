package day24._162_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx1 {

	public static void main(String[] args) {
		int port = 5001; // ���� ��Ʈ��ȣ
		Scanner sc = new Scanner(System.in); // hi�� �ƴ϶� ���� �Է��� ������ ������ �ʹٸ�~ ��ĳ����!
		
		// 1. ��Ĺ ����
		// socket = new Socket();
		// 2. ���� ��û
		try(Socket socket = new Socket();) { 
			// try���� �� ������ socket.close(); �ݱ⸦ ���ص���. �� ���� ����� ����????  
			// +����ó��
			socket.connect(new InetSocketAddress(port));
			System.out.println("[Connet!]");
			// 3. �۾�
			// ������ ������ ������ ���� OutputStream ����
			OutputStream os = socket.getOutputStream();
			String str = sc.nextLine(); // �������� ������
			byte[] bytes = str.getBytes(); //Hi�� ����Ʈ�� ��ȯ / �ƿ�ǲ�� ����Ʈ ������ �������Ѵ�� ����
			os.write(bytes);
			os.flush(); // ������ ������ �� �ֵ��� �� �о���
			
			os.close();
			
			// Ŭ���̾�Ʈ�� �����ϰ� ��- 
			
			//  2) �������� �ޱ�
			InputStream is = socket.getInputStream();
			//is.read(bytes);
			bytes = new byte[1024]; // �ش� �κ��� �߰��ؾ� �Ѵٴµ� ���� ���ؾȵ�
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


// �� ������ Ŭ���̾�Ʈ�� ���� �۵��ϴ°� �𸣰ڴ�@.@