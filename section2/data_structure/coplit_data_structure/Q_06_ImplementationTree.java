package section2.data_structure.coplit_data_structure;

/*

 */

import java.util.ArrayList;

class treeSolution {
    private String value;
    private ArrayList<treeSolution> children;

    public treeSolution() {    //전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }

    public treeSolution(String data) {    //전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data;
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return value;
    }

    public void addChildNode(treeSolution node) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(node);
    }

    public void removeChildNode(treeSolution node) {
        String data = node.getValue();

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                if (children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    public ArrayList<treeSolution> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if (value.equals(data)) return true;

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                return children.get(i).contains(data);
            }
        }
        return false;
    }
}


public class Q_06_ImplementationTree {
    public static void main(String[] args) {
        // write test case here
        treeSolution rootNode = new treeSolution("hello");

        for (int i = 0; i <= 4; i++) {
            rootNode.addChildNode(new treeSolution(Integer.toString(i)));
        }
        System.out.println(rootNode); // {value: null, children: Solution(5)}
        System.out.println(rootNode.contains(String.valueOf(5))); // false
        System.out.println(rootNode.contains(String.valueOf(1))); // true

    }

}
