package dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Below are the three steps to find the number of strongly connected components are available in the graph by using the kosaraju algorithm.
 * 1) First DFS pass: Fill the stack with nodes in order of their finishing times.
 * 2) Transpose the graph
 * 3) Second DFS pass on the transposed graph, popping nodes from the stack, to find Strongly Connected Components (SCCs).
 */
public class KosarajuAlgo {

	static int size = 5;

	public static void main(String[] args) {
		List<List<Integer>> graph = new ArrayList();
		for (int i = 0; i < size; i++)
			graph.add(new ArrayList<Integer>());
		graph.get(0).add(1);
		graph.get(1).add(2);
		graph.get(2).add(0);
		graph.get(1).add(3);
		graph.get(3).add(4);
		graph.get(4).add(3);
		kosarajuAlgo(graph, size);
	}

	static void dfs(int v, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		for (int trgtV : graph.get(v)) {
			if (!visited[trgtV])
				dfs(trgtV, graph, visited, stack);
		}
		stack.push(v);
	}

	static void dfs1(int v, List<List<Integer>> adjTList, boolean[] visitedT) {
		visitedT[v] = true;
		for (int u : adjTList.get(v))
			if (!visitedT[u])
				dfs1(u, adjTList, visitedT);
	}

	/*
	 * graph = [[1], [2, 3], [0], [4], [3]] Transpose - [[2],[0],[1],[1,4],[3]]
	 */
	static void kosarajuAlgo(List<List<Integer>> graph, int size) {
		int scc = 0;
		boolean visited[] = new boolean[size];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < size; i++)
			if (!visited[i])
				dfs(i, graph, visited, stack);

		List<List<Integer>> adjTList = new ArrayList<>();
		for (int i = 0; i < size; i++)
			adjTList.add(new ArrayList<>());

		for (int i = 0; i < graph.size(); i++)
			for (int u : graph.get(i))
				adjTList.get(u).add(i);

		boolean[] visitedT = new boolean[size];

		while (!stack.empty()) {
			int node = stack.pop();
			if (!visitedT[node]) {
				dfs1(node, adjTList, visitedT);
				scc++;
			}
		}
		System.out.println("Number of Strongly Connected Components are " + scc);
	}
}
