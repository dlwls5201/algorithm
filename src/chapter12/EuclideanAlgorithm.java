package chapter12;

public class EuclideanAlgorithm {

    public static void main(String[] args) {

        int result = new EuclideanAlgorithm().solution(10 ,4);
        System.out.println("result : " + result);
    }

    //유클리드 호제법을 사용한 풀이
    //https://app.codility.com/demo/results/training2MPPV2-PYB/
    public int solution(int N, int M) {
        return N / gcd1(N, M);
    }

    private int gcd1(int a, int b) {

        //큰값 찾기(m > n)
        int m, n;

        if(a > b) {
            m = a; n = b;
        } else {
            m = b; n = a;
        }

        //큰 값을 작은 값으로 나눈다.
        //나눈 값이 0이 될 때 까지 반복한다.
        //나머지가 0이 되면 나눈 값이 최대공약수가 된다.
        while (n != 0) {
            int temp = m;
            m = n;
            n = temp % n;
        }

        return m;
    }

    private int gcd2(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd2(b, a % b);
        }
    }

}
