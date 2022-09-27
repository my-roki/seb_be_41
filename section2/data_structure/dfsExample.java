package section2.data_structure;

import java.util.LinkedList;

public class dfsExample {
    public static void main(String[] args) {
        dfsGraph g = new dfsGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DepthFirstSearch(2); // 주어진 노드를 시작 노드로 DFS 탐색
        g.DepthFirstSearch(); // 비연결형 그래프의 경우
    }
}

class dfsGraph {
    private final int V;   // 노드의 개수
    private final LinkedList<Integer>[] adj; // 인접 리스트

    dfsGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) // 인접 리스트 초기화
            adj[i] = new LinkedList();
    }

    // 노드를 연결 v -> w
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS에 의해 사용되는 함수
    public void DFSUtil(int v, boolean[] visited) {
        // 현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true;
        System.out.print(v + " ");

        // 방문한 노드와 인접한 모든 노드를 가져온다.
        for (int n : adj[v]) {
            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
            if (!visited[n])
                DFSUtil(n, visited); // 순환 호출
        }
    }

    // 주어진 노드를 시작 노드로 DFS 탐색
    public void DepthFirstSearch(int v) {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean[] visited = new boolean[V];

        // v를 시작 노드로 DFSUtil 순환 호출
        DFSUtil(v, visited);
    }

    // DFS 탐색
    public void DepthFirstSearch() {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean[] visited = new boolean[V];

        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
        for (int i = 0; i < V; ++i) {
            if (!visited[i])
                DFSUtil(i, visited);
        }
    }
}

