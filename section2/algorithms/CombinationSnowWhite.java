package section2.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSnowWhite {
    public static void main(String[] args) {
        CombinationSnowWhite coplit = new CombinationSnowWhite();
        int[] dwarf = new int[]{20, 7, 23, 19, 10, 15, 25, 8, 13};
        ArrayList<int[]> output = coplit.snowwhite(dwarf);
        // [7, 8, 10, 13, 19, 20, 23]
        for (int[] i : output) {
            System.out.println(Arrays.toString(i));
        }
    }

    public ArrayList<int[]> snowwhite(int[] dwarf) {
        // 2명의 난쟁이를 선택하는 경우
        ArrayList<int[]> candidate = new ArrayList<>();
        for (int i = 0; i < dwarf.length; i++) {
            for (int j = i + 1; j < dwarf.length; j++) {
                int[] input = new int[]{dwarf[i], dwarf[j]};
                candidate.add(input);
            }
        }

        // 선택된 난쟁이 2명의 키를 전체 난쟁이 키에서 빼서 100인 경우를 담기
        ArrayList<int[]> output = new ArrayList<>();
        int allDwarfHeights = Arrays.stream(dwarf).sum();
        for (int[] pick : candidate) {
            int pickHeight = Arrays.stream(pick).sum();
            if (allDwarfHeights - pickHeight == 100) {
                int[] seven = Arrays.stream(dwarf)
                        .filter(i -> i != pick[0] && i != pick[1])
                        .sorted()
                        .toArray();
                output.add(seven);
            }
        }
        return output;
    }
}
