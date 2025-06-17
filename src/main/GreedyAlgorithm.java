package main;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The Greedy algorithm is used to find the minimum spanning tree (ie.) We can
 * able to calculate the minimum weigth of the edges without any cycles. To
 * acheive that we are using the Disjoint set algorithm/ Union-Find algorithm
 * inside the Kruskals algorithm.
 * 
 * <p>
 * Greedy algorithm can be classified into two types: <b>1) Prims algorithm</b>
 * <b>2) Kruskals algorithm</b>.
 * </p>
 * 
 * 
 */
public class GreedyAlgorithm {

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int getFrom() {
			return from;
		}

		public int getTo() {
			return to;
		}

		public int getCost() {
			return cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) {

		Edge edge1 = new Edge(0, 1, 10);
		Edge edge2 = new Edge(0, 2, 5);
		Edge edge3 = new Edge(0, 3, 7);
		Edge edge4 = new Edge(1, 3, 15);
		Edge edge5 = new Edge(2, 3, 4);

		List<List<Edge>> li = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			li.add(new ArrayList<>());
		}

		li.get(0).add(edge1);
		li.get(0).add(edge2);
		li.get(0).add(edge3);
		li.get(1).add(edge4);
		li.get(2).add(edge5);

		primsAlg(li, 4, 0);

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(edge1);
		pq.add(edge2);
		pq.add(edge3);
		pq.add(edge4);
		pq.add(edge5);

		kruskalsAlgo(pq, 4);

	}

	/*
	 * For kruskals method, it follows the Union-Find Operation or DisJoint Sets
	 * model to avoid the cycles in the graph.
	 * 
	 * Need to develop the Union method by tomorrow
	 * 
	 * 2,3 - 4 0,2 - 5 0, 3- 7 0,1 - 10 1,3 - 15
	 */
	private static void kruskalsAlgo(PriorityQueue<Edge> pq, int length) {
		int parent[] = new int[length];
		List<Edge> mstList = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			parent[i] = i;
		}

		while (pq.size() > 0) {
			Edge e = (Edge) pq.poll();
			if (find(parent, e.from) != find(parent, e.to)) {
				mstList.add(e);
//				parent[e.to] = e.from; // Need to convert this as union code logic
				union(parent, e);
			}
		}

		mstList.forEach(e -> System.out.println(e.from + ", " + e.to + " = " + e.cost));

	}

	// Need to do recursive call to get the parent/root value for the from and to
	// values
	private static void union(int[] parent, Edge e) {
		int rootX = find(parent, e.from);
		int rootY = find(parent, e.to);
		parent[rootY] = rootX;

	}

	private static int find(int parent[], int value) {
		if (parent[value] != value) {
			parent[value] = find(parent, parent[value]);
		}
		return parent[value];
	}

	/**
	 * 
	 * Prim's Algorithm (Greedy approach) to find the Minimum Spanning Tree (MST):
	 * 
	 * <p>
	 * <b>Steps:</b>
	 * </p>
	 * Start from an arbitrary node and add all its edges to a priority queue
	 * (min-heap by cost).
	 * 
	 * While the MST is incomplete, pick the smallest edge from the queue that
	 * connects a visited node to an unvisited node.
	 * 
	 * Add the edge to the MST and mark the new node as visited. Repeat by adding
	 * its edges to the queue.
	 * 
	 * <b> This implementation avoids cycles by skipping edges pointing to already
	 * visited nodes. </b>
	 * 
	 * @param li     Adjacency list representing the undirected weighted graph.
	 * 
	 * @param length Number of vertices in the graph.
	 * 
	 * @param start  The starting vertex for Prim's algorithm.
	 */
	private static void primsAlg(List<List<Edge>> li, int length, int start) {

		boolean[] visited = new boolean[length];
		int[] minLen = new int[length];
		List<Edge> mstList = new ArrayList<>();
		for (int i = 1; i < minLen.length; i++) {
			minLen[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Edge> pq1 = new PriorityQueue<>();
		pq1.addAll(li.get(start));
		while (pq1.size() > 0 && mstList.size() <= length - 1) {
			Edge e = (Edge) pq1.poll();
			if (visited[e.getTo()])
				continue;
			mstList.add(e);
			visited[e.getTo()] = true;
			for (Edge edge : li.get(e.getTo())) {
				if (!visited[edge.getTo()]) {
					pq1.add(edge);
				}
			}
		}
		mstList.forEach(edge -> System.out.println(edge.getFrom() + "," + edge.getTo() + " = " + edge.getCost()));
	}

}
