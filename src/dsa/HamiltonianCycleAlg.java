package dsa;

import java.util.Stack;

public class HamiltonianCycleAlg {
	
	static int startNode = 0;
	
	static int count = 0;

	private static void hamiltonianCycle(int[][] graph) {
		int n = graph.length;
		int start = 0;
		boolean visited[] = new boolean[n];
		Stack<Integer> currentNodeList = new Stack<Integer>();

		currentNodeList.push(start);
		dfs(graph, currentNodeList, visited);
	}

	/**
	 * graph ={ { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1}, { 0, 1, 1, 1, 0 } }
	 * i = 0
	 * visited = [true,true,true,true,true]
	 * currentNode = 0,1,3,4,2
	 * j = 1,3,4,2
	 */
	private static void dfs(int[][] graph, Stack<Integer> currentNodeList, boolean visited[]) {
		int currentNode = (int) currentNodeList.peek();
		visited[currentNode] = true;
		for (int j = 0; j < graph.length; j++) {
			if (graph[currentNode][j] == 1 && !visited[j]) {
				currentNodeList.push(j);
				dfs(graph, currentNodeList, visited);
			}
		}
		visited[currentNode] = false;
		if (graph[currentNode][startNode] == 1 && currentNodeList.size() == graph.length) {
			count++;
			currentNodeList.forEach(a -> System.out.println(a));
			System.out.println("Hamiltonian cycle is found : " + count);
		}
		currentNodeList.pop();
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 } };

		hamiltonianCycle(graph);
	}

}
