package chater4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingInteger {

    public static void main(String[] args) {

        int[] array = {4, 5, 6, 2};
        int result = solution(array);
        System.out.println("result : " + result);
    }

    private static int solution(int[] A) {

        int result = 1;

        Arrays.sort(A);

        List<Integer> positiveArray = new ArrayList<>();

        for(int a: A) {
            if(a > 0) {
                positiveArray.add(a);
            }
        }

        if(positiveArray.size() > 1) {
            // ex { 2, 3, 4, ..}
            if(positiveArray.get(0) != 1) {
                return 1;
            }

            // other
            for(int i = 1; i < positiveArray.size(); i++) {
                if(positiveArray.get(i-1) - positiveArray.get(i) < -1) {
                    result = positiveArray.get(i-1) + 1;
                    break;
                }
                if(i == positiveArray.size()-1) {
                    result = positiveArray.get(i) + 1;
                }
            }

        } else if(positiveArray.size() == 1){
            // ex { 1 }
            if(positiveArray.get(0) == 1) {
                result = 2;
            }
        }

        return result;
    }

}
