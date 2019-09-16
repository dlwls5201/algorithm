package chapter9;

//https://app.codility.com/demo/results/trainingS24KWH-4UD/
public class MaxProfit {

    /**
     *  0 ≤ P ≤ Q < N 일 때
     *  A[Q] − A[P] 의 최대 값을 구하라. 마이너스이면 0을 반환
     */
    public static void main(String[] args) {

        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};

        int result = solution(A);
        System.out.println("result : " + result);
    }

    private static int solution(int[] A) {

        int profit = 0;

        for(int i = 0; i < A.length - 1; i++) {

            int p = A[i];

            for(int j = i + 1; j < A.length; j++) {

                int q = A[j];

                profit = Math.max(profit, q - p);
            }
        }

        return profit < 0 ? 0 : profit;
    }
}
