// 신규 아이디 추천
package Programmers;
 

class Solution {
 public String solution(String new_id) {
     String answer = "";
     
     // 1. 모든 대문자 -> 소문자
     new_id=new_id.toLowerCase();
     
     // 2.알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
     char[] id_arr = new_id.toCharArray();
     StringBuilder strBuilder = new StringBuilder(); // append 메서드 쓰기 위해 StringBuilder객체 생성
     for(char c:id_arr) {
     	if( (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')||c=='-'||c=='.'||c=='_') {
     		strBuilder.append(c);
     	}
     }
     
     // 3. .가 두번 이상 연속된 부분을 .으로 치환
     new_id = strBuilder.toString().replace("..", ".");
     while(new_id.contains("..")) {
     	new_id=new_id.replace("..", ".");
     }
     
     // 4. .가 처음이나 끝에 위치하면 제거 
     StringBuilder strBuilder2 = new StringBuilder(new_id);
     if(strBuilder2.length()>0) {
     	if(strBuilder2.charAt(0)=='.'){
     		strBuilder2.deleteCharAt(0);
     	}
     }
     if(strBuilder2.length()>0) {
     	if(strBuilder2.charAt(strBuilder2.length()-1)=='.') {
     		strBuilder2.deleteCharAt(strBuilder2.length()-1);
     	}
     }
     	
     // 5. 빈 문자열이면 'a' 대입
     new_id = strBuilder2.toString();
     if (new_id.equals("")) { // StringBuilder 객체를 String객체로 변환
     	new_id="a";
     }
     
     // 6. 길이가 16이상이면 첫 15자를 제외한 나머지 문자들 제거 + 만약 제거후 마지막 문자가 .이면 .도 제거
     
     if(new_id.length()>=16) {
     	new_id=new_id.substring(0,15);  	
     }
     if (new_id.charAt(new_id.length()-1)=='.') {
     	new_id=new_id.substring(0,new_id.length()-1);
     }
     
     // 7. 길이가 2자 이하라면 마지막 문자를 길이가 3이 될때까지 반복해서 붙임
     StringBuilder strBuilder3 = new StringBuilder(new_id);
     if(strBuilder3.length()<=2) {
     	while(strBuilder3.length()<3) {
     		strBuilder3.append(strBuilder3.charAt(strBuilder3.length()-1)); 
     	}
     }
     
     answer = strBuilder3.toString();
     return answer;
 }
}