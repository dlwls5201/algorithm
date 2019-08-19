package chapter5;

import java.util.Arrays;

//https://app.codility.com/demo/results/trainingZTEWDX-NZA/
public class MaxProductOfThree {

    public static void main(String[] args) {

        int[] A = {-3, 1, 2, -2, 5, 6};

        int result = solution(A);
        System.out.println("result : " + result);

    }

    private static int solution(int[] A) {

        int size = A.length;

        Arrays.sort(A);

        int result1 = A[0] * A[1] * A[size-1];
        int result2 = A[size-1] * A[size-2] * A[size-3];

        return result1 > result2 ? result1 : result2;
    }
}
