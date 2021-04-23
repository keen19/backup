package suanfa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSearch {
    public void searchTraversing(GraphNode node){
        List<GraphNode> visited=new ArrayList<>();
        Queue<GraphNode> q=new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()){
            GraphNode currNode=q.poll();
            if (!visited.contains(currNode)){
                visited.add(currNode);
                System.out.println("节点："+currNode.getLabel());
                for (int i = 0; i < currNode.edgeList.size(); i++) {
                    q.offer(currNode.edgeList.get(i).getNodeRight());
                }
            }
        }
    }
}
