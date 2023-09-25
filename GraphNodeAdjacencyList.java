import java.util.ArrayList;

public class GraphNodeAdjacencyList {
    public String name;
    public int index;
    public ArrayList<GraphNodeAdjacencyList> neighbours = new ArrayList<GraphNodeAdjacencyList>();

    public GraphNodeAdjacencyList(
            String name,
            int index) {
        this.name = name;
        this.index = index;
    }
}
