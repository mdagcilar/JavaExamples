package com.development.metindagcilar.LRUCache;

import java.util.HashMap;
import java.util.Map;

/*
 * We need a double linked hashmap to be able to get and insert in O(1) time complexity.
 * but also, to be able to keep track of the most recently and least recently used.
 * To re-order the list, we remove a Node, look at the next and previous to connect them
 * then add it to the head of the list
 */

public class LRUCache {

    // Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // Dummy head and tail nodes to avoid edge cases during insertion/deletion
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        // Always add the new node right after the dummy head
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        // Remove an existing node from the linked list
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToHead(Node node) {
        // Move an accessed or updated node to the most recently used position
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        // Pop the least recently used item (right before the dummy tail)
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1; // Key not found
        }

        // Mark as recently used
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            // Key does not exist, create a new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);

            // Check capacity and evict if necessary
            if (cache.size() > capacity) {
                // Remove from linked list
                Node tail = popTail();
                // Remove from hash map
                cache.remove(tail.key);
            }
        } else {
            // Key exists, update the value
            node.value = value;
            // Mark as recently used
            moveToHead(node);
        }
    }
}