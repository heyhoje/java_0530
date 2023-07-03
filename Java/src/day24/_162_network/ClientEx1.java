package day24._162_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx1 {

	public static void main(String[] args) {
		int port = 5001; // 서버 포트번호
		Scanner sc = new Scanner(System.in); // hi가 아니라 내가 입력한 정보를 보내고 싶다면~ 스캐너죠!
		
		// 1. 소캣 생성
		// socket = new Socket();
		// 2. 연결 요청
		try(Socket socket = new Socket();) { 
			// try에다 뭘 넣으면 socket.close(); 닫기를 안해도됨. 그 뭐를 뭐라고 하죠????  
			// +예외처리
			socket.connect(new InetSocketAddress(port));
			System.out.println("[Connet!]");
			// 3. 작업
			// 서버에 데이터 전송을 위해 OutputStream 생성
			OutputStream os = socket.getOutputStream();
			String str = sc.nextLine(); // 보내려는 데이터
			byte[] bytes = str.getBytes(); //Hi를 바이트로 변환 / 아웃풋은 바이트 단위로 보내야한대요 왜죠
			os.write(bytes);
			os.flush(); // 서버에 전송할 수 있도록 다 밀어줌
			
			os.close();
			
			// 클라이언트는 전송하고 끝- 
			
			//  2) 서버에서 받기
			InputStream is = socket.getInputStream();
			//is.read(bytes);
			bytes = new byte[1024]; // 해당 부분을 추가해야 한다는데 이유 이해안됨
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


// 나 서버랑 클라이언트랑 동시 작동하는거 모르겠다@.@