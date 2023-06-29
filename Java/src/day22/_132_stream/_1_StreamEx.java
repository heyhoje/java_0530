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
		
		// 전체 출력
		// Stream을 이용하는 이유, 배열이 됐든 리스트가 됐든, 사용하는 방법이 동일해짐(와닿니? 아니요)
		// forEach : 하나씩 꺼내는 기능
		arrStream.forEach(num->System.out.println(num));//consumer 매개변수o, 리턴타입x??
		System.out.println("-----");
		listStream.forEach(num->System.out.println(num));

		System.out.println("== 3보다 큰 수==");
		// 3보다 큰 수를 콘솔에 출력
		arrStream = Arrays.stream(arr); // stream은 한번 사용하면 끝이라서 다시 복붙해야함
		arrStream
			.filter(num-> num>3) //filter : 매개변수o, 리턴타입 참거짓
			.forEach(num -> System.out.println(num));
		System.out.println("----------");
		listStream = list.stream(); // stream은 한번 사용하면 끝이라서 다시 복붙해야함
		listStream
			.filter(num-> num>3)
			.forEach(num-> System.out.println(num));
		
	}

}
