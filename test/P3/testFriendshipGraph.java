package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testFriendshipGraph {
    Person xiao=null;
    Person han=null;
    Person tom=null;
    Person je=null;
    Person tim=null;
    FriendshipGraph<Person> friendshipGraph=null;
    @Before
    public void init(){
         xiao=new Person("xiao");
         han=new Person("han");
         tom=new Person("Tom");
         je=new Person("je");
         tim=new Person("tim");
         friendshipGraph=new FriendshipGraph<Person>();
        friendshipGraph.addVertex(xiao);
        friendshipGraph.addVertex(han);
        friendshipGraph.addVertex(tom);
        friendshipGraph.addVertex(je);
        friendshipGraph.addVertex(tim);
        friendshipGraph.addEdge(xiao,han);
        friendshipGraph.addEdge(xiao,je);
        friendshipGraph.addEdge(han,tom);
        friendshipGraph.addEdge(tom,tim);
    }
    @Test
    public void test(){
        Assert.assertEquals(3,friendshipGraph.getDistance(xiao,tim));
    }
}
