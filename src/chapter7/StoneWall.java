package chapter7;

import java.util.HashSet;
import java.util.Set;

public class StoneWall {

    public static void main(String[] args) {

        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};

        int result = solution(H);
        System.out.println("result : " + result);

    }

    //https://app.codility.com/demo/results/trainingB2UKVN-PYJ/
    private static int solution(int[] H) {

        Set<Integer> set = new HashSet<>();
        int minHeight = H[0];
        int recCnt = 0;

        for (int h : H) {

            if (minHeight > h) {
                minHeight = h;
                recCnt += set.size();

                set.clear();
            }

            set.add(h);
        }

        recCnt += set.size();

        return recCnt;
    }
}
