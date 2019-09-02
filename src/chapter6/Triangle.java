package chapter6;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {

        int[] A = {10,2,5,1,8,20};

        int result = solution(A);
        System.out.println("result : " + result);

    }

    //https://app.codility.com/demo/results/trainingEE3R67-5DN/
    //O(N * logN)
    private static int solution(int[] A) {

        if(A.length < 3) return 0;

        Arrays.sort(A);

        for(int i = 0; i < A.length - 2; i++) {
            if((double)A[i] + (double)A[i+1] > (double)A[i+2]) return 1;
        }

        return 0;
    }

    //https://app.codility.com/demo/results/trainingCH6R6G-FW5/
    //O(N^3)
    /*private static int solution(int[] A) {

        for(int i = 0; i < A.length - 2; i++) {
            int P = A[i];

            for(int j = i + 1; j < A.length - 1; j ++) {
                int Q = A[j];

                for(int k = j + 1; k < A.length; k++) {
                    int R = A[k];

                    if((P + Q > R) && (Q + R > P) && (R + P > Q)) return 1;

                }
            }
        }

        return 0;
    }*/
}
