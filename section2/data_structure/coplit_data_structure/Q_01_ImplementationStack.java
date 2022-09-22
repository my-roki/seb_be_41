package section2.data_structure.coplit_data_structure;

/*
Implementation Stack
Stack 구현을 위한 기본적인 코드가 작성되어 있습니다.
Stack 자료구조의 특성을 이해하고 FILL_ME_IN을 채워 테스트를 통과해 주세요.

멤버 변수
데이터를 저장할 Integer 타입을 요소로 가지는 ArrayList

메서드
push(): 스택에 데이터를 추가할 수 있어야 합니다.
pop(): 가장 나중에 추가된 데이터를 스택에서 삭제하고 삭제한 데이터를 리턴해야 합니다.
size(): 스택에 추가된 데이터의 크기를 리턴해야 합니다.
peek(): 가장 나중에 추가된 데이터를 리턴해야 합니다.
show(): 현재 스택에 포함되어 있는 모든 데이터를 String 타입으로 변환하여 리턴합니다.
clear(): 현재 스택에 포함되어 있는 모든 데이터 삭제합니다.

사용 예시
Solution stack = new Solution();

stack.size(); // 0
for(int i = 1; i < 10; i++) {
  	stack.push(i);
}
stack.pop(); // 9
stack.pop(); // 8
stack.size(); // 7
stack.push(8);
stack.size(); // 8
...
 */

import java.util.ArrayList;

public class Q_01_ImplementationStack {
    public static void main(String[] args) {
        // write test case here
        stackSolution stack = new stackSolution();

        System.out.println(stack.size()); // 0
        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop()); // 9
        System.out.println(stack.pop()); // 8
        System.out.println(stack.size()); // 7
        stack.push(8);
        System.out.println(stack.size()); // 8

    }

}

class stackSolution {
    private ArrayList<Integer> listStack = new ArrayList<Integer>();

    public void push(Integer data) {
        listStack.add(data);
    }

    public Integer pop() {
        if (listStack.size() == 0) {
            return null;
        } else {
            return listStack.remove(listStack.size() - 1);
        }
    }

    public int size() {
        return listStack.size();
    }

    public Integer peek() {
        if (listStack.size() == 0) {
            return null;
        } else {
            return listStack.get(listStack.size() - 1);
        }
    }

    public String show() {
        return listStack.toString();
    }

    public void clear() {
        listStack.clear();
    }
}
