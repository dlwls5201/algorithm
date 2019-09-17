package chapter8;

import java.util.HashMap;

public class EquiLeader {

    /**
     * 배열을 나눴을 때 지배자가 같은 경우의 수를 구하라
     */
    public static void main(String[] args) {

        int[] A = {4, 3, 4, 4, 4, 2};

        int result = solution2(A);
        System.out.println("result : " + result);

    }

    private static int solution2(int[] A) {

        int cases = 0;

        int leader = dominator(A);
        System.out.println("leader : " + leader);

        return cases;
    }

    //https://app.codility.com/demo/results/training4ANHYB-DM4/
    //O(n^2)
    private static int solution1(int[] A) {

        int cases = 0;

        for (int s = 0; s < A.length - 1; s++) {

            int[] pre = new int[s + 1];
            int[] post = new int[A.length - s - 1];

            for (int i = 0; i < A.length; i++) {

                if (i < s + 1) {
                    pre[i] = A[i];
                } else {
                    post[i - s - 1] = A[i];
                }

            }

            int preValue = dominator(pre);
            int postValue = dominator(post);

            if (postValue != -1 && preValue == postValue) cases++;
        }

        return cases;
    }

    private static int dominator(int[] A) {

        int value = -1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            if (hashMap.containsKey(A[i])) {
                int cnt = hashMap.get(A[i]);

                if (cnt >= A.length / 2) {
                    value = A[i];
                    break;
                } else {
                    hashMap.put(A[i], ++cnt);
                }
            } else {
                hashMap.put(A[i], 1);

                // A 값이 1개 일때만 예외 처리
                if (A.length == 1) value = A[i];
            }
        }

        return value;
    }
}
