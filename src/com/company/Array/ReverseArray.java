package com.company.Array;

public class ReverseArray {
    public static String reverseWord(String str)
    {
        // Reverse the string str
        StringBuilder result=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){

            result.append(str.charAt(i));

        }

        return new String(result);
    }
}
