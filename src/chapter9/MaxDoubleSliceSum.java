package chapter9;

public class MaxDoubleSliceSum {


    public static void main(String[] args) {

        //int[] A = {3, 2, 6, -1, 4, 5, -1, 2}; // 17
        //int[] A = {-8, 10, 20, -5, -7, -4}; // 30
        //int[] A = {5, 17, 0, 3}; //17
        //int[] A = {0, 10, -5, -2, 0}; // 10
        int[] A = {6, 1, 5, 6, 4, 2, 9, 4}; //26

        int result = solition2(A);
        System.out.println("result : " + result);

    }

    //https://app.codility.com/demo/results/training5QZBVV-ZDU/
    //같은 스터디원의 풀이
    private static int solition2(int[] A) {
        if (A.length == 1) return A[0];

        int localMaxSum = A[1];
        int globalMaxSum = A[1];
        int maxpos = 1;
        int minpos = 1;

        for (int i = 2; i < A.length - 1; i++) {
            localMaxSum = Math.max(A[i], localMaxSum + A[i]);
            if (globalMaxSum <= localMaxSum) {
                globalMaxSum = localMaxSum;
                maxpos = i;
            }
        }

        int temp = globalMaxSum;
        int min = A[maxpos];
        for (int i = maxpos; i >= 1; i--) {
            if (min > A[i]) {
                min = A[i];
            }
            temp -= A[i];
            if (temp == 0) {
                minpos = i;
                break;
            }
        }

        if (min > 0 && (maxpos <= A.length - 3 || minpos >= 2)) {
            return globalMaxSum;
        }

        return globalMaxSum - min;
    }

    /**
     * 두개의 부분집합으로 만들었을 때 가장 큰값을 구하라
     * 맨앞과 맨뒤는 포함되지 않는다.
     */
    //https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
    private static int solution1(int[] A) {

        int current = 0;
        int max = 0;

        if (A.length <= 3) return 0;

        for (int i = 1; i < A.length - 1; i++) {

            if (A[i] >= 0) {
                current += A[i];

                if (i < A.length - 2) {
                    int temp = current + maxProfit(i + 1, A);
                    max = Math.max(max, temp);
                }

            } else {
                current += maxProfit(i, A);
                max = Math.max(max, current);
                break;
            }
        }

        return max;
    }

    private static int maxProfit(int i, int[] A) {

        int current = 0;
        int max = A[i];

        for (int j = i; j < A.length - 1; j++) {

            current += A[j];

            if (current < 0) {
                current = 0;
            } else {
                max = Math.max(current, max);
            }
        }

        return max < 0 ? 0 : max;
    }
}
