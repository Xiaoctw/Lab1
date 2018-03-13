package com.company;

import javax.naming.ldap.PagedResultsControl;
import java.util.function.ToDoubleBiFunction;

public class Main {

    public static void main(String[] args) {
	Person xiao=new Person("xiao");
	Person han=new Person("han");
	Person tom=new Person("Tom");
	Person je=new Person("je");
	Person tim=new Person("tim");
	FriendshipGraph<Person> friendshipGraph=new FriendshipGraph<>();
	friendshipGraph.addVertex(xiao);
	friendshipGraph.addVertex(han);
	friendshipGraph.addVertex(tom);
	friendshipGraph.addVertex(je);
	friendshipGraph.addVertex(tim);
	friendshipGraph.addEdge(xiao,han);
	friendshipGraph.addEdge(xiao,je);
	friendshipGraph.addEdge(han,tom);
	friendshipGraph.addEdge(tom,tim);
	//friendshipGraph.addEdge(xiao,tim);
	int distance=friendshipGraph.getDistance(xiao,tim);
	System.out.println(distance);
	friendshipGraph.depthFirstSearch(xiao);
	friendshipGraph.breadFirstSearch(xiao);
    }
}
