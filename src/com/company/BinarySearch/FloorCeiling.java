package com.company.BinarySearch;

public class FloorCeiling {

    private static int findFloor(int[] arr,int x,int s,int e){
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]<=x){
                ans=arr[mid];
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }

        return ans;
    }

    private static int findCeil(int[] arr,int x,int s,int e){
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]>=x){
                ans=arr[mid];
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }

        return ans;
    }
    private static int[] getFloorAndCeil(int[] arr,int n,int x){
        int[] ans=new int[2];
        ans[0]=findCeil(arr,x,0,n-1);
        ans[1]=findFloor(arr,x,0,n-1);
        return ans;

    }
    public static void main(String[] args) {

        //https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;
        int[] ans = getFloorAndCeil(arr, n, x);
        System.out.println("The floor and ceil are: " + ans[0]
                + " " + ans[1]);
    }
}
