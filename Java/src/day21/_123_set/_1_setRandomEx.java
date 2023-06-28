package day21._123_set;

// ���� ��ħ. �����ʿ�

import java.util.ArrayList;
import java.util.HashSet;

public class _1_setRandomEx {

	public static void main(String[] args) {
		/* �迭�� �̿��ؼ� 1~9������ ������ �� 3���� ����(�ߺ����� ����) */
		int arr[] = new int[3];
		int count = 0;
		int min = 1, max = 9;

		while(count < 3) {
			int r = random(min, max);
			int i;

			for(i = 0 ; i<count; i++) {
				if(arr[i] == r) {
					break;
				}
			}
			if(i == count) {
				arr[count++] = r;
			}
		}
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + (i == arr.length-1?"":", "));
		}
		System.out.println("]");
		
		/* List�� �̿��ؼ� 1~9������ ������ �� 3���� ����(�ߺ����� ����) */
		ArrayList<Integer> list = new ArrayList<>();

		while(list.size() < 3) {
			int r = random(min, max);
			if(!list.contains(r)) {
				list.add(r);
			}
		}
		System.out.println(list);
		/* Set�� �̿��ؼ� 1~9������ ������ �� 3���� ����(�ߺ����� ����) */
		HashSet<Integer> set = new HashSet<>();

		while(set.size() < 3) {
			int r = random(min, max);
			set.add(r);
		}
		System.out.println(set);
	}

		/* set�� �̿��ؼ� 1~9������ ������ �� 3���� ����(�ߺ����� ����) */
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min + 1)+min);
	}

}
