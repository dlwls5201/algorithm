package chapter12;

public class EuclideanAlgorithm {

    public static void main(String[] args) {

        int result = new EuclideanAlgorithm().solution(10 ,4);
        System.out.println("result : " + result);
    }

    //유클리드 호제법을 사용한 풀이
    //https://app.codility.com/demo/results/training2MPPV2-PYB/
    public int solution(int N, int M) {
        return N / gcd(N, M);
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
