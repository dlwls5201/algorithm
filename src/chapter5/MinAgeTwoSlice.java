package chapter5;

public class MinAgeTwoSlice {

    public static void main(String[] args) {

        int[] A = {4,2,2,5,1,5,8};

        int result = solution(A);
        System.out.println("result : " + result);
    }

    //https://app.codility.com/demo/results/trainingY88WSW-KRJ/
    private static int solution(int[] A) {

        float minTwoAvg = (A[0] + A[1]) / 2f;
        int posTwoAvg = 0;

        for(int i = 0; i < A.length - 1; i++) {
            float tempTwoAge = (A[i] + A[i+1]) / 2f;

            if(tempTwoAge < minTwoAvg) {
                minTwoAvg = tempTwoAge;
                posTwoAvg = i;
            }
        }

        float minThreeAvg = 0;
        int posThreeAvg = 0;

        if(A.length > 2) {

            minThreeAvg = (A[0] + A[1] + A[2]) / 3f;

            for(int i = 0; i < A.length - 2; i++) {
                float tempThreeAvg = (A[i] + A[i+1] + A[i+2]) / 3f;

                if(tempThreeAvg < minThreeAvg) {
                    minThreeAvg = tempThreeAvg;
                    posThreeAvg = i;
                }
            }
        }

        return minTwoAvg < minThreeAvg ? posTwoAvg : posThreeAvg;
    }
}
