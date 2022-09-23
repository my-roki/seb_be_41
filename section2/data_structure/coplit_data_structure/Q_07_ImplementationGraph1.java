package section2.data_structure.coplit_data_structure;

/*
Implementation Graph
Graph 구현을 위한 기본적인 코드가 작성되어 있습니다. Graph 자료구조의 특성을 이해하고 FILL_ME_IN 을 채워 테스트를 통과해 주세요.

멤버 변수
버텍스와 간선을 담을 Array 타입의 graph

메서드
setGraph(size): 그래프에 size만큼의 버텍스를 추가해야 합니다.
getGraph(): 인접 행렬 정보가 담긴 배열을 반환합니다.
addEdge(from, to): fromVertex와 toVertex 사이의 간선을 추가합니다.
hasEdge(from, to): fromVertex와 toVertex 사이의 간선이 존재하는지 여부를 Boolean으로 반환해야 합니다.
removeEdge(from, to): fromVertex와 toVertex 사이의 간선을 삭제해야 합니다.

주의사항
인접 행렬 방식으로 구현해야 합니다.
구현해야 하는 그래프는 방향 그래프입니다.
구현해야 하는 그래프는 비가중치 그래프입니다.
구현해야 하는 그래프는 이해를 돕기 위해 기존 배열의 인덱스를 정점으로 사용합니다. (0, 1, 2, ... --> 정점)
인접 행렬 그래프는 정점이 자주 삭제되는 경우에는 적합하지 않기 때문에 정점을 지우는 메소드는 생략합니다.

사용 예시
Solution adjMatrix = new Solution();
adjMatrix.addVertex(3);
System.out.println(Arrays.deepToString(adjMatrix.getGraph()));

//			    TO
//		 	 0  1  2
//		  0	[0, 0, 0],
//	FROM  1	[0, 0, 0],
//		  2	[0, 0, 0]

adjMatrix.addEdge(0, 1);
adjMatrix.addEdge(0, 2);
adjMatrix.addEdge(1, 2);

boolean zeroToOneEdgeExists = adjMatrix.hasEdge(0, 1);
System.out.println(zeroToOneEdgeExists); // true

zeroToTwoEdgeExists = adjMatrix.hasEdge(0, 2);
System.out.println(zeroToTwoEdgeExists); // true

boolean oneToZeroEdgeExists = adjMatrix.hasEdge(1, 0);
System.out.println(oneToZeroEdgeExists); // false

System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
//             TO
//          0  1  2
//       0 [0, 1, 1],
// FROM  1 [0, 0, 1],
//       2 [0, 0, 0]

adjMatrix.removeEdge(1, 2);
adjMatrix.removeEdge(0, 2);

boolean oneToTwoEdgeExists = adjMatrix.hasEdge(1, 2);
System.out.println.log(oneToTwoEdgeExists); // false

boolean zeroToTwoEdgeExists = adjMatrix.hasEdge(0, 2);
System.out.println.log(zeroToTwoEdgeExists); // false

System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
//             TO
//          0  1  2
//       0 [0, 1, 0],
// FROM  1 [0, 0, 0],
//       2 [0, 0, 0]
 */

import java.util.Arrays;

class graphSolution1 {
    private int[][] graph;

    public void setGraph(int size) {
        graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph[i][j] = 0;
            }
        }

    }

    public int[][] getGraph() {
        return graph;
    }

    public void addEdge(int from, int to) {
        if (from >= graph.length || to >= graph.length) return;
        graph[from][to] = 1;
    }

    public boolean hasEdge(int from, int to) {
        if (from >= graph.length || to >= graph.length) return false;
        else if (graph[from][to] == 1) return true;
        else return false;
    }

    public void removeEdge(int from, int to) {
        if (from >= graph.length || to >= graph.length) return;
        graph[from][to] = 0;
    }
}


public class Q_07_ImplementationGraph1 {
    public static void main(String[] args) {
        // write test case here
        graphSolution1 adjMatrix = new graphSolution1();
        adjMatrix.setGraph(3);
        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));

//			    TO
//		 	 0  1  2
//		  0	[0, 0, 0],
//	FROM  1	[0, 0, 0],
//		  2	[0, 0, 0]

        adjMatrix.addEdge(0, 1);
        adjMatrix.addEdge(0, 2);
        adjMatrix.addEdge(1, 2);

        boolean zeroToOneEdgeExists = adjMatrix.hasEdge(0, 1);
        System.out.println(zeroToOneEdgeExists); // true

        boolean zeroToTwoEdgeExists = adjMatrix.hasEdge(0, 2);
        System.out.println(zeroToTwoEdgeExists); // true

        boolean oneToZeroEdgeExists = adjMatrix.hasEdge(1, 0);
        System.out.println(oneToZeroEdgeExists); // false

        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
//             TO
//          0  1  2
//       0 [0, 1, 1],
// FROM  1 [0, 0, 1],
//       2 [0, 0, 0]

        adjMatrix.removeEdge(1, 2);
        adjMatrix.removeEdge(0, 2);

        boolean oneToTwoEdgeExists = adjMatrix.hasEdge(1, 2);
        System.out.println(oneToTwoEdgeExists); // false

        zeroToTwoEdgeExists = adjMatrix.hasEdge(0, 2);
        System.out.println(zeroToTwoEdgeExists); // false

        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
//             TO
//          0  1  2
//       0 [0, 1, 0],
// FROM  1 [0, 0, 0],
//       2 [0, 0, 0]

    }

}
