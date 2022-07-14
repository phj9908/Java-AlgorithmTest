// 성적이 낮은 순서로 학생 출력하기

// 입력 
//2
//홍길동 96
//이순신 78

// <String, Integer>로 묶어 이차원 어레이리스트를 생성해 정렬하기 보다
// class를 만들어 동시에 값을 할당하고 접근하기 쉽도록 함!

package ThisIsCodingTest;

import java.util.*;

class Students implements Comparable<Students>{

	private String name;
	private int score;
	
	public Students(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Students o) {
		if(this.score < o.score) return -1; // 오름차순 정렬
		return 1;
	}

	public String getName() {
		return this.name;
	}

}

public class Java0714_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		// '홍길동 96' 을 입력받아 각각 이름,점수로 할당
		List<Students> students = new ArrayList<>();
		for (int i=0; i< n; i++) {
			String name = sc.next();
			int score = sc.nextInt();
			
			students.add(new Students(name,score));
		}
		
		Collections.sort(students);
		
		for(int i=0;i<students.size();i++) System.out.print(students.get(i).getName() + " ");
	}
}
// 결과 : 이순신 홍길동
