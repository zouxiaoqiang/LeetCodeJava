package com.zxqnb;

public class T117 {
    private Node last, nextStart;
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }
    private void handle(Node cur) {
        if (last != null) {
            last.next = cur;
        }
        if (nextStart == null) {
            nextStart = cur;
        }
        last = cur;
    }
}
