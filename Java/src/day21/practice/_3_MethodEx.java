package day21.practice;

// 기억에 없음222 이건 뭔데 메서드 가변인자가 뭐야.....??
public class _3_MethodEx {

	public static void main(String[] args) {
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3,4,5));

	}

	/* 여러개의 정수의 합을 알려주는 메서드 */
	public static int sum(int ... nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}

}
