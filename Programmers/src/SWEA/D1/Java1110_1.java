package SWEA.D1;

import java.util.Scanner;

//1288
public class Java1110_1 {

    public static void main(String args[])
    {
        boolean[] visited;
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int K;
            int i = 1;
            visited = new boolean[10];
            while (true){
                K = N * i;
                count(K, visited); // K에 있는 문자열 방문 체크
                if (check(visited)) break; // 0~9모두 방문했다면 반복문 탈출
                i++;
            }
            System.out.printf("#%d %d\n", test_case, K);
        }
    }
    public static boolean check(boolean[] visited){
        for (int i = 0; i < 10; i++){
            if (!visited[i]) return false;
        }
        return true;
    }
    
    public static void count(int N, boolean[] visited){
        String str_N = Integer.toString(N);
        for (int i = 0; i < str_N.length(); i++){
            visited[str_N.charAt(i) - '0'] = true;
        }
    }
}
