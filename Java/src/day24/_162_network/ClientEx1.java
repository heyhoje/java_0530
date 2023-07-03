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

		// try���� �� ������ socket.close(); �ݱ⸦ ���ص���. �� ���� ����� ����????  
		// + socket ����ó��
		try(Socket socket = new Socket();){
			// 2. �����û
			socket.connect(new InetSocketAddress(port));
			System.out.println("[Connect!]");
			
			// 3. �۾�
			// 1) ������ ������ ������ ���� OutputStream ����
			OutputStream os = socket.getOutputStream();
			String str = sc.nextLine();// �������� ������
			byte [] bytes = str.getBytes();//Hi�� ����Ʈ�� ��ȯ / �ƿ�ǲ�� ����Ʈ ������ �������Ѵ�� ����
			os.write(bytes);
			os.flush();// ������ ������ �� �ֵ��� �� �о���
			
			os.close();
			
			// Ŭ���̾�Ʈ�� �����ϰ� ��-
			
			// 2) �������� �����͸� �ޱ� ���� InputStream ����
			InputStream is = socket.getInputStream();
			//is.read(bytes);
			bytes = new byte[1024]; // �ش� �κ��� �߰��ؾ� �Ѵٴµ� ���� ���ؾȵ�. ������ ������ ���ڰ� �����Ǽ�???
			int readCount = is.read(bytes);
			str = new String(bytes);
			System.out.println("server : " + str);
			
			//is.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}


// �� ������ Ŭ���̾�Ʈ�� ���� �۵��ϴ°� �𸣰ڴ�@.@
// �����ڵ� ������ ���صɱ�? ��