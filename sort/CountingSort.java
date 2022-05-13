package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] result = new int[N];
        int[] counting = new int[10001];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) { // arr 배열의 값을 인덱스로 counting 배열의 값을 1씩 증가시킴.
            counting[arr[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            // counting 배열의 값을 result 배열의 인덱스로 사용하기 위해 부분합 수행
            // counting[x+1] = counting[x] + counting[x+1]
            counting[i] += counting[i - 1];
        }

        for (int i = 0; i < N; i++) {
            // counting[arr[i]]을 idx에 대입하기 전에 -1을 하는 이유는 result 배열은 0부터 시작하기 때문.
            // -1을 하지 않으면 result 배열의 1번째부터 값을 저장하게됨.
            int idx = --counting[arr[i]];
            result[idx] = arr[i];
        }

        for (int i : result) { // *** sb.insert 사용 시 속도 저하되므로 사용 X ***
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}