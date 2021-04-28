package com.zxqnb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 新旧结点的hashmap
     */
    private Map<Node, Node> visitedMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (visitedMap.containsKey(head)) {
            return visitedMap.get(head);
        }
        Node node = new Node(head.val);
        visitedMap.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.next);
        return node;
    }

    private Node getCloneNode(Node oldNode) {
        if (oldNode == null) {
            return null;
        }
        if (visitedMap.containsKey(oldNode)) {
            return visitedMap.get(oldNode);
        } else {
            Node newNode = new Node(oldNode.val);
            visitedMap.put(oldNode, newNode);
            return newNode;
        }
    }

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        visitedMap.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = getCloneNode(oldNode.next);
            newNode.random = getCloneNode(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return newNode;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = (cur.random != null) ? cur.random.next : null;
            cur = cur.next.next;
        }
        Node curOld = head, curNew = head.next, newHead = head.next;
        while (curOld != null) {
            curOld.next = curOld.next.next;
            curNew.next = (curNew.next != null) ? curNew.next.next : null;
            curOld = curOld.next;
            curNew = curNew.next;
        }
        return newHead;
    }

}
