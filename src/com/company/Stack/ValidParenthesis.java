package com.company.Stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> par=new Stack<Character>();
        boolean flag=false;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if(ch=='(' || ch=='{' || ch=='['|| par.empty())
                par.push(ch);
            else{
                switch(ch){
                    case ')':
                        if(par.peek()=='(')
                        {
                            par.pop();
                        }
                        else{
                            par.push(ch);
                        }
                        break;
                    case '}':
                        if(par.peek()=='{')
                        {
                            par.pop();
                        }
                        else{
                            par.push(ch);
                        }
                        break;
                    case ']':
                        if(par.peek()=='[')
                        {
                            par.pop();
                        }
                        else{
                            par.push(ch);
                        }
                        break;
                }
            }

        }

        return par.empty();

    }
}
