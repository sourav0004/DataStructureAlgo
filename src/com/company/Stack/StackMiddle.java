package com.company.Stack;

import com.company.Entities.DoubleLinkList;

/*
Design a stack with operations on middle element

Difficulty Level : Medium
How to implement a stack which will support the following operations in O(1) time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element.
Push and pop are standard stack operations.
 */
public class StackMiddle {
    public DoubleLinkList middle;
    public DoubleLinkList head;
    public int size;
    public void push(int data){
        DoubleLinkList new_node=new DoubleLinkList(data);
       if(size==0){
           head=new_node;
           middle=new_node;
       }

       else{
          head.next=new_node;
          new_node.prev=head;
          head=head.next;
          if(size%2!=0)
          {
              middle=middle.next;
          }

       }

       size++;

    }

    public int pop(){
        if(size==0){
            System.out.println("Empty Stack");
            return -1;
        }
        int data=head.data;
        if(size==1){
            head=null;
            middle=null;
        }
        else {
            head=head.prev;
            head.next = null;
        }
        size--;
        if(size%2==0)
            middle=middle.prev;
        return data;
    }
    public int findMiddle(){
        return middle.data;
    }
    public void deleteMiddle(){
          if(size!=0){
              if(size==1){
                  head=null;
                  middle=null;
              }
              else if(size==2){
                   head.prev=null;
                   middle=middle.next;
              }
              else{
                  middle.prev.next=middle.next;
                  middle.next.prev=middle.prev;
                  if(size%2==0)
                      middle=middle.prev;
                  else
                      middle=middle.next;
              }
              size--;
          }
    }


    public static void main(String[] args){
        StackMiddle ms = new StackMiddle();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);

        System.out.println("Popped : " + ms.pop());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Middle Element : "
                + ms.findMiddle());
        ms.deleteMiddle();
        System.out.println("New Middle Element : "
                + ms.findMiddle());
    }
}
