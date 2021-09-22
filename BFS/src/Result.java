import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	public static void main(String[] args) {
//		List<List<Integer>> edges = new ArrayList<>();
//		int n = 4;
//		int m = 2;
//		List<Integer> edge1 = Arrays.asList(1, 2);
//		List<Integer> edge2 = Arrays.asList(1, 3);
//
//		edges.add(edge1);
//		edges.add(edge2);
//
//		System.out.println((bfs(n, m, edges, 1)));
		List<List<Integer>> edges = new ArrayList<>();
		int n = 5;
		int m = 3;
		List<Integer> edge1 = Arrays.asList(1, 3);
		List<Integer> edge2 = Arrays.asList(3, 4);
		List<Integer> edge3 = Arrays.asList(1, 2);

		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);

		System.out.println((bfs(n, m, edges, 1)));
	}

	static ArrayList<Node> nodes = new ArrayList<Node>();

	static Queue<Node> queue = new LinkedList<Node>();;

	/*
	 * Complete the 'bfs' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER n - number of nodes 2. INTEGER m - number of
	 * edges 3. 2D_INTEGER_ARRAY edges - array of edges (parent node, child node) 4.
	 * INTEGER s - start node
	 */
	public static class Node {

		int data;
		boolean visited;
		List<Node> neighbors;
		int distance;

		public Node(int data) {

			this.data = data;
			this.distance = 0;
			this.neighbors = new ArrayList<Node>();
		}

		// 1 node can take in another node and add it to its list of neighbors
		public void addNeighbors(Node neighborNode) {
			this.neighbors.add(neighborNode);
		}

		public List<Node> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(List<Node> neighbors) {
			this.neighbors = neighbors;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", visited=" + visited + ", neighbors=" + neighbors + ", distance=" + distance
					+ "]";
		}

	
	}

	public static List<Integer> bfs(int num, int m, List<List<Integer>> edges, int s) {
		// Write your code here
		int EDGE_DISTANCE = 6;

        // fill all distances with -1 (unreachable)
        int[] distances = new int[n];
        Arrays.fill(distances, -1);

        Queue<Integer> nodes = new LinkedList<>();

        // add start node into queue, and its distance (to itself) is 0;
        nodes.add(s);
        distances[s - 1] = 0; // index of s in the distance is `s-1`.

        while (!nodes.isEmpty()) {
            int node = nodes.poll();
            /*
             * Loop all edges.
             * Edges means two nodes have connection. so the connected node's distance is my (node) distance + EDGE_DISTANCE.
             *
             * Tricky point:
             * Edge just represents node 1 has connection with node 2, not the sequence.
             * So FROM could be edge[0] or edge[1].
             * We need to take care of both ends.
             *  */
            for (int[] edge : edges) {
                if (edge[0] == node && distances[edge[1] - 1] == -1) {
                    distances[edge[1] - 1] = distances[node - 1] + EDGE_DISTANCE;
                    nodes.add(edge[1]);
                } else if (edge[1] == node && distances[edge[0] - 1] == -1) {
                    distances[edge[0] - 1] = distances[node - 1] + EDGE_DISTANCE;
                    nodes.add(edge[0]);
                }
            }
        }

        // Exclude start node from distances.
        int[] result = new int[n - 1];
        int j = 0;
        for (int i = 0; i < distances.length; i++) {
            if (s - 1 == i) {
                continue;
            }
            result[j] = distances[i];
            j++;
        }

        return result;
	}
	public static void clearLists(){
	        nodes = new ArrayList<Node>();
	        queue = new LinkedList<Node>();
	}
	public static void bfs(Node node) {
		// insert the root node into the queue that belongs to this object
		queue.add(node);
		// set the node passed thru as visited
		node.visited = true;

		while (!queue.isEmpty()) {

			// pop the head off the queue and print it out!
			Node element = queue.remove();;

			// find out the neighbors of the element we just popped off
			List<Node> neighbors = element.getNeighbors();

			// iterate through the list of neighbors, check if it's been visited or not, and
			// if not, we add it to the queue
			for (int i = 0; i < neighbors.size(); i++) {
				Node n = neighbors.get(i);

				// check to see if it's null or visited
				if (n != null && !n.visited) {
					queue.add(n);
					n.distance =6+element.distance;
					n.visited = true;

				}
			}
		}
	}

}
