package suanfa;

public class GraphEdge {
    private GraphNode nodeleft;
    private GraphNode noderight;

    public GraphEdge(GraphNode nodeleft,GraphNode noderight){
        this.nodeleft=nodeleft;
        this.noderight=noderight;
    }
    public GraphNode getNodeLeft(){
        return  nodeleft;
    }
    public GraphNode getNodeRight(){
        return noderight;
    }
}
