package suanfa;

import java.util.List;

public class DFSearch {
    public void searchTraversing(GraphNode node, List<GraphNode> visited){
        if (visited.contains(node)){
            return;
        }
        visited.add(node);
        System.out.println("节点："+node.getLabel());
        for (int i = 0; i < node.edgeList.size(); i++) {
            searchTraversing(node.edgeList.get(i).getNodeRight(),visited);
        }
    }
}
