package com.company.Queue;

import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {

    class Oranges{
        public int i;
        public int j;
        public int timeUnit;
        public Oranges(int i,int j,int tu){
            this.i=i;
            this.j=j;
            this.timeUnit=tu;
        }
    }

    public int orangesRotting(int[][] grid) {
        int noOfFreshOranges=0;
        Queue<Oranges> que=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){

                    que.add(new Oranges(i,j,0));
                }
                if(grid[i][j]==1)
                    noOfFreshOranges++;
            }
        }

        int counter=0;

        while(que.size()>0){
            counter++;
            Oranges ob=que.remove();
            int i=ob.i;
            int j=ob.j;
            if(i+1<m && grid[i+1][j]==1)
            {
                grid[i+1][j]=2;
                que.add(new Oranges(i+1,j,ob.timeUnit+1));
                noOfFreshOranges--;
            }
            if(j+1<n && grid[i][j+1]==1)
            {
                grid[i][j+1]=2;
                que.add(new Oranges(i,j+1,ob.timeUnit+1));
                noOfFreshOranges--;
            }
            if(i-1>=0 && grid[i-1][j]==1)
            {
                grid[i-1][j]=2;
                que.add(new Oranges(i-1,j,ob.timeUnit+1));
                noOfFreshOranges--;
            }

            if(j-1>=0 && grid[i][j-1]==1)
            {
                grid[i][j-1]=2;
                que.add(new Oranges(i,j-1,ob.timeUnit+1));
                noOfFreshOranges--;
            }

            if(que.size()==0){
                return (noOfFreshOranges==0)?ob.timeUnit:-1;
            }

        }

        return (noOfFreshOranges==0)?0:-1;
    }
}
