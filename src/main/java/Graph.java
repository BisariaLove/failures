import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Graph {

    HashMap<Integer, GraphNode>  nodeMap = new HashMap();

    public GraphNode getNode(int data){
        return nodeMap.get(data);
    }

    public void addEdge(Integer d1, Integer d2){

        GraphNode n1 = new GraphNode(d1);
        GraphNode n2 = new GraphNode(d2);

        nodeMap.put(d1, n1);
        nodeMap.put(d2, n2);

        n1.adjascent.add(n2);
        n2.adjascent.add(n1);
    }

    /*public boolean hasPathBFS(int source, int destination){
        HashSet<GraphNode> visited = new HashSet<GraphNode>();
        return hasPathBFS(getNode(source), getNode(destination), visited);
    }
    private boolean hasPathBFS(GraphNode source, GraphNode destination, HashSet<GraphNode> visited){

        if(source.equals(destination)){
            return true;
        }


    }*/

    public boolean hasPathDFS(int source, int destinatio){
        HashSet<GraphNode> visited = new HashSet<GraphNode>();
        return hasPathDFS(getNode(source), getNode(destinatio), visited);
    }

    private boolean hasPathDFS(GraphNode source, GraphNode destination, HashSet<GraphNode> visited){
        
        if(source.equals(destination)){
            return true;
        }
        
        if(visited.contains(source)){
            return false;
        }
        
        visited.add(source);
        
        for(GraphNode child : source.adjascent){
            hasPathDFS(child, destination, visited);
        }
        
        return false;
    }

    public void printGraph(){

    }

    public static void main(String[] args){

        Graph g = new Graph();
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
    }
}

class GraphNode{

    int data;
    List<GraphNode> adjascent;

    public GraphNode(int data){
        this.data = data;
        adjascent = new ArrayList();
    }
}
