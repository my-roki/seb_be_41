package section2.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationPrimeNumber {
    public static void main(String[] args) {
        PermutationPrimeNumber coplit = new PermutationPrimeNumber();
        int[] numbers = new int[]{2, 3, 5};
        int[] output = coplit.getPrimeNumber(numbers);
        System.out.println(Arrays.toString(output));  // [523]
    }

    public int[] getPrimeNumber(int[] numbers) {
        ArrayList<Integer> result = recursion(numbers, numbers.length, "", new ArrayList<>());

        ArrayList<Integer> output = new ArrayList<>();
        for (int number : result) {
            if (number == 1) continue;
            if (number == 2) continue;
            if (number % 2 == 0) continue;
            boolean isPrime = true;
            for (int i = 3; i < Math.sqrt(number); i += 2) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) output.add(number);
        }
        return output.stream().mapToInt(i -> i).toArray();
    }

    public ArrayList<Integer> recursion(int[] numbers, int round, String bucket, ArrayList<Integer> result) {
        if (round == 0) {
            result.add(Integer.parseInt(bucket));
            return result;
        }

        for (int n : numbers) {
            String newBucket = bucket;
            newBucket += Integer.toString(n);
            int[] filterNumber = Arrays.stream(numbers).filter(i -> i != n).toArray();

            result = recursion(filterNumber, round - 1, newBucket, result);
        }
        return result;
    }
}