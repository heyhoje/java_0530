package day24._162_network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx3 {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.30.206";
		Socket socket = new Socket()
			socket.connect(new InetSocketAddress(ip, port));
		
		try {
			// 3. 서버에게(IP, port) 연결 요청
			socket.connect(new InetSocketAddress(ip, port));
		}
		
		
			
		
		
	}

}
