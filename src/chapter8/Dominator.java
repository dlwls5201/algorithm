package chapter8;

import java.util.HashMap;

//https://app.codility.com/demo/results/trainingZKNGGS-GGS/
//TODO O(N*lonN) or N 인데 O(N*lonN)는 왜 나오는 거지?
public class Dominator {

    //A 배열 중에서 절반 이상을 차지하는 요소의 인덱스를 반환해라
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
