package chapter10;

import java.util.ArrayList;

public class Flags {

    //peek 값에 flag 를 꽂을 수 있다.
    //K 개의 flag 를 꽂았다면 그 사이의 거리들이 K 이상이어야 한다.
    //이때 최대 K 를 구하라
    public static void main(String[] args) {

        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}; // 3
        //int[] A = {1, 3, 2}; // 1
        int result = new Flags().solution2(A);
        System.out.println("result : " + result);
    }

    private int solution2(int[] A) {

        //find peek
        ArrayList<Integer> peeks = new ArrayList<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peeks.add(i);
            }
        }

        if(peeks.size() == 1) return 1;




        return 0;
    }

    //https://app.codility.com/demo/results/training3B8H45-FQJ/
    //not correctness not performance
    private int solution1(int[] A) {

        //find peek
        ArrayList<Integer> peeks = new ArrayList<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peeks.add(i);
            }
        }

        if(peeks.size() == 1) return 1;

        for (int k = peeks.size(); k >= 1; k--) {

            int index = 0;
            int point = 0;
            int chance = peeks.size() - k;

            for (int j = 0; j < peeks.size() - 1; j++) {

                if (Math.abs(peeks.get(index) - peeks.get(j + 1)) >= k) {
                    point++;
                    index = j;
                    if (point == k - 1) return k;
                } else {
                    chance--;
                    if (chance < 0) break;
                }
            }
        }

        return 0;
    }

}
