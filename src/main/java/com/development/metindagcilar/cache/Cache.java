package com.development.metindagcilar.cache;

import java.util.HashMap;

public class Cache {

    private int maxCacheSize;
    private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
    private LinkedListNode listHead = null;

    public LinkedListNode listTail = null;

    public Cache(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    public String getValue(int key) {
        LinkedListNode item = map.get(key);
        if (item == null) return null;

        if (item != listHead) {
            removeFromLinkedList(item);
            insertAtFrontOfLinkedList(item);
        }
        return item.value;
    }

    private void removeFromLinkedList(LinkedListNode node) {
        if (node == null) return;

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        if (node == listTail) listTail = node.prev;
        if (node == listHead) listHead = node.next;
    }

    private void insertAtFrontOfLinkedList(LinkedListNode node) {
        if (listHead == null) {
            listHead = node;
            listTail = node;
        } else {
            listHead.prev = node;
            node.next = listHead;
            listHead = node;
        }
    }

    public boolean removeKey(int key) {
        LinkedListNode node = map.get(key);
        removeFromLinkedList(node);
        map.remove(key);
        return true;
    }

    public void setKeyValue(int key, String value) {
        removeKey(key);

        if (map.size() >= maxCacheSize && listTail != null) {
            removeKey(listTail.key);
        }

        LinkedListNode node = new LinkedListNode(key, value);
        insertAtFrontOfLinkedList(node);
        map.put(key, node);
    }
}
