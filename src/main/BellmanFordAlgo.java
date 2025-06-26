package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
 * As per the Bellman for algorithm, the idea is to find the shortest distance between the vertices, same like the Dijkshtra algorithm.
 * But for the dijkshtra algorithm, If there is any negative weights are there in the graph means, It will return the wrong results.
 * So for that case the Bellman ford algorithm will works better. 
 * 
 * In this algorithm, we have to execute the loop for (n-1) number of time to find the exact shortest path of the graph. 
 * Where n is the number of vertices. Due to that, It will have the time complexity of n^3 for the complete graph.
 * 
 * Complete graph means all the vertices will have the two leaf nodes except the last leaf node.
 * 
 * For other than the complete graph it will have the time complexity of n^2 times.
 * 
 * By using this algo, We can able to detect is there any negative edge cycles are there.
 * 1) Need to relax the shortest distance by doing the (n-1) iterations. Where n is the number of vertices.
 * 2) During the (n-1)th iterations, the shortest distance has been finalized. If the any negative Cycle is there in the graph then we have to 
 * do n th iteration. If any negative cycle is there then again the shortest distance will be derived. and it will cause the infinite iteration
 * and also it will produce the wrong output also.
 * 
 * We cant able to detect the negative cycle in the dijkshtra algorithm.
 */
public class BellmanFordAlgo {

	public static void main(String[] args) {
		int V = 5; // Number of vertices
		int E = 10; // Number of edges

		Edge[] edges = new Edge[E];
		edges[0] = new Edge(0, 1, 6);
		edges[1] = new Edge(0, 2, 7);
		edges[2] = new Edge(1, 2, 8);
		edges[3] = new Edge(1, 3, 5);
		edges[4] = new Edge(1, 4, -4);
		edges[5] = new Edge(2, 3, -3);
		edges[6] = new Edge(2, 4, 9);
		edges[7] = new Edge(3, 1, -2);
		edges[8] = new Edge(4, 0, 2);
		edges[9] = new Edge(4, 3, 7);
		int start = 0;

		bellmanFordAlgo(edges, start, V);
	}

	/*
	 * edges = [[1,2],[2,3,4],[3,4],[1],[0,3]]
	 * (0,1),(0,2),(1,2),(1,3),(1,4),(2,3),(2,4),(3,1),(4,0),(4,3) int minDist =
	 * [max,max,max,max,max,max,max,max,max]
	 */

	private static void bellmanFordAlgo(Edge[] edges, int start, int V) {
		List<Edge> edgeList = new ArrayList<>();
		Collections.addAll(edgeList, edges);
		int noOfVertices = edgeList.size() - 1;

		int[] minDistance = new int[V];
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[start] = 0;

		for (int i = 0; i < noOfVertices; i++) {

			for (Edge edge : edgeList) {
				if ((minDistance[edge.getSrc()] + edge.getWeight()) < minDistance[edge.getDest()]) {
					minDistance[edge.getDest()] = minDistance[edge.getSrc()] + edge.getWeight();
				}
			}
		}
		IntStream.of(minDistance).forEach(t -> System.out.println(t));

	}

}

class Edge {
	int src, dest, weight;

	Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
