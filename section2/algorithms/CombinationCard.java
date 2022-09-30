package section2.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationCard {
    public static void main(String[] args) {
        String[] lookup = new String[]{"A", "B", "C", "D", "E"};
        combinationLoop(lookup);
    }

    public static ArrayList<String[]> combinationLoop(String[] lookup) {
        ArrayList<String[]> result = new ArrayList<>();

        for (int i = 0; i < lookup.length; i++) {
            for (int j = i + 1; j < lookup.length; j++) {
                for (int k = j + 1; k < lookup.length; k++) {
                    String[] input = new String[]{lookup[i], lookup[j], lookup[k]};
                    result.add(input);
                    System.out.println(Arrays.toString(input));
                }
            }
        }
        return result;
    }
}