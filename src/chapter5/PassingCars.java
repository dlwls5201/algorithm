package chapter5;

//https://app.codility.com/demo/results/trainingRZZWBD-HPE/
public class PassingCars {

    public static void main(String[] args) {

        int[] A = {0,1,0,1,1};

        int result = solution(A);
        System.out.println("result : " + result);

    }

    private static int solution(int[] A) {

        int zeroCnt = 0;
        int result = 0;

        for (int value : A) {
            if (value == 0) {
                zeroCnt++;
            } else if(value == 1) {
                result += zeroCnt;
            }

            if(result > 1000000000) {
                return -1;
            }
        }

        return result;
    }
}
