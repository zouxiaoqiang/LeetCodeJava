package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T133 {
     class Node {
        int val;
        List<Node> neighbors;

        Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private final int N = 101;
    private final Node[] newNodes = new Node[N];

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        dfs(node);
        return newNodes[node.val];
    }

    private void dfs(Node node) {
        if (newNodes[node.val] == null) {
            newNodes[node.val] = new Node(node.val);
        }
        for (Node t : node.neighbors) {
            if (newNodes[t.val] == null) {
                dfs(t);
            }
            newNodes[node.val].neighbors.add(newNodes[t.val]);
        }
    }
}
