import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public ArrayList<GraphNode> getNeighbours(GraphNode node) {
        ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();
        int[] adjacencyRow = adjacencyMatrix[node.index];
        for (int i = 0; i < adjacencyRow.length; i++) {
            if (adjacencyRow[i] == 1) {
                GraphNode selectedNode = nodeList.get(i);
                neighbours.add(selectedNode);
            }
        }
        return neighbours;
    }

    void bfsVisit(GraphNode node) {
        // create an empty queue.
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        // Add the node passed in to the queue (starting node)
        queue.add(node);
        System.out.printf("Visited node:\n");
        while (!queue.isEmpty()) {
            GraphNode p = queue.pop();
            if (!p.isVisited) {
                p.isVisited = true;
                System.out.println(p.name);
                // read adjacent nodes;
                ArrayList<GraphNode> neighbours = this.getNeighbours(p);
                for (GraphNode neighbour : neighbours) {
                    queue.add(neighbour);
                }
            }
        }
    }
}
