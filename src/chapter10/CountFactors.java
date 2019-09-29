package chapter10;

public class CountFactors {

    //정수 N의 요소를 구하기 -> 배수들을 구하라
    public static void main(String[] args) {

        int N = 25;
        int result = solution3(N);
        System.out.println("result : " + result);
    }

    //https://app.codility.com/demo/results/trainingZEW6RJ-PU8/
    //O(sqrt(N))
    private static int solution3(int N) {

        int result = 0;

        for (int i = 1; i <= Math.sqrt(N); i++) {

            if (i * i == N) result += 1;
            else if (N % i == 0) result += 2;

        }

        return result;
    }

    //https://app.codility.com/demo/results/trainingPJ7J3S-JFX/
    //O(sqrt(N))
    private static int solution2(int N) {

        double i = 1;
        int result = 0;

        while (i * i < N) {

            if (N % i == 0) {
                result += 2;
            }

            i++;
        }

        if (i * i == N) result += 1;

        return result;
    }

    //https://app.codility.com/demo/results/trainingJ7E5EJ-R59/
    //O(N)
    private static int solution1(int N) {

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
            }
        }

        return count;
    }
}
