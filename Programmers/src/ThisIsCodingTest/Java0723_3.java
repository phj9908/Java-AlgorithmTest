// 문자열 재정렬(기본, 다시 풀기)
package ThisIsCodingTest;

import java.util.*;
import java.util.Scanner;

public class Java0723_3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		ArrayList<Character> answer = new ArrayList<>();
		
		int num=0;

		for(int i=0;i<str.length();i++) {
			if(Character.isLetter(str.charAt(i))) // 알파벳이면
					answer.add(str.charAt(i));
			else
				num+=str.charAt(i)-'0';
		}
		
		Collections.sort(answer);
		// or answer.sort(Comparator.naturalOrder());
		
		// 알파벳 하나씩 출력
		for(int i=0;i<answer.size();i++)
			System.out.print(answer.get(i));
		
		// 숫자가 하나라도 있으면
		if(num!=0) System.out.print(num);
	
	}
}
