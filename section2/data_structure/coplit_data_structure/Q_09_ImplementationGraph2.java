package section2.data_structure.coplit_data_structure;

/*
Implementation Graph
Graph 구현을 위한 기본적인 코드가 작성되어 있습니다. Graph 자료구조의 특성을 이해하고 FILL_ME_IN 을 채워 테스트를 통과해 주세요.

멤버 변수
버텍스와 간선을 담을 수 있는 ArrayList<ArrayList<Integer>> 타입의 graph

메서드
setGraph(size): 그래프에 size 만큼의 버텍스를 추가해야 합니다.
addEdge(fromVertex, toVertex): fromVertex와 toVertex 사이의 간선을 추가합니다.
hasEdge(fromvertex, toVertex): fromVertex와 toVertex 사이의 간선이 존재하는지 여부를 Boolean으로 반환해야 합니다,
removeEdge(fromVertex, toVertex): fromVertex와 toVertex 사이의 간선을 삭제해야 합니다.

주의사항
인접 리스트 방식으로 구현해야 합니다.
구현해야 하는 그래프는 무방향 그래프입니다.

사용 예시
Solution adjList = new Solution();
adjList.setGraph(3);

adjList.addEdge(0, 1);
adjList.hasEdge(0, 1); //true

adjList.removeEdge(0, 1);
adjList.hasEdge(0, 1); //false
...
 */

import java.util.ArrayList;

class graphSolution2 {
    private ArrayList<ArrayList<Integer>> graph;

    public graphSolution2() {
        graph = new ArrayList<>();
    }

    // TODO: 정점을 추가합니다.
    // 넘겨받은 size만큼 빈 ArrayList를 값으로 할당합니다.
    public void setGraph(int size){
        for(int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    //그래프를 반환합니다.
    public ArrayList<ArrayList<Integer>> getGraph() {
        return graph;
    }

    // TODO: 간선을 추가합니다.
    public void addEdge(int from, Integer to) {
        //from, to가 그래프의 크기보다 작거나, 음수일 경우 아무것도 추가하지 않습니다.
        if(from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return;
        //from, to가 정확하게 입력되었을 경우
        // - from의 인접 리스트에 to를 추가하고
        // - to의 인접 리스트에 from를 추가합니다.
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    public boolean hasEdge(int from, int to) {
        //from, to가 그래프의 크기보다 작거나, 음수일 경우 아무것도 추가하지 않습니다.
        if(from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return false;
            //ArrayList에서 제공하는 contains를 사용하여 boolean 타입의 값을 반환합니다.
        else return graph.get(from).contains(to);
    }

    public void removeEdge(int from, int to) {
        //from, to가 그래프의 크기보다 작거나, 음수일 경우 아무것도 제거하지 않습니다.
        if(from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return;
        //from의 인접 리스트가 to로 이어지는 간선이 존재하는 경우
        if(graph.get(from).contains(to)) {
            //from의 인접 리스트에서 to를 삭제합니다.
            graph.get(from).remove((Integer) to);
        }

        //to의 인접 리스트가 from으로 이어지는 간선이 존재하는 경우
        if(graph.get(to).contains(from)) {
            //to의 인접 리스트에서 from을 삭제합니다.
            graph.get(to).remove((Integer) from);
        }
    }
}

public class Q_09_ImplementationGraph2 {
    public static void main(String[] args) {
        // write test case here
        graphSolution2 adjList = new graphSolution2();
        adjList.setGraph(3);

        adjList.addEdge(0, 1);
        System.out.println(adjList.hasEdge(0, 1)); //true

        adjList.removeEdge(0, 1);
        System.out.println(adjList.hasEdge(0, 1)); //false

    }

}
