package day21.practice;

// ��￡ ����222 �̰� ���� �޼��� �������ڰ� ����.....??
public class _3_MethodEx {

	public static void main(String[] args) {
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3,4,5));

	}

	/* �������� ������ ���� �˷��ִ� �޼��� */
	public static int sum(int ... nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}

}
