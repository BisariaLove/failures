package dataStructure;
/*
 * @author love.bisaria on 22/08/18
 */


import java.util.*;

class GraphNode{

    //created a wrapper class around the integer keeping in mind that the
    //graph node can hold more data based on the application
    Integer id;

    public GraphNode(Integer id){
        this.id = id;
    }

}

public class Graph {

    private Map<GraphNode, List<GraphNode>> adjacencyMap = new HashMap();
    private Map<Integer, GraphNode> nodeLookup = new HashMap();

    public void addEdge(Integer a, Integer b){

        GraphNode nodeA = getNode(a);
        GraphNode nodeB = getNode(b);


        adjacencyMap.get(nodeA).add(nodeB);
        adjacencyMap.get(nodeB).add(nodeA);
    }

    /*
    * gets a GraphNode object for given id
    * if the id is not present in the lookup map
    * the function creates a new GraphNode and
    * adds it to the lookup
    * Also initializes the adjacency Map for the newly created node
    * */
    public GraphNode getNode(Integer id){
        GraphNode node = nodeLookup.get(id);

        if(node == null){
            node = new GraphNode(id);
            nodeLookup.put(id, node);
            adjacencyMap.put(node, new ArrayList<GraphNode>());
        }

        return node;
    }

    public Graph(){

    }

    public boolean hasPathDFS(Integer source, Integer destination){
        return hasPathDFS(getNode(source), getNode(destination), new HashSet());
    }

    public boolean hasPathDFS(GraphNode source, GraphNode destination, HashSet<GraphNode> visited){

        Stack<GraphNode> stack  =  new Stack();
        stack.push(source);

        while(!stack.isEmpty()){

            GraphNode node = stack.pop();

            if(node == destination){
                return true;
            }

            List<GraphNode> adjacentNodes = adjacencyMap.get(node);

            for(GraphNode adjacentNode : adjacentNodes){
                if(!visited.contains(adjacentNode)){
                    stack.push(adjacentNode);
                }
            }

            visited.add(node);
        }

        return false;
    }

    public boolean hasPathBFS(Integer source, Integer destination){
        return hasPathBFS(getNode(source), getNode(destination), new HashSet());
    }

    public boolean hasPathBFS(GraphNode source, GraphNode destination, HashSet<GraphNode> visited){
        LinkedList<GraphNode> queue = new LinkedList();

        queue.add(source);

        while(!queue.isEmpty()){
            GraphNode node =  queue.removeFirst();
            if(node == destination){
                return true;
            }

            List<GraphNode> adjacentNodes = adjacencyMap.get(node);

            for(GraphNode adjacentNode : adjacentNodes){
                if(!visited.contains(adjacentNode)){
                    queue.add(adjacentNode);
                }
            }

            visited.add(node);
        }

        return false;
    }


    public static void main(String[] args){
        Graph graph = new Graph();

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        graph.addEdge(3,5);
        graph.addEdge(2, 5);
        graph.addEdge(5,1);

        System.out.println(graph.hasPathDFS(5, 1));
        System.out.println(graph.hasPathBFS(5, 1));
    }
}
