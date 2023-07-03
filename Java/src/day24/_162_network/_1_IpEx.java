package day24._162_network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _1_IpEx {

	public static void main(String[] args) {
		InetAddress inetAddress = null; // ��ü ����
		
		try {
			// �̸��� localhost�� ���� IP �ּ� ������ ������. ��� PC�� ���� 127.0.0.1
			//+����ó��(RuntypeException �ƴѰ� �� ó���� �������)
			inetAddress = InetAddress.getByName("localhost"); // localhost/127.0.0.1
			System.out.println(inetAddress);
			
			// ���̹� ����Ʈ�� ������ �ּ� ��ȸ
			inetAddress = InetAddress.getByName("www.naver.com"); //www.naver.com/223.130.195.95
			System.out.println(inetAddress);
			
			// �� PC�� ������ �ּ� ��ȸ
			inetAddress = InetAddress.getLocalHost();
			System.out.println(inetAddress); // ���������Ǵ� �ܺο����� ���� �Ұ���. �����Ⳣ���� ����.

			InetAddress[] address = InetAddress.getAllByName("www.naver.com");
			for(InetAddress tmp : address) {
				System.out.println(tmp);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} // localhost �ش� �̸��� ip�ּ� ��û
	}

}
