package com.company.Cache;

import java.util.HashMap;
class Node{
    public Node prev;
    int key;
    int value;
    public Node next;
    public Node(int k,int v){
        this.key=k;
        this.value=v;
    }
}

class LRUCache
{
    public static HashMap<Integer,Node> map;
    public static int size;
    public static Node head,tail;
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        this.map=new HashMap<>();
        this.size=cap;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
    }

    public static void deleteNode(Node node){

        node.prev.next=node.next;
        node.next.prev=node.prev;

    }

    public static void pushHead(Node node){
        node.next=head.next;
        node.next.prev=node;
        node.prev=head;
        head.next=node;

    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        // your code here

        if(map.get(key)!=null){

            Node temp=map.get(key);
            int val=temp.value;
            deleteNode(temp);
            pushHead(temp);
            return val;

        }

        return -1;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if(map.get(key)!=null){
            Node temp=map.get(key);
            temp.value=value;
            deleteNode(temp);
            pushHead(temp);
        }
        else{

            if(size==0){
                Node temp=map.get(tail.prev.key);
                map.remove(temp.key);
                deleteNode(temp);
            }
            else{
                size--;
            }

            Node newNode=new Node(key,value);
            map.put(key,newNode);
            pushHead(newNode);
        }
    }
}
