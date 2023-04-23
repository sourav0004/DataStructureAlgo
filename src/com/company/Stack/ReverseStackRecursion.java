package com.company.Stack;

import java.util.Stack;

public class ReverseStackRecursion {
    public static Stack<Integer> st=new Stack<>();

    public static void insertButtom(int x){
        if(st.empty())
        {
            st.push(x);
            return;
        }
        int a=st.pop();
        insertButtom(x);
        st.push(a);
    }

    public static void reverse(){
        if(st.empty())
        {
            return;
        }

        int a=st.pop();
        reverse();
        insertButtom(a);
    }

    public static void main(String[] args){

        InsertButtom ob=new InsertButtom();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        reverse();
        while(!st.empty()){
            System.out.println(st.pop());
        }
    }
}
