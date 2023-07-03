package day24.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex2_Server {
	public static void main(String[] args) {
		int port = 5001;//1. ��Ʈ��ȣ ����

		//2. ServerSocket ����
		try(ServerSocket serverSocekt = new ServerSocket(port);){
			while(true) {
				//3. ���� ��� �� ��û�� ���� ����
				Socket socket = serverSocekt.accept();
				//4. �۾�
				//4-1. �������� Ŭ���̾�Ʈ�� �����ϴ� ������ ���� �� ����
				Thread sendThread = new Thread(()->{
					Scanner sc = new Scanner(System.in);

					try{
						//�������� Ŭ���̾�Ʈ�� �����ϴ� �۾��� ������ �ݺ�. socket ������ ���涧����
						//=> Ŭ���̾�Ʈ�� ���� ���Ḧ �� ������
						while(true){
							//�ֿܼ��� �Է�
							String str = sc.nextLine();
							//�Է¹��� ���ڿ��� �����ϱ� ���� byte�� ��ȯ
							byte [] bytes = str.getBytes();
							OutputStream os = socket.getOutputStream();
							//��ȯ�� byte���� ����
							os.write(bytes);
							os.flush();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				sendThread.start();
				//4-2. Ŭ���̾�Ʈ���� ���� �����͸� �о���� ������ ���� �� ����
				Thread readThread = new Thread(()->{
					try {
						InputStream is = socket.getInputStream();
						//�����͸� �޴� �۾��� ������ �ݺ�. Ŭ���̾�Ʈ ������ ���� ������
						while(true) {
							//�޾ƿ� ������ ����
							byte [] bytes = new byte[1024];
							//������ �����͸� ������ �޾ƿ�
							is.read(bytes);
							//�޾ƿ� �����͸� ���ڿ��� ��ȯ
							String str = new String(bytes);

							System.out.println("client : " + str);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				readThread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
