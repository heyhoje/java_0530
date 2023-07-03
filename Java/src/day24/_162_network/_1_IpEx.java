package day24._162_network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _1_IpEx {

	public static void main(String[] args) {
		InetAddress inetAddress = null; // 객체 생성
		
		try {
			// 이름이 localhost인 곳의 IP 주소 정보를 가져옴. 모든 PC가 같음 127.0.0.1
			//+예외처리(RuntypeException 아닌건 꼭 처리를 해줘야함)
			inetAddress = InetAddress.getByName("localhost"); // localhost/127.0.0.1
			System.out.println(inetAddress);
			
			// 네이버 사이트의 아이피 주소 조회
			inetAddress = InetAddress.getByName("www.naver.com"); //www.naver.com/223.130.195.95
			System.out.println(inetAddress);
			
			// 내 PC의 아이피 주소 조회
			inetAddress = InetAddress.getLocalHost();
			System.out.println(inetAddress); // 공유아이피는 외부에서는 접속 불가능. 공유기끼리는 가능.

			InetAddress[] address = InetAddress.getAllByName("www.naver.com");
			for(InetAddress tmp : address) {
				System.out.println(tmp);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} // localhost 해당 이름의 ip주소 요청
	}

}
