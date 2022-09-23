package section2.data_structure.coplit_data_structure;

/*
Implementation Binary Search Tree
Tree 구현을 위한 기본적인 코드가 작성되어 있습니다.
Binary Search Tree 자료구조의 특성을 이해하고 FILL_ME_IN 을 채워 테스트를 통과해주세요.

멤버 변수
노드 클래스
- 입력 데이터를 담을 수 있는 data
- 노드를 왼쪽에 저장할 수 있는 Node 타입의 left
- 노드를 오른쪽에 저장할 수 있는 Node 타입의 right
이진 탐색 트리 클래스
- 트리구조를 이루는 Node타입의 root

메서드
insert(value): 입력받은 value를 Binary Search에 맞게 Tree에 계층적으로 추가할 수 있어야 합니다.
contains(value): 트리에 포함된 데이터를 찾을 수 있어야 합니다.
preorder(root, depth, list): 전위 순회를 통해 트리의 모든 요소를 정렬하여 ArrayList 타입으로 반환합니다.
inorder(root, depth, list): 중위 순회를 통해 트리의 모든 요소를 정렬하여 ArrayList 타입으로 반환합니다.
postorder(root, depth, list): 후위 순회를 통해 트리의 모든 요소를 정렬하여 ArrayList 타입으로 반환합니다.

주의사항
value는 어떠한 값도 들어갈 수 있지만 현재 구현하는 Tree는 숫자로 제한합니다.

사용 예시
Solution.binarySearchTree tree = new Solution.binarySearchTree();
tree.root = new Solution.Node(10);
tree.insert(7);
tree.insert(8);
tree.insert(12);
tree.insert(11);
tree.root.getLeft().getRight().getData(); // 8
tree.root.getRight().getLeft().getData(); // 11

ArrayList<Integer> tree = test.preorderTree(test.root, 0, new ArrayList<Integer>());
System.out.println(tree.toString()); // [10, 7, 8, 12, 11]
 */

import java.util.ArrayList;

public class Q_08_ImplementationBinarySearchTree {
    public static void main(String[] args) {
        // write test case here
        bstSolution.binarySearchTree tree = new bstSolution.binarySearchTree();
        tree.root = new bstSolution.Node(10);
        tree.insert(7);
        tree.insert(8);
        tree.insert(12);
        tree.insert(11);
        System.out.println(tree.root.getLeft().getRight().getData()); // 8
        System.out.println(tree.root.getRight().getLeft().getData()); // 11

        ArrayList<Integer> ouptut = tree.preorderTree(tree.root, 0, new ArrayList<Integer>());
        System.out.println(ouptut.toString()); // [10, 7, 8, 12, 11]

    }

}

class bstSolution {
    // 트리를 구성하는 노드 클래스입니다.
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        /* 생성자 */
        public Node(int data) {
            this.setData(data);
            this.setLeft(null);
            this.setRight(null);
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    //이진 탐색 트리의 클래스입니다.
    public static class binarySearchTree {
        public Node root;

        public binarySearchTree() {
            root = null;
        }

        // tree에 value를 추가합니다.
        public void insert(int data) {
            Node newNode = new Node(data); // 왼쪽, 오른쪽 자식 노드가 null 이며 data 의 값이 저장된 새 노드 생성
            if (root == null) {// 루트 노드가 없을때, 즉 트리가 비어있는 상태일 때,
                root = newNode;
                return;
            }
            if (root.data == data) return;   //중복일때 정지

            Node currentNode = root;
            Node parentNode = null;

            while (true) {
                parentNode = currentNode;

                if (data < currentNode.getData()) { // 해당 노드보다 작을 경우
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(newNode);
                        return;
                    } else if (currentNode.data == newNode.data) return;
                } else { // 해당 노드보다 클 경우
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    } else if (currentNode.data == newNode.data) return;
                }
            }
        }

        // tree의 value값을 탐색합니다.
        public boolean contains(int data) {
            Node currentNode = root;
            while (currentNode != null) {
                // 찾는 value값이 노드의 value와 일치한다면, true를 리턴합니다.
                if (currentNode.data == data) {
                    return true;
                }

                if (currentNode.data > data) {
                    // 찾는 value값이 노드의 value 보다 작다면, 현재 노드를 left로 변경후 다시 반복합니다.
                    currentNode = currentNode.left;
                } else {
                    // 찾는 value값이 노드의 value 보다 크다면, 현재 노드를 right로 변경후 다시 반복합니다.
                    currentNode = currentNode.right;
                }
            }
            return false;
        }

  /*
	트리의 순회에 대해 구현을 합니다.
  지금 만드려고 하는 이 순회 메서드는 단지 순회만 하는 것이 아닌, 함수를 매개변수로 받아 콜백 함수에 값을 적용시킨 것을 순회해야 합니다.
  전위 순회를 통해 어떻게 탐색하는지 이해를 한다면 중위와 후위 순회는 쉽게 다가올 것입니다.
	*/

        // 이진 탐색 트리를 전위 순회하는 메서드를 만듭니다.
        public ArrayList<Integer> preorderTree(Node root, int depth, ArrayList<Integer> list) {    //전위 순회
            if (root != null) {
                list.add(root.getData());
                preorderTree(root.getLeft(), depth + 1, list);
                preorderTree(root.getRight(), depth + 1, list);
            }
            return list;
        }

        public ArrayList<Integer> inorderTree(Node root, int depth, ArrayList<Integer> list) { //중위 순회
            if (root != null) {
                inorderTree(root.getLeft(), depth + 1, list);
                list.add(root.getData());
                inorderTree(root.getRight(), depth + 1, list);
            }
            return list;
        }

        public ArrayList<Integer> postorderTree(Node root, int depth, ArrayList<Integer> list) {   //후위 순회
            if (root != null) {
                postorderTree(root.getLeft(), depth + 1, list);
                postorderTree(root.getRight(), depth + 1, list);
                list.add(root.getData());
            }
            return list;
        }
    }
}