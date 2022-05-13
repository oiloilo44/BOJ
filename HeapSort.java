import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 인덱스를 0부터 사용하기 때문에 i = N / 2에서 -1
        for (int i = N / 2 - 1; i >= 0; i--) { // build max heap
            heapify(arr, i, N);
        }

        for (int i = N - 1; i > 0; i--) {
//            sb.insert(0, "\n").insert(0, arr[0]); // StringBuilder에서 insert를 사용하면 시간 초과됨
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, 0, i);
        }

//        sb.insert(0, "\n").insert(0, arr[0]); // StringBuilder에서 insert를 사용하면 시간 초과됨
        for (int i : arr) { // StringBuilder append로 교체
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void heapify(int[] arr, int pNode, int size) {
        int lcNode = pNode * 2 + 1;
        int rcNode = pNode * 2 + 2;
        int bcNode;

        if (size > lcNode && size > rcNode) { // 자식 노드가 2개인 경우
            bcNode = arr[lcNode] > arr[rcNode] ? lcNode : rcNode;
        } else if (size > lcNode) { // 자식 노드가 1개인 경우
            bcNode = lcNode;
        } else // 자식 노드가 없으면 종료
        {
            return;
        }

        if (arr[pNode] > arr[bcNode]) // 자식 노드 중 큰 값과 부모 노드의 값을 비교
        {
            return;
        }

        int tmp = arr[pNode];
        arr[pNode] = arr[bcNode]; // 자식 노드와 부모 노드 값 변경
        arr[bcNode] = tmp;

        heapify(arr, bcNode, size); // 부모 노드와 자식 노드를 변경한 후 자식 노드 하위 노드들을 다시 정렬
    }
}
