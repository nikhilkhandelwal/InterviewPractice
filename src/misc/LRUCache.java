package misc;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import java.util.*;

/**
 * Created by nikhandelwal on 12/15/2015.
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    void addNode(DLinkedNode node){

        node.pre=head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;

    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }


    DLinkedNode popTail(){

        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;

    }
    int capacity;

    Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    DLinkedNode tail;
    DLinkedNode head;

    int count;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if(node == null)
            return -1;

        else {
            moveToHead(node);
            return node.value;
        }

    }

    public void set(int key, int value) {

        DLinkedNode node = cache.get(key);

        if(node ==null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            if(capacity == count) {
                DLinkedNode tail = popTail();
                addNode(newNode);
                cache.remove(node.key);

            }
            else {
                count++;
            }
        }
        else
        {
            node.value = value;
            moveToHead(node);
        }
    }

    


}
