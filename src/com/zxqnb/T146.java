package com.zxqnb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class T146 {
    class LRUCache {
        private class DLinkNode {
            int key;
            int val;
            DLinkNode prev, next;

            DLinkNode() {
            }

            DLinkNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private DLinkNode head, tail;
        private int size;
        private int capacity;
        private Map<Integer, DLinkNode> cache = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            head = new DLinkNode();
            tail = new DLinkNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            DLinkNode node = cache.get(key);
            if (node == null) {
                DLinkNode newNode = new DLinkNode(key, value);
                cache.put(key, newNode);
                add2Head(newNode);
                size++;
                if (size > capacity) {
                    DLinkNode tail = removeTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.val = value;
                moveNode(node);
            }
        }

        private void moveNode(DLinkNode node) {
            removeNode(node);
            add2Head(node);
        }

        private void removeNode(DLinkNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void add2Head(DLinkNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private DLinkNode removeTail() {
            DLinkNode node = tail.prev;
            removeNode(node);
            return node;
        }
    }
}
