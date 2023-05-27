import java.util.ArrayList;

public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public TreeNode addChild(TreeNode node) {
        this.children.add(node);
        return node;
    }

    public String print(int level) {
        String ret;
        ret = "  ".repeat(level) + data + "\n";
        for (TreeNode node : this.children) {
            ret += node.print(level + 1);
        }
        return ret;
    }
}
