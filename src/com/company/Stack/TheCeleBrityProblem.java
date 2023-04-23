package com.company.Stack;

import java.util.Stack;

public class TheCeleBrityProblem {
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        Stack<Integer> st=new Stack<Integer>();

        //Push all the candidates into stack
        for(int i=0;i<n;i++){
            st.push(i);
        }

        //Until Stack size is 1 check if each two candidate in stack knows each other.
        //if one knows other pop that element and push other

        while(st.size()>1){
            int a=st.pop();
            int b=st.pop();
            if(M[a][b]==1)
            {
                st.push(b);
            }
            else{
                st.push(a);
            }
        }

        //verify if the candidate is celebrity
        int candidate=st.pop();

        int i=0;
        while(i<n){
            if(candidate!=i){
                //check row
                if(M[candidate][i]!=0)
                    break;
                if(M[i][candidate]!=1)
                    break;
            }
            i++;
        }

        return (i==n)?candidate:-1;
    }
}
