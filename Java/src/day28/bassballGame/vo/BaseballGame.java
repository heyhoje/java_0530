package day28.bassballGame.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseballGame {

	private List<Integer> com;
	private List<Integer> user;

	public BaseballGame() {
		com = new ArrayList<>();
		user = new ArrayList<>();
		
		generate(3, 1, 9); // ���� 3��, min = 1, max = 9
	}
	
	// �޼ҵ�1 : ��ǻ�Ͱ� �ߺ����� �ʴ� 1~9������ ������ �� 3���� ����
	public boolean generate(int size, int min, int max) {
		// ������ �ϴ� ������ 0�����̸�
		if(size <= 0) {
			return false;
		}
		// max�� min���� ������
		if(max < min) {
			return false;
		}
		// �����Ǵ� ������ ������ ������ ������ �ϴ� ������ �������� ������(���ѷ���)
		if(max - min + 1 < size) {//���� �� �ִ� �������� ������� ������ ����
			return false;
		}
		
		
		Random random = new Random();
		Set<Integer> set = new HashSet<>();
		// ������ ���� size����ŭ set�� �߰�(set�� �˾Ƽ� �ߺ��� ��������)
		while(set.size() < 3) {
			set.add(random.nextInt(max - min + 1) + min); // 0�̻� ������ �� �̸��� ����
		}
		// �ߺ����� �ʰ� ó���� set�� List�� ����
		com.clear(); // ������ ������ �� �� �����ϱ� �������� ����
		com.addAll(set);
		// ����Ʈ�� ������. 
		Collections.shuffle(com);
		return true;
	}
	
	// ��Ʈ����ũ ����
	public int getStrike() {
		int count = 0; 
		for(int i = 0; i < com.size(); i++) {
			if(com.get(i) == user.get(i)) {
				count++;
			}
		}
		return 0;
	}
	
	// �� ����
	public int getBall() {
		int count = 0;
		// �ߺ��� ���ڰ� � �ִ��� Ȯ��(�� + ��Ʈ����ũ ����)
		for(Integer tmp : user) {
			if(com.contains(tmp)) {
				count++;
			}
		}
		return count - getStrike();
	}

	/*user�� �ߺ��� ���� ������ �Ѿ�� ���� �ִ��� Ȯ���ϴ� �޼ҵ�*/
	public boolean setUser(List<Integer> user) {
		// user�� this.user�� ������ �� ������ ��� �ִ��� Ȯ��
		// �ߺ����� �ʾ����� 1���� ���ðŰ�, �ߺ��� ���� ������ 1���� ŭ
		///�����𸣰���.....................................
		this.user.clear();// ���� ����ڰ� �Է��� �� ����ΰ�
		this.user.addAll(user);
		for(Integer tmp1 : this.user) {
			// ������ �Ѿ ���� ������
			if(tmp1 < 1 || tmp1 > 9) {
				return false;
			}
			int count = 0;
			for(Integer tmp2 : user) {
				if(tmp1 == tmp2) {
					count++;
//			for(int i =0, count = 0; i < user.size(); i++) {
//				for(int j = 0; j < user.size(); j++) {
//					
//				}
//			}
				}
			}
			// �ߺ��� ���� 2���̻��̸�,
			if(count > 1) {
				return false;
			}
		}
		return false;
	}

	public void printResult() {
		int strike = getStrike();
		int ball = getBall();
		if(strike > 0) {
			System.out.println(strike+"S");
		}
		if(ball > 0) {
			System.out.println(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.println("3OUT");
		}
		System.out.println();
		System.out.println(com);
	}
	
}
