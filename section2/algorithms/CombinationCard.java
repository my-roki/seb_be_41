package section2.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationCard {
    public static void main(String[] args) {
        String[] lookup = new String[]{"A", "B", "C", "D", "E"};
        System.out.println("=== Combination Loop ===");
        System.out.println(combinationLoop(lookup).size());

        System.out.println("=== Combination Recursion ===");
        System.out.println(combinationRecursion(3, lookup).size());
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

    public static ArrayList<String[]> combinationRecursion(int round, String[] lookup) {
        ArrayList<String[]> result = new ArrayList<>();
        return recursion(0, round, new String[]{}, lookup, result);
    }

    public static ArrayList<String[]> recursion(int index, int round, String[] bucket, String[] lookup, ArrayList<String[]> result) {
        if (round == 0) {
            result.add(bucket);
            System.out.println(Arrays.toString(bucket));
            return result;
        }

        for (int i = index; i < lookup.length; i++) {
            if (Arrays.asList(bucket).contains(lookup[i])) continue;
            String[] newBucket = Arrays.copyOf(bucket, bucket.length + 1);
            newBucket[newBucket.length - 1] = lookup[i];

            result = recursion(i + 1, round - 1, newBucket, lookup, result);
        }
        return result;
    }
}