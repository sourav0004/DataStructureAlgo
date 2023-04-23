package com.company.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegative {
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] result=new long[(N-K)+1];
        int i=0;
        int j=0;
        Queue<Integer> qu=new LinkedList<>();
        while(j<N){
            if(A[j]<0){
                qu.add(j);
            }

            if(j-i+1<K)
                j++;
            else if(j-i+1==K)
            {
                if(qu.size()==0)
                    result[i]=0;

                else{
                    if(i>qu.peek() && qu.size()>0)
                        qu.remove();

                    if(qu.size()>0)
                        result[i]=A[qu.peek()];
                    else
                        result[i]=0;


                }
                i++;
                j++;
            }


        }
        return result;

    }
}
