package chapter10;

public class MinPerimeterRectangle {

    // 같은 넓이를 가질때 가장 작은 둘레의 값을 구하시오
    public static void main(String[] args) {
        int result = solution(30);
        System.out.println("result : " + result);
    }

    //https://app.codility.com/demo/results/trainingR6QD2G-Q3Q/
    private static int solution(int N) {

        int minPerimeter = Integer.MAX_VALUE;

        for (int i = 1; i <= Math.sqrt(N); i++) {

            if (N % i == 0) {
                minPerimeter = Math.min(minPerimeter, getPerimeter(i, N / i));
            }
        }

        return minPerimeter;
    }

    private static int getPerimeter(int width, int height) {
        return (width + height) * 2;
    }
}
