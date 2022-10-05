package section2.daily_coding;

/*
# **treeBFS**

## **문제**

임의의 tree를 구성하는 노드 중 하나의 `Node` 객체를 입력받아, 해당 노드를 시작으로 너비 우선 탐색(BFS, Breadth First Search)을 합니다.
이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴해야 합니다.

## **입력**

### **인자 1 : node**

- `'value'`, `'children'` 속성을 갖는 객체 (Solution.tree)
- `'node.value'`는 `String` 타입
- `'node.children'`은 Solution.tree을 요소로 갖는 `ArrayList`

## **출력**

- `ArrayList<String>` 타입을 리턴해야 합니다.

## **주의사항**

- 생성자 함수(`Node`)와 메소드(`addChild`)는 변경하지 않아야 합니다.

## **입출력 예시**

```
Solution.tree root = new Solution.tree("1");
Solution.tree rootChild1 = test.addChildNode(new Solution.tree("2"));
Solution.tree rootChild2 = test.addChildNode(new Solution.tree("3"));
Solution.tree leaf1 = rootChild1.addChildNode(new Solution.tree("4"));
Solution.tree leaf2 = rootChild1.addChildNode(new Solution.tree("5"));
ArrayList<String> output = bfs(root);
System.out.println(output); // --> ["1", "2", "3", "4", "5"]

leaf1.addChildNode(new Solution.tree("6"));
rootChild2.addChildNode(new Solution.tree("7"));
output = bfs(root);
System.out.println(output); // --> ["1", "2", "3", "4", "5", "7", "6"]
```
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q_27_treeBFS {
    public static void main(String[] args) {
        // write test case here
        Q_27_treeBFS coplit = new Q_27_treeBFS();

        Q_27_treeBFS.tree root = new Q_27_treeBFS.tree("1");
        Q_27_treeBFS.tree rootChild1 = root.addChildNode(new Q_27_treeBFS.tree("2"));
        Q_27_treeBFS.tree rootChild2 = root.addChildNode(new Q_27_treeBFS.tree("3"));
        Q_27_treeBFS.tree leaf1 = rootChild1.addChildNode(new Q_27_treeBFS.tree("4"));
        Q_27_treeBFS.tree leaf2 = rootChild1.addChildNode(new Q_27_treeBFS.tree("5"));
        ArrayList<String> output = coplit.bfs(root);
        System.out.println(output); // --> ["1", "2", "3", "4", "5"]

        leaf1.addChildNode(new Q_27_treeBFS.tree("6"));
        rootChild2.addChildNode(new Q_27_treeBFS.tree("7"));
        output = coplit.bfs(root);
        System.out.println(output); // --> ["1", "2", "3", "4", "5", "7", "6"]
    }

    public ArrayList<String> bfs(tree node) {
        ArrayList<String> output = new ArrayList<>();
        Queue<tree> queue = new LinkedList<>();
        queue.add(node);

        while (queue.size() > 0) {
            tree child = queue.poll();
            output.add(child.getValue());

            if (child.getChildrenNode() != null) {
                // 선입선출이므로 하위 노드들은 상위 노드들이 다 빠져나가야 값을 집어넣을 수 있다
                queue.addAll(child.getChildrenNode());
            }
        }

        return output;
    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if (children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}

