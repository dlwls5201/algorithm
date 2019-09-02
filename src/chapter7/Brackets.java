package chapter7;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {

        String S = "{[()()]}";
        int result = solution(S);
        System.out.println("result : " + result);
    }

    //https://app.codility.com/demo/results/training52VBHT-39U/
    private static int solution(String S) {

        Stack<Character> stack = new Stack<>();

        for(Character c : S.toCharArray()) {
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if(stack.empty()) return 0;

                char pop = stack.pop();

                switch (c) {
                    case '}' :
                        if(!(pop == '{')) return 0;
                        break;
                    case ']' :
                        if(!(pop == '[')) return 0;
                        break;
                    case ')' :
                        if(!(pop == '(')) return 0;
                        break;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    //https://app.codility.com/demo/results/trainingTJQNGR-XVD/
    private static int solution2(String S) {

        Stack<String> stack = new Stack<>();

        String[] arr = S.split("");

        for(String s : arr) {
            if(s.equals("{") || s.equals("[") || s.equals("(")) {
                stack.push(s);
            } else {
                if(stack.empty()) return 0;

                String pop = stack.pop();

                switch (s) {
                    case "}" :
                        if(!pop.equals("{")) return 0;
                        break;
                    case "]":
                        if(!pop.equals("[")) return 0;
                        break;
                    case ")" :
                        if(!pop.equals("(")) return 0;
                        break;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
