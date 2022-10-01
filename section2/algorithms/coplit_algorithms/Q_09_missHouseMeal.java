package section2.algorithms.coplit_algorithms;

/*
# **집밥이 그리워**

## **문제**

김코딩은 몇 년의 해외 출장 끝에 본가에 내려왔습니다.
오랜만에 보는 김코딩의 얼굴에 반가웠던 부모님은 상다리가 부러질 정도로 음식을 만들었습니다.
감동의 재회도 잠시, 의자에 앉아 식사를 하려던 김코딩은 무엇부터 먹어야 될지 깊은 생각에 빠졌습니다.
정성스럽게 차려 주신 만큼, 최대한 많은 방법으로 다양하게 먹고 싶었기 때문입니다.

밥은 한 가지이며 반찬은 다수일 때, 밥과 함께 먹을 수 있는 반찬의 모든 경우의 수를 배열에 담아 리턴하세요.

## **입력**

### **인자 1: sideDishes**

- `String` 타입의 영문으로 된 반찬이 나열되어 있는 배열

## **출력**

- `ArrayList<String[]>` 타입을 리턴해야 합니다.
- 밥과 함께 먹을 수 있는 반찬의 모든 경우의 수가 담긴 배열을 포함한 `ArrayList`

## **주의사항**

- 반찬은 영문으로 작성이 되어 있습니다.
- 반찬은 중복되지 않습니다.
- 반찬을 먹지 않는 것도 포함됩니다. (출력되는 2차원 배열은 빈 배열을 포함합니다.)
- 반찬은 3개 이상 99개 이하입니다.
- 출력되는 배열은 전부 오름차순으로 정렬되어야 합니다.
ex)

## **입출력 예시**

```
ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
System.out.println(output);

// [ [],
//   [eggroll, fishSoup, kimchi],
//   [eggroll, fishSoup],
//   [eggroll, kimchi],
//   [eggroll],
//   [fishSoup, kimchi],
//   [fishSoup],
//   [kimchi],
// ]
```
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Q_09_missHouseMeal {
    public static void main(String[] args) {
        // write test case here
        Q_09_missHouseMeal coplit = new Q_09_missHouseMeal();

        ArrayList<String[]> output = coplit.missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
        System.out.println(output);

        // [ [],
        //   [eggroll, fishSoup, kimchi],
        //   [eggroll, fishSoup],
        //   [eggroll, kimchi],
        //   [eggroll],
        //   [fishSoup, kimchi],
        //   [fishSoup],
        //   [kimchi],
        // ]

    }

    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        ArrayList<String[]> output = new ArrayList<>();
        Arrays.sort(sideDishes); //정렬

        output = recursion(0, sideDishes, new ArrayList<String>(), output);
        output.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2))); // 정렬
        return output;
    }


    public static ArrayList<String[]> recursion(int round, String[] sideDishes, ArrayList<String> bucket, ArrayList<String[]> output) {
        // 탈출구 : 모든 음식에 대하여 선택(또는 선택하지 않음)
        if (round == sideDishes.length) {
            String[] arr = bucket.toArray(new String[0]);
            output.add(arr);
            System.out.println(Arrays.toString(arr));
            return output;
        }

        // 경우의 수는 모든 음식에 대하여 선택하냐, 선택하지 않느냐 두 가지만 존재합니다(총 경우의 수는 2^음식수).
        // 따라서 모든 음식에 대하여 선택하면 bucket에 담고, 선택하지 않으면 bucket에 담지 않는 방법으로 모든 경우의 수를 구할 수 있습니다.
        for (int ispick = 0; ispick < 2; ispick++) {
            // bucket이 이전 것드과 중복되지 않도록 깊은 복사
            ArrayList<String> newBucket = (ArrayList<String>) bucket.clone();

            // 만약 음식을 선택한다면 bucket에 음식을 담고, 그렇지 않으면 음식을 담지 않습니다.
            if (ispick == 0) newBucket.add(sideDishes[round]);

            // 음식 갯수만큼 음식을 담을 것인지 담지 않을 것인지 재귀함수를 호출합니다.
            output = recursion(round + 1, sideDishes, newBucket, output);
        }
        return output;
    }
}
