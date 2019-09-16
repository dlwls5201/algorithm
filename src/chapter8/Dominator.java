package chapter8;

import java.util.HashMap;

//https://app.codility.com/demo/results/trainingZKNGGS-GGS/
//TODO O(N*lonN) or N 인데 O(N*lonN)는 왜 나오는 거지?
public class Dominator {

    /**
     *
     * A 배열 중에서 절반을 초과하는 요소의 인덱스를 반환해라
     *
     *  - 절반을 초과하는 지배자는 1개만 존재한다.
     *  - 지배자를 나타내는 인덱스 중 아무거나 리턴하면 되므로 배열 절반을 초과하는 인덱스가 보이면 바로 리턴한다.
     */
    public static void main(String[] args) {

        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};

        int result = solution(A);
        System.out.println("result : " + result);

    }

    private static int solution(int[] A) {

        int index = -1;

        /**
         * Key : A[i]
         * Value : A[i]와 같은 요소의 갯수
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            if (hashMap.containsKey(A[i])) {
                int cnt = hashMap.get(A[i]);

                if(cnt >= A.length/2) {
                    index = i;
                    break;
                } else {
                    hashMap.put(A[i], ++cnt);
                }
            } else {
                hashMap.put(A[i], 1);

                // A 값이 1개 일때만 예외 처리
                if(A.length == 1) index = i;
            }
        }

        return index;
    }
}
