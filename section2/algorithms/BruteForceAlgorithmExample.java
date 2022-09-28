package section2.algorithms;

import java.util.Arrays;

public class BruteForceAlgorithmExample {
    public static void main(String[] args) {
        BruteForceAlgorithmExample bfa = new BruteForceAlgorithmExample();

        // Sequential Search
        int[] arr = new int[]{234, 93, 4, 0, 73, 253,};
        boolean output = bfa.SequentialSearch(arr, 0);
        System.out.printf("Sequential Search : %s%n", output);

        // Brute Force String Match
        String word = "abcbacbaacacbccb";
        String pattern = "aba";
        output = bfa.BruteForceStringMatch(word, pattern);
        System.out.printf("Brute Force String Match : %s%n", output);

        // Selection Sort
        arr = new int[]{234, 93, 4, 0, 73, 253,};
        int[] result = bfa.SelectionSort(arr);
        System.out.printf("Selection Sort : %s%n", Arrays.toString(result));
    }


    // 입력: n개의 요소를 갖는 배열 arr와 검색 키 key
    // 출력: key값과 같은 요소 인덱스 또는 요소가 없을 때 false
    public boolean SequentialSearch(int[] arr, int key) {
        int n = arr.length;    // 현재의 배열 개수를 n에 할당합니다.
        boolean result = false;
        for (int candidate : arr) {
            if (candidate == key) {
                result = true;
            }
        }
        //배열을 순회하는 도중에, 해당하는 값이 발견되더라도 배열을 모두 순회한 이후에 결과값을 리턴
        return result;
    }

    // 입력: 텍스트 word, 패턴 patterm
    // 출력: 일치하는 문자열이 있으면 true를 반환합니다. 검색에 실패한 경우 false를 반환합니다.
    public boolean BruteForceStringMatch(String word, String pattern) {
        if (word.length() < pattern.length()) return true;

        for (int i = 0; i < word.length() - pattern.length(); i++) {
            String target = word.substring(i, i + pattern.length());
            if (target.equals(pattern)) return true;
        }
        return false;
    }

    // 주어진 배열을 Selection Sort로 오름차순 정렬합니다.
    // 입력: 정렬 가능한 요소의 배열 A
    // 출력: 오름차순으로 정렬된 배열
    public int[] SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 현재 i에 +1을 j로 반복문을 초기화하고 i 이후의 배열요소과 비교하는 반복문을 구성합니다.
                if (arr[j] < arr[min]) {
                    // j인덱스의 배열 값이 현재 인덱스의 배열 값보다 작다면
                    min = j;
                    // j 인덱스를 최소를 나타내는 인덱스로 할당합니다.
                }
            }
            // 반복문이 끝났을 때(모든 비교가 끝났을때) min에는 최소값의 인덱스가 들어있습니다.
            // i값과 최소값을 바꿔서 할당합니다.
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        // 모든 반복문이 끝나면 정렬된 배열을 반환합니다.
        return arr;
    }
}