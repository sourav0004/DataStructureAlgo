package com.company.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long[] result=new long[n];
        Stack stack=new Stack();
        int i=0;
        for(i=n-1;i>=0;i--){

            if(stack.empty())
                result[i]=-1;
            else if(!stack.empty() && (long)stack.peek()>arr[i])
                result[i]=(long)stack.peek();
            else if(!stack.empty() && (long)stack.peek()<arr[i])
            {
                while(!stack.empty() && (long)stack.peek()<arr[i])
                    stack.pop();

                if(stack.empty())
                    result[i]=1;
                else
                    result[i]=(long)stack.peek();
            }

            stack.push(result[i]);
        }

        return result;

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
            long[] res = new NextGreaterElement().nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }

}
