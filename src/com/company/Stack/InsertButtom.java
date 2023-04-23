package com.company.Stack;

import java.util.Stack;
/*
1->2
*/

public class InsertButtom {
    public static Stack<Integer> st=new Stack<>();
    public void push(int x){
        if(st.empty())
        {
            st.push(x);
            return;
        }

        int a=st.pop();
        push(x);
        st.push(a);
    }

    public static void main(String[] args){

        InsertButtom ob=new InsertButtom();
        ob.push(1);
        ob.push(2);
        ob.push(3);
        ob.push(4);
        ob.push(5);
        while(!st.empty()){
            System.out.println(st.pop());
        }
    }
}
