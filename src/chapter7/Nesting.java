package chapter7;

import java.util.Stack;

public class Nesting {

    public static void main(String[] args) {

        String s = "())";
        int result = solution(s);
        System.out.println("result : " + result);

    }

    //https://app.codility.com/demo/results/trainingAMM4GZ-9MF/
    private static int solution(String S) {

        Stack<Character> stack = new Stack<>();

        for (char s : S.toCharArray()) {

            if(s == '(') {
                stack.push(s);
            } else {
                if(stack.isEmpty()) return 0;
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
