package day22._132_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _1_StreamEx {

	public static void main(String[] args) {
		Integer arr[] = {1, 2, 3, 4, 5};
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> arrStream = Arrays.stream(arr);
		Stream<Integer> listStream = list.stream();
		
		// ��ü ���
		// Stream�� �̿��ϴ� ����, �迭�� �Ƶ� ����Ʈ�� �Ƶ�, ����ϴ� ����� ��������(�ʹ��? �ƴϿ�)
		// forEach : �ϳ��� ������ ���
		arrStream.forEach(num->System.out.println(num));//consumer �Ű�����o, ����Ÿ��x??
		System.out.println("-----");
		listStream.forEach(num->System.out.println(num));

		System.out.println("== 3���� ū ��==");
		// 3���� ū ���� �ֿܼ� ���
		arrStream = Arrays.stream(arr); // stream�� �ѹ� ����ϸ� ���̶� �ٽ� �����ؾ���
		arrStream
			.filter(num-> num>3) //filter : �Ű�����o, ����Ÿ�� ������
			.forEach(num -> System.out.println(num));
		System.out.println("----------");
		listStream = list.stream(); // stream�� �ѹ� ����ϸ� ���̶� �ٽ� �����ؾ���
		listStream
			.filter(num-> num>3)
			.forEach(num-> System.out.println(num));
		
	}

}
