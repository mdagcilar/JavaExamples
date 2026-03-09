package com.development.metindagcilar.LFUCache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        int freq;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;

        DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        Node popTail() {
            Node res = tail.prev;
            removeNode(res);
            return res;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private Map<Integer, DoublyLinkedList> freqMap = new HashMap<>();
    private int capacity;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
    }

    private void updateFrequency(Node node) {
        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);

        if (oldList.isEmpty()) {
            freqMap.remove(oldFreq);
            if (oldFreq == minFreq) {
                minFreq++;
            }
        }

        node.freq++;
        int newFreq = node.freq;

        DoublyLinkedList newList = freqMap.computeIfAbsent(newFreq, k -> new DoublyLinkedList());
        newList.addNode(node);
        freqMap.put(newFreq, newList);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        Node node = cache.get(key);

        if (node == null) {
            if (cache.size() >= capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node evictedNode = minFreqList.popTail();
                cache.remove(evictedNode.key);
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            DoublyLinkedList freq1List = freqMap.computeIfAbsent(1, k -> new DoublyLinkedList());
            freq1List.addNode(newNode);
            freqMap.put(1, freq1List);
            minFreq = 1;
        } else {
            node.value = value;
            updateFrequency(node);
        }
    }
}