package com.company;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class FriendshipGraph<E> implements IGraph<E> {
    //静态内部类，非静态内部类不可以使用外部的非静态变量，非静态内部类中不可以声明静态成员
    private static class ENode{
        int adjvex;//保存节点的序号
        int weight;//保存权值，在本题中为1
        ENode nextadj;
        public ENode(int adjvex) {
            this.adjvex= adjvex;
            this.weight=1 ;//设置默认值为1
        }
    }
    private static class VNode<E>{
        E data;
        ENode firstadj;//邻接的第一个顶点
        int number;
        public int getNumber(){
            return this.number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
        public E getData() {
            return data;
        }
        public void setData(E data) {
            this.data = data;
        }
        public int select(E v){
            if (v==data){
                return number;
            }else {
                return -1;
            }
        }
    }
    private VNode<E>[] vexs;//顶点组成的数组
    private int numOfVexs;
    private int maxOfVexs;//最大值默认为100
    public FriendshipGraph(){
        this.numOfVexs=0;
       this.maxOfVexs=100;
        vexs=(VNode<E>[]) Array.newInstance(VNode.class,this.maxOfVexs);
    }
    @Override
    public boolean addVertex(E v) {
        VNode<E> vex=new VNode<E>();
        vex.data=v;
        vex.firstadj=null;
        vex.setNumber(numOfVexs);
        vexs[numOfVexs]=vex;
        numOfVexs++;
        return true;
    }

    @Override
    public boolean addEdge(E v1, E v2) {//v1指向v2有一条边
        int numberOfv1=-1,numberOfv2=-1;
        for (int i = 0; i <numOfVexs ; i++) {
            if (vexs[i].select(v1)==i){
                numberOfv1=i;
            }
            if (vexs[i].select(v2)==i){
                numberOfv2=i;
            }
        }
        ENode eNode=new ENode(numberOfv2);
        if(vexs[numberOfv1]==null){
            vexs[numberOfv1].firstadj=eNode;
        }else {
            eNode.nextadj=vexs[numberOfv1].firstadj;
            vexs[numberOfv1].firstadj=eNode;
        }
        return true;
    }

    @Override
    public int getDistance(E v1, E v2) {
        //利用迪杰斯特拉算法求解最短路径
        int numberOfv1=-1;
        int numberOfv2=-1;
        int number=-1;
        for (int i = 0; i <numOfVexs ; i++) {
            if (vexs[i].select(v1)==i){
                numberOfv1=i;
            }
            if(vexs[i].select(v2)==i){
                numberOfv2=i;
            }
        }
        if(numberOfv1==-1||numberOfv2 ==-1){
            return 0;//表示有一个人还没有加入到图中
        }
        boolean[] st=new boolean[numOfVexs];
        int[] distance=new int[numOfVexs];
        for (int i = 0; i <numOfVexs ; i++) {
            distance[i]=Integer.MAX_VALUE;
        }
        ENode current;
        current=vexs[numberOfv1].firstadj;
        while (current!=null){
            distance[current.adjvex]=current.weight;
        //    st[current.adjvex]=true;
            current=current.nextadj;
        }
        distance[numberOfv1]=0;
        st[numberOfv1]=true;
        for (int i = 0; i <numOfVexs ; i++) {
            int min=Integer.MAX_VALUE;
            int index=-1;
            for (int j = 0; j <numOfVexs ; j++) {
                if(false == st[j]){
                    if(distance[j]<min){
                        index=j;
                        min=distance[j];
                       // st[j]=true;
                    }
                }
            }
            //序号为index的顶点加入到了集合当中
            if (index!=-1){
                st[index]=true;
            }
            for (int w = 0; w < numOfVexs; w++) {
                if(st[w]==false){
                    current=vexs[index].firstadj;
                    while (current!=null){//循环遍历与index邻接的顶点
                        if(current.adjvex==w){//index的节点与这个节点w邻接
                            if ((min+current.weight)<distance[w]){
                                distance[w]=min+current.weight;
                             //   st[w]=true;
                                break;
                            }
                        }
                        current=current.nextadj;
                    }
                }
            }
        }
        if(distance[numberOfv2]<10000) {
            return distance[numberOfv2];
        }else {
            return -1;
        }
    }

    @Override
    public String depthFirstSearch(E v) {
        int number=-1;
        for (int i = 0; i <numOfVexs ; i++) {
            if(vexs[i].select(v)==i){
                number=i;
            }
        }
        boolean[] visited=new boolean[numOfVexs];
   //     StringBuilder builder=new StringBuilder();
        Stack<Integer> stack=new Stack<Integer>();
        Vector<E> vector=new Vector<E>();
        if(number==-1){
            return null;
        }
        stack.push(number);
        visited[number]=true;
        while (!stack.empty()){
            int num=stack.pop();
            vector.add(vexs[num].getData());//访问的顺序存在这里
            ENode current;
            current=vexs[num].firstadj;
            while (current!=null){
                if(!visited[current.adjvex]){
                    stack.push(current.adjvex);//压入栈的过程，就相当于访问了
                    visited[current.adjvex]=true;
                }
                current=current.nextadj;
            }
        }
        return null;
    }

    @Override
    public String breadFirstSearch(E v) {
        int number=-1;
        for (int i = 0; i <numOfVexs; i++) {
            if (vexs[i].select(v)==i){
                number=i;
            }
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        Vector<E> vector=new Vector<E>();
        queue.add(number);
        vector.add(vexs[number].getData());
        while (!queue.isEmpty()){
            int popNumber;
            popNumber=queue.poll();
            ENode current=vexs[popNumber].firstadj;
            while (current!=null){
              vector.add(vexs[current.adjvex].getData());
              queue.add(current.adjvex);
              current=current.nextadj;
            }
        }
        return null;
    }

}
