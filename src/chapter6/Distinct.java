package chapter6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public static void main(String[] args) {

    }

    private static int solution(int[] A) {

        Set<Integer> setA = new HashSet<>();

        for(int a: A) {
            setA.add(a);
        }

        return setA.size();
    }
}
