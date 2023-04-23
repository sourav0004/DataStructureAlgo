package com.company.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class interLeaveQueue {
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> qtemp = new LinkedList<>();
        int size=q.size();
        for(int i=0;i<size/2;i++){
            qtemp.add(q.remove());

        }

        while(!qtemp.isEmpty()){
            q.add(qtemp.remove());
            q.add(q.remove());
        }

    }

    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        interLeave(q);
        int length = q.size();
        for (int i = 0; i < length; i++) {
            System.out.print(q.peek() + " ");
            q.poll();
        }
    }
}
