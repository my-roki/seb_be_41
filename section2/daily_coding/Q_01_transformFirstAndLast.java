package section2.daily_coding;

/*
transformFirstAndLast

문제
배열을 입력받아 차례대로 배열의 첫 요소와 마지막 요소를 키와 값으로 하는 HashMap을 리턴해야 합니다.

입력
인자 1 : arr
String 타입을 요소로 갖는 배열

출력
HashMap<String, String> 타입의 값을 리턴해야 합니다.

주의 사항
빈 배열을 입력받은 경우, null을 리턴해야 합니다.
입력으로 받는 배열을 수정하지 않아야 합니다.

입출력 예시
String[] arr = new String[]{'Queen', 'Elizabeth', 'Of Hearts', 'Beyonce'};
HashMap<String, String> output = transformFirstAndLast(arr);
System.out.println(output); // --> { Queen : 'Beyonce' }

String[] arr = new String[]{'Kevin', 'Bacon', 'Love', 'Hart', 'Costner', 'Spacey'};
HashMap<String, String> output = transformFirstAndLast(arr);
System.out.println(output); // --> { Kevin : 'Spacey' }
 */


import java.util.HashMap;

public class Q_01_transformFirstAndLast {
    public static void main(String[] args) {
        // write test case here
        Q_01_transformFirstAndLast coplit = new Q_01_transformFirstAndLast();
        String[] arr1 = new String[]{"Queen", "Elizabeth", "Of Hearts", "Beyonce"};
        HashMap<String, String> output1 = coplit.transformFirstAndLast(arr1);
        System.out.println(output1); // --> { Queen : "Beyonce" }

        String[] arr2 = new String[]{"Kevin", "Bacon", "Love", "Hart", "Costner", "Spacey"};
        HashMap<String, String> output2 = coplit.transformFirstAndLast(arr2);
        System.out.println(output2); // --> { Kevin : 'Spacey' }
    }

    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        if (arr.length == 0) return null;
        HashMap<String, String> output = new HashMap<>();
        output.put(arr[0], arr[arr.length - 1]);
        return output;
    }

}