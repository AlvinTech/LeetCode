package com.alvin.java; /** Clone Graph
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Clone_Graph {
    Map<Integer,UndirectedGraphNode> map  = new HashMap<Integer,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        UndirectedGraphNode newNode;
        if(!map.containsKey(node.label)){
            newNode = new UndirectedGraphNode(node.label);
            map.put(node.label,newNode );
        }else
            newNode = map.get(node.label);

        List<UndirectedGraphNode> newList = newNode.neighbors;
        List<UndirectedGraphNode> list = node.neighbors;
        for(int i =0;i< list.size();i++){
            if(map.containsKey(list.get(i).label)){
                newList.add(map.get(list.get(i).label));
            }
            else if(list.get(i).label != node.label )
                newList.add(cloneGraph(list.get(i)));
            else
                newList.add(newNode); //  list.get(i).label == node.label  connect itself;
        }
        return newNode;

    }
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
