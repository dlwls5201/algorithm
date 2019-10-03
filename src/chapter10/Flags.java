package chapter10;

import java.util.ArrayList;
import java.util.List;

public class Flags {

    //peek 값에 flag 를 꽂을 수 있다.
    //K 개의 flag 를 꽂았다면 그 사이의 거리들이 K 이상이어야 한다.
    //이때 최대 K 를 구하라
    public static void main(String[] args) {

        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}; // 3
        //int[] A = {1, 3, 2}; // 1
        int result = new Flags().solution3(A);
        System.out.println("result : " + result);
    }

    private int solution3(int[] A) {

        //find peek index
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        System.out.println("peaks : " + peaks);

        //예외 처리 : {1, 3, 2} -> 1개 , {1, 3, 2, 3, 1} -> 2개
        if (peaks.size() < 3) return peaks.size();

        int result = 0;

        for (int k = 2; k <= peaks.size(); k++) {


        }

        return result;
    }

    //https://sweetroute.tistory.com/entry/CodilityFlags
    //solution1과 동일 -> 순서만 반대
    private int solution2(int[] A) {

        //find peek index
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        System.out.println("peaks : " + peaks);

        //예외 처리 : {1, 3, 2} -> 1개 , {1, 3, 2, 3, 1} -> 2개
        if (peaks.size() < 3) return peaks.size();

        int result = 0;

        for (int k = 2; k <= peaks.size(); k++) {

            int index = 0;
            int point = 0;
            int chance = peaks.size() - k;

            for (int i = 0; i < peaks.size() - 1; i++) {

                if (Math.abs(peaks.get(index) - peaks.get(i + 1)) >= k) {
                    index = i + 1;
                    point++;

                    if(point == k - 1) {
                        result = k;
                        break;
                    }

                } else {

                    chance--;
                    if(chance < 0) break;
                }
            }
        }

        return result;
    }

    //https://app.codility.com/demo/results/trainingXJNXQ7-79H/
    //no performance
    private int solution1(int[] A) {

        //find peek index
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        System.out.println("peaks : " + peaks);

        //예외 처리 : {1, 3, 2} -> 1개 , {1, 3, 2, 3, 1} -> 2개
        if (peaks.size() < 3) return peaks.size();

        for (int k = peaks.size(); k >= 1; k--) {

            int index = 0;
            int point = 0;
            int chance = peaks.size() - k;

            for (int j = 0; j < peaks.size() - 1; j++) {

                if (Math.abs(peaks.get(index) - peaks.get(j + 1)) >= k) {
                    index = j + 1;
                    point++;
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
