// 비밀지도
package Programmers.lv1;

public class Java0707_1 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String bin_num1 = "", bin_num2 = "";

		for (int i = 0; i < n; i++) {
			bin_num1 = Integer.toBinaryString(arr1[i]); // Int형 십진수 -> String형 이진수
			bin_num2 = Integer.toBinaryString(arr2[i]);

			bin_num1=while_fun(bin_num1, n); // 글자수에 맞게 앞에 '0'추가
			bin_num2=while_fun(bin_num2, n);

			String res = "";
			for (int j = 0; j < n; j++) {
				String str="";
				str = (bin_num1.charAt(j) == '1' || bin_num2.charAt(j)=='1') ? "#":" "; 
				// String.charAt() -> String의 한문자씩 접근
				
				res += str;
			}
			answer[i] = res;
		}

		return answer;
	}

	public String while_fun(String bin_num1, int n) {
		
		while (bin_num1.length() != n)
			bin_num1 = "0" + bin_num1;
		return bin_num1;
	}

}
