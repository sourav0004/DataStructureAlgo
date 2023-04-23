package com.company.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueue {
    public Queue<Integer> q1=new LinkedList<Integer>();
    public Queue<Integer> q2=new LinkedList<Integer>();
    int top;
    public void push(int a){
          q1.add(a);
          top++;
    }

    public int pop(){
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int temp=q1.remove();
        while(!q2.isEmpty())
            q1.add(q2.remove());
        top--;
        return temp;
    }

    public int top(){
        while(q1.size()>1)
            q2.add(q1.remove());
        int temp=q1.remove();
        while(!q2.isEmpty())
            q1.add(q2.remove());
        q1.add(temp);
        return temp;
    }

    public int size(){
        return top;
    }
    public static void main(String[] args){
        StackUsingQueue s = new StackUsingQueue();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }
}
