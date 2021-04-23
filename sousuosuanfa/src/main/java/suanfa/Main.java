package suanfa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static MyGraph graph=null;

    private static void initGraph(){
        if (graph==null){
            graph=new MyGraph();
        }
        graph.initGraph();
    }

    public static void main(String[] args) {
        initGraph();
        List<GraphNode> visited=new ArrayList<>();

        System.out.println("深度优先");
        DFSearch dfs=new DFSearch();
        dfs.searchTraversing(graph.getGraphNodes().get(0),visited);

        System.out.println("广度优先");
        BFSearch bfs=new BFSearch();
        bfs.searchTraversing(graph.getGraphNodes().get(0));
    }
}
