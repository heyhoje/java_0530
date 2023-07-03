package day24._162_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx1 {

	public static void main(String[] args) {
		int port = 5001; // 1. 포트번호 설정
		
		ServerSocket severSocket = null;
		Scanner sc = new Scanner(System.in);
		
		try {// 예외처리
			//2. 서버소켓 생성
			severSocket = new ServerSocket(port);
			
			//3. 대기(연결 요청할때까지 기다림)
			while(true) {
				System.out.println("[Waiting...]"); 
				
				// 4. 연결요청이 오면 수락(요청시 accept해줘라)
				Socket socket = severSocket.accept(); 
				System.out.println("[Connect!]");
				
				// 5. 작업
				//  1)클라이언트에서 보낸 데이터를 가져오기 위해 InputStream 생성
				InputStream is = socket.getInputStream();
				byte[] bytes = new byte[1024]; // 넉넉하게 1키로바이트씩 
				// 저장한 곳은 배열
				int readCount = is.read(bytes); // 읽어온 개수로 리턴
				String str = new String(bytes);
				System.out.println("[Date : " + str + " ]");
				
				//  2) 클라이언트로 데이터를 보내기 위해 OutputStream 생성
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
