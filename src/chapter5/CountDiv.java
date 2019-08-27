package chapter5;

//https://app.codility.com/demo/results/trainingJ5AM3G-YB2/
public class CountDiv {

    public static void main(String[] args) {

        int result = solution(6,11,2);
        System.out.println("result : " + result);

    }

    private static int solution(int A, int B, int K) {

        /**
         *  1. K로 나누었을 때 0이 나오는 값을 구함
         *  2. 1번 값으로 부터 K간격으로 몇개가 있는지 구함
         */
        int value = A; // A,B가 같은 경우 처리 ex) 10,10,7
        int result = 0;

        while (A != B + 1) {
            if(A % K == 0) {
                value = A;
                result++;
                break;
            }
            A++;
        }

        result += (B - value) / K;

        //int result = (B - A + 1) / K;

        return result;
    }
}
