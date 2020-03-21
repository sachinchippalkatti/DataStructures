package com.sachin.graph;

import java.util.LinkedList;
import java.util.Queue;

//Java Program to demonstrate adjacency list  
//representation of graphs
public class GraphImp {
	
	static class Graph{
		int v;
		LinkedList<Integer> adjList[];
		
		Graph(int v){
			this.v = v;
			adjList = new LinkedList[v];
			for(int i =0;i<v;i++) {
				adjList[i] = new LinkedList<>();
			}
		}
	}
	
	public static void main(String args[]) {
		int v=5;
		Graph graph = new Graph(v);
		addEdge(graph,0,1);
		addEdge(graph,0,4);
		addEdge(graph,1,2);
		addEdge(graph,1,3);
		addEdge(graph,1,4);
		addEdge(graph,2,3);
		addEdge(graph,3,4);
		
		displayGraph(graph);
		
		BreadthFS(graph,0);
		
		depthFS(graph,0);
		
		shortestPath(graph,0,4);
		
	}
	
	private static void depthFS(Graph graph, int value) {
		boolean visited[] = new boolean[graph.v];
		System.out.println("Depth first Traversal : ");
		depthFSUtil(value,visited,graph);
	}

	private static void depthFSUtil(int value, boolean[] visited, Graph graph) {
		visited[value] = true;
		System.out.print(value + "-->");
		
		for(Integer val: graph.adjList[value]) {
			if(!visited[val]) {
				depthFSUtil(val,visited,graph);
			}
		}
	}

	private static void shortestPath(Graph graph, int src, int des) {
		boolean visited[] = new boolean[graph.v];
		Queue<Integer> queue = new LinkedList<>();
		
		visited[src]=true;
		queue.add(src);
		int path =0;
		System.out.println("ShortestPath");
		while(queue.size()!=0) {
			if(src==des)
				break;
			src=queue.poll();
			path++;
			System.out.print(src + "->");			
			for(Integer value: graph.adjList[src]) {
				if(!visited[value]) {
					queue.add(value);
					visited[value]=true;
				}
			}
		}
		
		System.out.println("shorted Path :" + path);
	}
	
	private static void BreadthFS(Graph graph, int first) {
		boolean visited[] = new boolean[graph.v];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(first);
		visited[first] = true;
		
		while(queue.size() !=0) {
			first = queue.poll();
			System.out.print(first + "->");
			
			for(Integer value: graph.adjList[first]) {
				if(!visited[value]) {
				queue.add(value);
				visited[value] = true;
				}
			}
		}
	}
	//Display the graph
	private static void displayGraph(Graph graph) {
		// TODO Auto-generated method stub
		for(int i=0;i<graph.v;i++) {
			System.out.println("Adjacency list of vertex " + i);
			System.out.println("head");
			for(Integer value : graph.adjList[i]) {
				System.out.print("-->" + value);
			}
			System.out.println();
		}
	}

	//Add the edge
	private static void addEdge(Graph graph, int src, int desc) {
		// TODO Auto-generated method stub
		graph.adjList[src].add(desc);
		graph.adjList[desc].add(src);
	}

}


