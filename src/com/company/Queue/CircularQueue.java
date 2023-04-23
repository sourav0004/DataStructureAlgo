package com.company.Queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CircularQueue {

    public int front;
    public int rear;
    public int[] cQueue;
    public int size;
    CircularQueue(int size){
         this.size=size;
         this.front=this.rear=-1;
         this.cQueue=new int[size];
    }

    public void enQueue(int item){

        if(front==-1 && rear==-1)
        {

            front++;
            rear++;
            cQueue[rear]=item;
        }
        else{
            if(rear<size-1 && rear+1!=front)
            {
                rear++;
                cQueue[rear]=item;
            }
            else if(rear==size-1 && front!=0){
                rear=0;
                cQueue[rear]=item;
            }
            else{
                System.out.println("Queue Full");
            }
        }

    }

    public int deQueue(){

        if((front==-1))
        {
            System.out.println("Queue Empty");
            return -1;
        }

        else
        {
            int temp= cQueue[front];
            if(front==rear)
                front=rear=-1;
            else if(front<size-1)
                front++;
            else if(front==size-1)
                front=0;
            return temp;
        }

    }

    public void displayQueue(){

        if(front==-1)
            System.out.println("Queue Empty");

        if(front<=rear)
        {
            for (int i=front;i<=rear;i++){
                System.out.print(cQueue[i]+" ");
            }
        }
        else{
            for(int i=front;i<size;i++){
                System.out.print(cQueue[i]+" ");
            }
            front=0;
            for(int i=front;i<=rear;i++){
                System.out.print(cQueue[i]+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        // Initialising new object of
        // CircularQueue class.
        CircularQueue q = new CircularQueue(5);
        HashMap<Integer,Integer> map=new HashMap<>();

        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(13);
        q.enQueue(-6);
        q.enQueue(2);
        q.displayQueue();

        int x = q.deQueue();

        // Checking for empty queue.
        if(x != -1)
        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        x = q.deQueue();

        // Checking for empty queue.
        if(x != -1)
        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        q.displayQueue();

        q.enQueue(9);
        q.enQueue(20);
        q.enQueue(5);

        q.displayQueue();

        q.enQueue(20);
    }
}
