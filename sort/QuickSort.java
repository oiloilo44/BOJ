package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int[] nums = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i) - '0';
        }

        mQuickSort(nums, 0, nums.length - 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(nums[i]);
        }
        System.out.println(sb);
    }

    static void mQuickSort(int[] arr, int left, int right) {
        // pivot 을 중심으로 왼쪽에는 pivot 보다 작은 값 오른쪽은 큰값으로 정렬
        int pivot = partition(arr, left, right);

        if (left < pivot - 1) {
            // 위의 정렬 후 배열의 처음부터 pivot - 1까지 재 정렬
            mQuickSort(arr, left, pivot - 1);
        }
        if (pivot < right) {
            // 위의 정렬 후 pivot 부터 배열의 마지막까지 재 정렬
            mQuickSort(arr, pivot, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) { // 마지막에 left를 증가시키기 위해 <= 비교 연산자 사용
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}