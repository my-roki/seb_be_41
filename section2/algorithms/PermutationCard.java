package section2.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationCard {
    public static void main(String[] args) {
        String[] lookup = new String[]{"A", "B", "C", "D", "E"};
        System.out.println("=== Permutation Loop ===");
        System.out.println(permutationLoop(lookup).size());

        System.out.println("=== Permutation Recursion ===");
        System.out.println(permutationRecursion(3, lookup).size());

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

    public static ArrayList<String[]> permutationRecursion(int round, String[] lookup) {
        ArrayList<String[]> result = new ArrayList<>();
        return recursion(round, new String[]{}, lookup, result);
    }

    public static ArrayList<String[]> recursion(int round, String[] bucket, String[] lookup, ArrayList<String[]> result) {
        if (round == 0) {
            result.add(bucket);
            System.out.println(Arrays.toString(bucket));
            return result;
        }

        for (String s : lookup) {
            String[] newBucket = Arrays.copyOf(bucket, bucket.length + 1);
            newBucket[newBucket.length - 1] = s;
            String[] filterLookup = Arrays.stream(lookup).filter(n -> !n.equals(s)).toArray(String[]::new);

            result = recursion(round - 1, newBucket, filterLookup, result);
        }
        return result;
    }
}