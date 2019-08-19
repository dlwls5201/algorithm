package chapter4;

import java.util.Arrays;

public class MaxCounters {

    public static void main(String[] args) {

        int[] array = {3,4,4,6,1,4,4};
        int N = 5;

        int[] result = solution(N, array);
        System.out.println(Arrays.toString(result));

    }

    private static int[] solution(int N, int[] A) {

        //초기값 0
        int[] result = new int[N];

        //N 배열의 초기값
        int initValue = 0;

        //N 배열의 최대값
        int max = 0;

        for(int a : A) {
            if(a >= 1 && a <= N) {
                int value = initValue > result[a-1] ? initValue : result[a-1];
                result[a-1] = ++value;
                if(value > max) max = value;
            } else {
                initValue = max;
            }
        }

        initArrayMinToValue(result, initValue);

        return result;
    }

    private static void initArrayMinToValue(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            if(value > array[i]) {
                array[i] = value;
            }
        }
    }

    /**
     * Time out
     */
    /*private static int[] solution(int N, int[] A) {

        //초기값 0
        int[] result = new int[N];

        //N 배열의 최대값
        int max = 0;

        for(int a : A) {
            if(a >= 1 && a <= N) {
                int value = result[a-1];
                result[a-1] = ++value;
                if(value > max) max = value;
            } else {
                initArrayToValue(result, max);
            }
        }

        return result;
    }

    private static void initArrayToValue(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }*/
}
