package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoDimensionalArraySort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }
        /*
         ********2차원 배열 정렬하기********
         배열의 arr[a] 와 arr[b]를 각각 a, b로 선언
         각 요소의 연산 값이 음수 일 경우 왼쪽으로 보냄
         0일 경우 제자리
         양수 일 경우 오른쪽으로 보냄
         ********************************
         Arrays.sort(coordinates, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
         arr[a][0] 오름차순 후 and arr[a][1]로 다시 오름차순
        */
        Arrays.sort(coordinates, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < N; i++) {
            sb.append(coordinates[i][0]).append(" ").append(coordinates[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}