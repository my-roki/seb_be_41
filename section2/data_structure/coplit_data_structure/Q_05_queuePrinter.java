package section2.data_structure.coplit_data_structure;

/*
프린터
문제
김코딩은 최근 인쇄할 일이 많이 생겨 창고에서 안 쓰던 프린터를 꺼냈습니다.
이 프린터의 성능을 테스트하여 새로운 프린터를 장만할지 결정하려고 합니다.
김코딩은 프린터의 인쇄 작업 목록의 크기와 최대 용량을 가정하고 각기 다른 용량의 문서를 차례대로 인쇄하여
모든 문서가 인쇄되는데 최소 몇 초가 걸리는지 테스트하기로 했습니다. 프린터 인쇄 작업 목록의 제한사항은 다음과 같습니다.

[제한사항]
- 인쇄 작업 목록은 칸으로 이루어져 있습니다.
- 각 칸에는 한 개의 문서만 위치할 수 있습니다.
- 문서는 1초에 한 칸만 이동할 수 있습니다.
- 인쇄 작업 목록의 크기는 bufferSize이고 최대 용량 capacities 만큼 문서를 담을 수 있습니다.

만약, 인쇄 작업 목록의 크기가 2이고 최대 용량이 10Kib라면 크기가 [7, 4, 5, 6] Kib인 문서들이
최단 시간 안에 순서대로 모두 인쇄되는 과정은 다음과 같습니다.

1. 1초가 지나면 인쇄 작업 목록에는 7Kib 크기의 문서가 추가됩니다.
2. 2초일 때 인쇄 작업 목록의 최대 용량이 10Kib이기 때문에 4Kib 문서는 작업 목록에 들어갈 수 없습니다.
   동시에 7Kib 문서는 작업 목록에서 1칸 앞으로 이동합니다.
3. 3초일 때 7Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 4Kib 문서는 인쇄 작업 목록에 추가됩니다.
4. 4초일 때 4Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다. 동시에 5Kib 문서는 인쇄 작업 목록에 추가됩니다.
5. 5초일 때 4Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 5Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다.
   최대 용량 10Kib 제한으로 6Kib 문서는 인쇄 작업 목록으로 추가될 수 없습니다.
6. 6초일 때 5Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 6Kib 문서가 인쇄 작업 목록에 추가됩니다.
7. 7초일 때 6Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다.
8. 8초일 때 6Kib 문서가 마지막으로 인쇄됩니다.

위 예시에서와 같이 모든 문서가 출력되는데 걸리는 최소 시간은 8초가 걸립니다.

김코딩이 가지고 있는 프린터의 제한사항인 인쇄 작업 목록의 크기 bufferSize, 최대 용량 capacities가 주어집니다.
인쇄할 문서의 크기가 나열된 배열 documents가 모두 인쇄되는데 걸리는 최소 시간을 반환하는 솔루션을 만들어 주세요.

입력
인자1: bufferSize
int 타입의 인쇄 작업 목록 크기
인자 2: capacities
int 타입의 인쇄 작업 목록에 추가될 수 있는 최대 용량
인자 3: documents
int 타입을 요소로 갖는 문서 크기가 나열된 배열

출력
int 타입을 리턴해야 합니다.

주의사항
bufferSize는 1 이상 100 이하입니다.
capacities는 100Kib 이하입니다.
인쇄할 문서의 개수(배열의 길이) 1이상 100 이하입니다.
문서 하나의 크기는 capacities를 초과하지 않습니다.

입출력 예시
int bufferSize = 2;
int capacities = 10;
int[] documents = new int[]{7, 4, 5, 6};

int output = queuePrinter(bufferSize, capacities, documents);
System.out.println(output) // 8
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q_05_queuePrinter {
    public static void main(String[] args) {
        // write test case here
        Q_05_queuePrinter coplit = new Q_05_queuePrinter();
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5, 6};

        int output = coplit.queuePrinter(bufferSize, capacities, documents);
        System.out.println(output); // 8

        bufferSize = 2;
        capacities = 10;
        documents = new int[]{0, 0, 0};

        output = coplit.queuePrinter(bufferSize, capacities, documents);
        System.out.println(output); // 0
    }

    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        if (Arrays.stream(documents).sum() == 0) return 0;
        // 원본 유지, 배열보다 요소 삭제가 더 쉬운 ArrayList로 documents를 새로 만들어줍니다
        ArrayList<Integer> copyDocs = new ArrayList<>();
        for (int i : documents) copyDocs.add(i);

        // 프린터 생성
        int[] printer = new int[bufferSize];

        int time = 0;
        while (copyDocs.size() != 0) {  // 프린트에 모든 용지가 들어갈때까지
            int inputDoc = copyDocs.get(0);  // 프린트에 들어가야 할 첫번째 문서
            // 프린트 안에 있는 문서의 capacity + 들어가야 할 문서의 capacity를 비교해서
            if (Arrays.stream(printer).sum() + inputDoc <= capacities) {
                printing(printer, bufferSize, inputDoc);   // 프린트의 총 capacity보다 작으면 문서가 들어가고,
                copyDocs.remove(0);
            } else {
                printing(printer, bufferSize, 0);  // 프린트의 총 capacity보다 크면 못 들어갑니다.(0이 들어갑니다)
            }
            time++;  // 프린트가 한 칸 이동하면 1초가 흐릅니다
        }
        // 프린트에 모든 문서가 들어가면, 마지막 문서가 나오기까지 걸리는 시간은 bufferSize초
        return time + bufferSize;
    }

    // 프린트는 문서가 들어오던 안 들어오던 매번 한칸씩 앞으로 이동합니다.
    public static void printing(int[] printer, int bufferSize, int inputDoc) {
        for (int i = 1; i < bufferSize - 1; i++) {
            printer[i] = printer[i + 1];
        }
        printer[bufferSize - 1] = inputDoc;
    }
}
