package chapter7;

import java.util.Stack;

public class Fish {

    public static void main(String[] args) {

        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        int result = solution(A, B);
        System.out.println("result : " + result);

    }

    //https://app.codility.com/demo/results/training6UPFVG-P3C/
    private static int solution(int[] A, int[] B) {

        Stack<Integer> stack = new Stack<>();

        int diedFish = 0;

        for (int i = 0; i < A.length; i++) {

            if(B[i] == 1) {

                stack.push(A[i]);

            } else {

                while (!stack.isEmpty()) {

                    int peek = stack.peek();

                    diedFish++;
                    //System.out.println("peek : " + peek);

                    if(peek < A[i]) stack.pop();
                    else break;
                }
            }

        }

        return A.length - diedFish;
    }
}
