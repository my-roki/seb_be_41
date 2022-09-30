package section2.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationCard {
    public static void main(String[] args) {
        String[] lookup = new String[]{"A", "B", "C", "D", "E"};
        permutationLoop(lookup);

    }

    public static ArrayList<String[]> permutationLoop(String[] lookup) {
        ArrayList<String[]> result = new ArrayList<>();

        for (int i = 0; i < lookup.length; i++) {
            String pick1 = lookup[i];

            for (int j = 0; j < lookup.length; j++) {
                String pick2 = lookup[j];

                for (int k = 0; k < lookup.length; k++) {
                    String pick3 = lookup[k];

                    if (i == j || j == k || k == i) continue;
                    String[] input = new String[]{pick1, pick2, pick3};
                    result.add(input);
                    System.out.println(Arrays.toString(input));
                }
            }
        }
        return result;
    }
}