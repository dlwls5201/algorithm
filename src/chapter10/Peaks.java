package chapter10;

import java.util.ArrayList;

public class Peaks {

    //값은 사이즈의 블록으로 나눌 때 Peek 값을 가지고 있는지 확인해라
    //배열 A가 나눌 수 있는 블록의 최대 수를 구하라
    public static void main(String[] args) {

        //int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int[] A = {1, 2, 3, 4, 5, 6};
        //int[] A = {0, 1, 0, 0, 1, 0, 0, 1, 0};

        int result = new Peaks().solution2(A);
        System.out.println("result : " + result);
    }

    //https://app.codility.com/demo/results/trainingY5QHH8-Z4D/
    //O(N * log(log(N)))
    public int solution2(int[] A) {

        int maxBlockCnt = 0;

        if (A.length < 3) return maxBlockCnt;

        //A의 배수를 구한다.
        //peek 값을 가지기 위해서는 최소 3개의 인자를 가진 블록으로 나눠야 한다.
        for (int i = 3; i <= A.length; i++) {

            //i는 한 블록의 인자 갯수를 의미한다.
            if (A.length % i == 0) {

                if (isPeekFromDividerBlock(i, A)) {
                    maxBlockCnt = A.length / i;
                    return maxBlockCnt;
                }
            }
        }

        return maxBlockCnt;
    }

    //A 배열을 param 갯수를 가진 블록으로 나눈다.
    private Boolean isPeekFromDividerBlock(int param, int[] A) {

        Boolean isPeek = false;

        int i = 0;
        int size = param;

        //param 갯수로 A 배열을 나눠 ArrayList 에 넣어준다.
        while (size <= A.length) {

            ArrayList<Integer> temp = new ArrayList<>();

            int index = 0;

            //처음이 아니면 인접 인덱스를 넣어준다
            if (i != 0) {
                temp.add(index, A[i - 1]);
                index++;
            }

            for (int j = i; j < size; j++) {

                temp.add(index, A[j]);
                index++;

                //마지막이 아니면 인접 인덱스를 넣어준다.
                if (j == size - 1 && j < A.length - 1) {
                    temp.add(index, A[j + 1]);
                }
            }

            i += param;
            size += param;

            isPeek = isPeekValue(temp);
            //System.out.println("temp : " + temp + " , isPeek : " + isPeek);

            if (!isPeek) return false;
        }

        return isPeek;
    }

    //ArrayList 가 peek 값을 가지고 있는지 확인한다.
    private Boolean isPeekValue(ArrayList<Integer> A) {

        for (int i = 1; i < A.size() - 1; i++) {
            if (A.get(i - 1) < A.get(i) && A.get(i) > A.get(i + 1)) {
                return true;
            }
        }

        return false;
    }


    //배열의 피크값을 구한다.
    private ArrayList<Integer> getPeekIndex(int[] A) {

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                temp.add(i);
            }
        }

        return temp;
    }

    /**
     * 1. peek 값을 가지기 위해서는 최소 3개의 인자를 가진 블록으로 나눠야 한다.
     * 2. 각 블록마다 peek 값이 있는지 확인하라(인접한 값도 peek 체크에 사용된다)
     * <p>
     * ps : 전체 피크값을 구하고 나눈 블록이 피크값을 가지고 있는지 확인하자
     */
    //https://app.codility.com/demo/results/trainingDC54CF-NB6/
    //O(n^2)
    public int solution1(int[] A) {

        int maxBlockCnt = 0;

        if (A.length < 3) return maxBlockCnt;

        for (int i = 3; i <= A.length; i++) {

            if (A.length % i == 0) {
                //System.out.println("-- i : " + i + " -> 최대 갯수 : " + (A.length / i));
                if (isPeekFromDividerBlock(i, A)) maxBlockCnt = Math.max(maxBlockCnt, A.length / i);
            }

        }

        return maxBlockCnt;
    }
}
