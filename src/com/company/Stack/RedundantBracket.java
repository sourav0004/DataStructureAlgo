package com.company.Stack;

import java.util.Stack;

public class RedundantBracket {

    public boolean getAnswer(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=')')
                st.push(ch);
            else{
                char top=st.pop();
                if(st.peek()=='(' || top=='(')
                    return true;
                else{
                    while(st.peek()!='(')
                        st.pop();
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        RedundantBracket ob=new RedundantBracket();
        System.out.println(ob.getAnswer("(a+b/c)"));
    }
}
