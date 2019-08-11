package chater4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public static void main(String[] args) {

        int x = 5;
        int[] array = {1,3,1,4,2,3,5,4};

        int result = solution(x, array);
        System.out.println("result : " + result);
    }

    private static int solution(int X, int[] A) {

        Set<Integer> set = new HashSet<>();

        int result = -1;

        for(int i = 0; i < A.length; i++) {
            set.add(A[i]);

            if(set.size() == X) {
                result = i;
                break;
            }
        }

        return result;
    }
}
