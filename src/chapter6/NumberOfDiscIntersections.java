package chapter6;

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
                //i 원의 오른쪽 값이 j 원의 왼쪽 값보다 작거나 같으면 교점이 있는 것
                if(i + A[i] >= j - A[j]) result++;
            }
        }

        return result;
    }

}
