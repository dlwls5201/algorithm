package chapter9;

public class MaxProfit {

    /**
     * 0 ≤ P ≤ Q < N 일 때
     * A[Q] − A[P] 의 최대 값을 구하라. 마이너스이면(이득을 얻을 수 없다면) 0을 반환
     */
    public static void main(String[] args) {

        int[] A = {23171, 21011, 21123, 21366, 21013, 21367}; //356
        //int[] A = {5, 4, 3, 2, 1}; // 0
        //int[] A = {8, 9, 3, 6, 1, 2}; // 3

        int result = solution2(A);
        System.out.println("result : " + result);
    }

    //https://app.codility.com/demo/results/trainingUD6UTP-83Y/
    //O(n)
    private static int solution2(int[] A) {

        if(A.length < 2) return 0;

        int max = A[1];
        int min = A[0];
        int profit = max - min;

        for(int i = 2; i < A.length; i++) {

            if(A[i] - min > profit) {
                min = Math.min(max, min);
                max = A[i];
                profit = max - min;
            } else {
                min = Math.min(A[i], min);
            }
        }

        return profit < 0 ? 0 : profit;
    }

    //https://app.codility.com/demo/results/trainingS24KWH-4UD/
    //O(n^2)
    private static int solution1(int[] A) {

        int profit = 0;

        for (int i = 0; i < A.length - 1; i++) {

            int p = A[i];

            for (int j = i + 1; j < A.length; j++) {

                int q = A[j];

                profit = Math.max(profit, q - p);
            }
        }

        return profit < 0 ? 0 : profit;
    }
}
