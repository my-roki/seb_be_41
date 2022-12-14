package section2.daily_coding;

/*
# **decompression**

## **문제**

한 변의 길이가 2의 제곱수인 정사각형의 흑백 이미지가 2차원 배열로 주어집니다. 각 좌표에는 0(백) 또는 1(흑)이 저장되어 있습니다. 이미지에 포함된 데이터가 모두 1이면 `"1"`, 모두 0이면 `"0"` 한 글자로 압축할 수 있습니다. 그렇지 않은 경우, 이를 대문자 X로 표시하고 전체를 4등분하여 **재귀적으로 압축**합니다. 4등분한 영역의 순서는 좌측 상단, 우측 상단, 좌측 하단, 우측 하단입니다.

## **입력**

### **인자 1 : image**

- 배열을 요소로 갖는 배열
- `image.length`, `image[i].length`는 1,024 이하
- `image[i]`는 `int` 타입을 요소로 갖는 배열
- `image[i][j]`는 세로로 i, 가로로 j인 지점의 정보를 의미
- `image[i][j]`는 0 또는 1

## **출력**

- `String` 타입을 리턴해야 합니다.

## **주의사항**

- 두 배열의 길이의 합은 1,000,000 이하입니다.
- 어떤 배열 `arr`의 k번째 요소는 `arr[k-1]`을 의미합니다.

## **입출력 예시**

```
int[] image = new int[]{
  {1, 0, 1, 1},
  {0, 1, 1, 1},
  {0, 0, 1, 1},
  {0, 0, 0, 0}
};
String result = decompression(image);
System.out.println(result); // --> "XX100110X1100"

image = new int[]{
  {0, 0, 0, 0, 1, 1, 0, 0},
  {0, 0, 0, 0, 1, 1, 0, 0},
  {0, 0, 0, 0, 1, 1, 1, 0},
  {0, 0, 0, 0, 1, 1, 1, 0},
  {1, 1, 1, 1, 0, 0, 0, 0},
  {1, 1, 1, 1, 0, 0, 0, 0},
  {1, 1, 1, 1, 1, 0, 1, 1},
  {1, 1, 1, 1, 0, 1, 1, 1}
};
String result = decompression(image);
System.out.println(result); // --> 'X0X101X10101X00X10011'
```

## **Advanced**

- `decompression`과 반대로 정사각형으로 표현된 데이터를 압축한 문자열을 입력받아 원래의 사각형을 리턴하는 함수 `compression`을 작성해 보세요. 레퍼런스 코드는 따로 제공하지 않습니다.
 */

public class Q_57_decompression {
    public static void main(String[] args) {
        // write test case here
        Q_57_decompression coplit = new Q_57_decompression();

        int[][] image = new int[][]{
                {1, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };
        String result = coplit.decompression(image);
        System.out.println(result); // --> "XX100110X1100"

        image = new int[][]{
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1}
        };
        result = coplit.decompression(image);
        System.out.println(result); // --> 'X0X101X10101X00X10011'

    }

    public String decompression(int[][] image) {
        // 재귀를 이용한 문제풀이
        // 주어진 행렬에서 어떤 조건이 만족되는지 끝까지 확인하면서 결과를 추적해나갑니다.
        return recursion(0, image.length - 1, 0, image[0].length - 1, image);
    }

    // y좌표의 시작(Row Start), y좌표의 끝(Row End), x좌표의 시작(Col Start), x좌표의 끝(Col End)
    public String recursion(int rowStart, int rowEnd, int columnStart, int columnEnd, int[][] image) {
        if (rowStart == rowEnd) return String.valueOf(image[rowStart][columnStart]);

        // 좌상, 좌하, 우상, 우하로 구분합니다.
        int rowMiddle = (int) Math.floor((rowStart + rowEnd) / 2);
        int columnMiddle = (int) Math.floor((columnStart + columnEnd) / 2);

        String leftUp = recursion(rowStart, rowMiddle, columnStart, columnMiddle, image);
        String leftDown = recursion(rowMiddle + 1, rowEnd, columnStart, columnMiddle, image);
        String rightUp = recursion(rowStart, rowMiddle, columnMiddle + 1, columnEnd, image);
        String rightDown = recursion(rowMiddle + 1, rowEnd, columnMiddle + 1, columnEnd, image);

        String result = leftUp + rightUp + leftDown + rightDown;
        if (result.equals("1111")) return "1";
        else if (result.equals("0000")) return "0";
        else return "X" + result;
    }
}