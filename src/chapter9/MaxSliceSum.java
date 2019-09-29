package chapter9;

public class MaxSliceSum {

    /**
     * 합이 가장 큰 부분집합을 구하라
     */
    public static void main(String[] args) {

        int[] A = {3, 2, -6, 4, 0};
        //int[] A = {-10};
        //int[] A = {5, -7, 3, 5, -2, 4, -1};
        //int[] A = {-20000, -1, -10};

        int result = solution3(A);
        System.out.println("result : " + result);

    }

    //https://app.codility.com/demo/results/trainingJ3694H-EGD/
    private static int solution3(int[] A) {

        int slice = 0;
        int max = A[0];

        for (int a : A) {

            slice = Math.max(a, slice + a);
            max = Math.max(max, slice);

        }

        return max;
    }

    /**
     *  합이 0보다 작아지는 시점부터 최대값을 다시 계산해준다.
     */
    //https://app.codility.com/demo/results/trainingDS3PXQ-47B/
    private static int solution2(int[] A) {

        int current = 0;
        int max = A[0];

        for (int a : A) {

            current += a;

            if (current < 0) {
                //int[] A = {-20000, -1, -10} 처럼 마이너스만 있는 경우 처리
                max = Math.max(current, max);

                current = 0;
            } else{
                max = Math.max(current, max);
            }

        }

        return max;
    }

    //https://app.codility.com/demo/results/trainingBGPVDS-YM4/
    //O(n^2)
    private static int solution1(int[] A) {

        int size = A.length;
        int result = A[0];

        for (int i = 0; i < size; i++) {

            int sum = 0;

            for (int j = i; j < size; j++) {

                sum += A[j];
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
