public class GraphNode {
    public String name;
    public int index;
    public int visitedType;
    public String type;

    public GraphNode(String name, int index, String type) {
        this.name = name;
        this.index = index;
        this.type = type; // M, *, ., X
    }
}
