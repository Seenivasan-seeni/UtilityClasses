package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * Cut Edge Algorithm is used to find how many components are available in the graph if we remove any of the connected edges.
 * We have used DFS traversal to solve this algorithm
 */
public class CutEdgeAlgo {
	
	static int time = 0;
	
	private static void cutEdgeAlgo(List<List<Integer>> graph, int n) {
		boolean visited[] = new boolean[n];
		List<Integer> adj[] = new ArrayList[n];
		int start = 0;
		int[] step = new int[n];
		int[] parent = new int[n];
		int[] low = new int[n];
		Arrays.fill(parent, -1);
		Arrays.fill(low, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (List<Integer> list : graph) {
			int u = list.get(0);
			int v = list.get(1);
			adj[u].add(v);
		}
		Stream.of(adj).forEach(t -> System.out.print(t + " - "));
		step[start] = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(visited, adj, step, i, parent, low);
			}
		}
	}

	private static void dfs(boolean[] visited, List<Integer>[] adj, int[] step, int i, int[] parent, int[] low) {
		visited[i] = true;
		step[i] = ++time;

		for (int v : adj[i]) {
			if (!visited[v]) {
				parent[v] = i;
				dfs(visited, adj, step, v, parent, low);
				low[i] = Math.min(low[i], low[v]);
				if(low[v]>step[i]) {
					System.out.println(i + " - " + v);
				}
			} else {
				low[i] = Math.min(step[v], low[i]);
			}
		}
	}

	/*
	 * visited - [true,true,true,true,true]
	 * adj - [[1], [2, 3], [0], [4], []]
	 * step - [1,2,3,4,5] 
	 * i = 3	
	 * parent - [-1,0,1,1,3] 
	 * low = [Max,Max,1,Max,3]
	 * v = 4
	 */
	// [[0, 1], [1, 2], [2, 0], [1, 3], [3, 4]]
	public static void main(String[] args) {
		int n = 5;
		List<List<Integer>> graph = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0),
				Arrays.asList(1, 3), Arrays.asList(3, 4));

		cutEdgeAlgo(graph, n);
	}

}
