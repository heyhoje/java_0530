package day12.practice;

// 또 놓쳤다 뭐어디에 복사생성자를 넣으라는데 갑자기 class word로 넘어와있네
public class Word {
		/* 한 단어를 관리하는 클래스
		 * - 단어
		 * - 뜻1, 뜻2, ...
		 */
		// 멤버 변수
		private String title;
		private String meaning[];
		private int meaningCount; // 뜻이 저장된 개수, 몇개 저장됐는지(반복문으로 따지지 않아도됨)
		
		// 생성자
		public Word(String title, String meaning) {
			this.title = title;
			this.meaning = new String[5]; // 최대 5개 저장 가능
			this.meaning[0] = meaning;
			meaningCount++;
		}
		
		// 생성자 오버로딩
		public Word(String title) {
			this.title = title; //일단 단어만 추가하고, 뜻은 나중에 입력하려고 일단 만들어봄
			this.meaning = new String[5]; // 뜻을 넣어줄 수 있는 배열은 만들어두자.
		}
		
		//* 복사생성자
		public Word(Word w) { // 매개변수가 워드클래스의 객체가 오는경우 = 복사생성자
			this.title = w.title;
			this.meaning = new String[5];
			//this.meaning = w.meaning; // 얕은복사, 공유해서 어쩌구함...
			for(int i = 0; i <w.meaningCount; i++) {
				meaning[i] = w.meaning[i];
			}
			meaningCount = w.meaningCount;
		}
		// 메소드
		/** 기능 : 단어와 뜻을 출력하는 메소드
		 * 매개변수 : 없어?(내정보 출력이라 굳이 남이 알려줄 필요 없음.)(자기 자신이라????)
		 * 리턴타입 : (출력) 없음 => void
		 * 메소드명 : print 
		 */
		
		public void print() {
			System.out.println("word : " + title);
			System.out.println("meaning : ");
			// 의미는 여러개! 반복문. 
//			for(int i = 0; i < meaning.length; i++) {
//				if(meaning[i] != null) {
			for(int i = 0; i < meaningCount; i++) {
					System.out.println(i + 1 + ". " + meaning[i]);
			}
		}
		
		/** 기능 : 뜻을 추가하는 메소드
		 * 매개변수 : 추가될 뜻 => String meaning
		 * 리턴타입 : (멤버의 값을 바꾸는거)없음 => void
		 * 메소드명 : addMeaning
		 */
		public void addMeaning(String meaning) {
			//meaningCount 변수 추가
			
			//뜻이 다 찼으면 다 찼다고 출력하고 종료
			if(meaningCount == this.meaning.length) {// 배열의 길이인 5와 같으면
				System.out.println("It's all filled");
				return; // 밑에 코드 실행 안함
			}
			this.meaning[meaningCount] = meaning;
			meaningCount++;
		}	
		
		/** 기능 : 뜻을 제거하는 메소드
		 * 매개변수 : 제거할 뜻의 번호 => int num
		 * 리턴타입 : (알려주는x, 반환하는x) 없음 => void
		 * 메소드명 : removeMeaning
		 */
		
		public void removeMeaning(int num) {
			// num은 번지가 아님. num - 1 = [번지]
			if(num > meaningCount || num < 1) {
				System.out.println("I can't work.");
				return; // 밑에 작업을 하지 않도록 빠져나감
				// return을 쓰지 않으면, else {} 가 나와야함. 
				// return;을 적절하게 잘 활용하면, 가독성이 생기고 코드가 효율적으로 작업될 수 있다.
				}
				// num -1 번지부터 하나씩 당겨와서 채워준다. 덮어쓰기.
				for(int i = num -1; i < meaningCount -1; i++) {
					meaning[i] = meaning[i+1]; //한칸씩 땡겨옴
				}
				// 마지막에 쓸모없는 데이터를 지움
				//meaning[meaningCount-1] = null; // 해도되고 안해도됨. 
				// 제거 됐으면 뜻 개수를 하나 줄임
				meaningCount--;
			}
			
		}
}
