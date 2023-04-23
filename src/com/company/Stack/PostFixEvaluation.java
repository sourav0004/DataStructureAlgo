package com.company.Stack;

import java.util.Stack;

public class PostFixEvaluation {
        public static int eval(int a,int b,char ch){

            switch (ch){
                case '^':
                    return (int)Math.pow(a,b);
                case '*':
                    return a*b;
                case '/':
                    return b/a;
                case '+':
                    return a+b;
                case '-':
                    return b-a;
                default:
                    return 0;

            }
        }
        //Function to evaluate a postfix expression.
        public static int evaluatePostFix(String S)
        {
            // Your code here
            Stack<Integer> st=new Stack<>();
            //int output=0;
            for(int i=0;i<S.length();i++)
            {
                char ch=S.charAt(i);
                if(Character.isDigit(ch))
                {
                    st.push(ch-'0');
                }
                else{
                    int a=st.pop();
                    int b=st.pop();
                    int result=eval(a,b,ch);
                    st.push(result);
                }

            }
            return st.pop();
        }
    }

