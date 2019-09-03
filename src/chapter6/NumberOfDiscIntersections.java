package chapter6;

import java.util.LinkedList;

public class NumberOfDiscIntersections {

    public static void main(String[] args) {

        int[] A = {1,5,2,1,4,0};

        int result = solution(A);
        System.out.println("result : " + result);
    }

    //https://app.codility.com/demo/results/trainingWSREX5-FA3/
    //O(N^2)
    private static int solution(int[] A) {

        int result = 0;

        for(int i = 0; i < A.length - 1; i++) {

            for(int j = i + 1; j < A.length; j++) {
                //i 원의 오른쪽 값이 j 원의 왼쪽 값보다 크거나 같으면 교점이 있는 것
                if(i + A[i] >= j - A[j]) result++;
            }
        }

        return result;
    }

    //https://app.codility.com/demo/results/trainingK7RDFR-5FS/
    //O(N^2)
    private static int solution2(int[] A) {

        int result = 0;

        int[] rightValue = new int[A.length];
        LinkedList<Integer> leftValue = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            rightValue[i] = i + A[i];
            leftValue.add(i - A[i]);
        }

        for (int j = 0; j < rightValue.length - 1; j++) {

            leftValue.removeFirst();

            for(int left : leftValue) {
                if(rightValue[j] >= left) {
                    result++;
                }
            }
        }

        return result;
    }

}
