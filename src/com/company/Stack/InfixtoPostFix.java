package com.company.Stack;

import java.util.Stack;

public class InfixtoPostFix {

    public int prec(char ch){
        switch (ch){
            case '^':
                return 5;
            case '*':
                return 4;
            case '/':
                return 3;
            case '+':
                return 2;
            case '-':
                 return 1;
            default:
                return 0;

        }
    }
    public String solve(String s){
        String output="";
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch))
                output+=ch;
            else if(ch=='(')
                st.push(ch);
            else if(ch==')'){
                while(!st.empty() && st.peek()!='(') {
                    output += st.peek();
                    st.pop();
                }
                st.pop();
            }
            else{
                if(st.empty() || (!st.empty() && prec(ch)>prec(st.peek())))
                    st.push(ch);
                else{
                    while(!st.empty() && st.peek()!='(')
                    {
                        output+=st.peek();
                        st.pop();
                    }
                    st.push(ch);
                }
            }
        }

        while(!st.empty())
            output+=st.pop();
        return output;
    }
    public static void main(String[] args){
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        InfixtoPostFix ob=new InfixtoPostFix();
        // Function call
        System.out.println(ob.solve(exp));
    }
}
