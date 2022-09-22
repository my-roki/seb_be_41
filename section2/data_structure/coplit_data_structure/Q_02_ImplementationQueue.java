package section2.data_structure.coplit_data_structure;

/*
Implementation Queue
Queue 구현을 위한 기본적인 코드가 작성되어 있습니다. Queue 자료구조의 특성을 이해하고 FILL_ME_IN 을 채워 테스트를 통과해주세요.

멤버 변수
데이터를 저장할 Integer 타입을 요소로 가지는 ArrayList

메서드
add(): 큐에 데이터를 추가할 수 있어야 합니다.
poll(): 가장 먼저 추가된 데이터를 큐에서 삭제하고 삭제한 데이터를 리턴해야 합니다.
size(): 큐에 추가된 데이터의 크기를 리턴해야 합니다.
peek(): 큐에 가장 먼저 추가된 데이터를 리턴해야 합니다.
show(): 큐에 들어있는 모든 데이터를 String 타입으로 변환하여 리턴합니다.
clear(): 큐에 들어있는 모든 데이터를 삭제합니다.

사용 예시
Solution queue = new Solution();

queue.size(); // 0
for(int i = 1; i < 10; i++) {
  	queue.add(i);
}
queue.poll(); // 1
queue.poll(); // 2
queue.size(); // 7
queue.add(10);
queue.size(); // 8
queue.poll(); // 3
queue.poll(); // 4
queue.size(); // 6
...
 */

import java.util.ArrayList;

public class Q_02_ImplementationQueue {
    public static void main(String[] args) {
        // write test case here
        queueSolution queue = new queueSolution();

        System.out.println(queue.size()); // 0
        for (int i = 1; i < 10; i++) {
            queue.add(i);
        }
        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2
        System.out.println(queue.size()); // 7
        queue.add(10);
        System.out.println(queue.size()); // 8
        System.out.println(queue.poll()); // 3
        System.out.println(queue.poll()); // 4
        System.out.println(queue.size()); // 6

    }

}

class queueSolution {
    private ArrayList<Integer> listQueue = new ArrayList<Integer>();

    public void add(Integer data) {
        listQueue.add(data);
    }

    public Integer poll() {
        if (listQueue.size() == 0) {
            return null;
        } else {
            return listQueue.remove(0);
        }
    }

    public int size() {
        return listQueue.size();
    }

    public Integer peek() {
        if (listQueue.size() == 0) {
            return null;
        } else {
            return listQueue.get(0);
        }
    }

    public String show() {
        return listQueue.toString();
    }

    public void clear() {
        listQueue.clear();
    }
}