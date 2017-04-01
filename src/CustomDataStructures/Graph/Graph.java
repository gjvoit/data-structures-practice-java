package CustomDataStructures.Graph;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

import java.io.*;
import java.util.*;

/**
 * Created by garetvoit on 3/24/17.
 * Commonly associated words: vertices, nodes, edges, connections, connectivity, paths, cycles and direction.
 * Key terms:
 * Order – The number of vertices in a graph
 * Size – The number of edges in a graph
 * G = {V, E} is defined as a set of vertices, V, and a collection of edges (which is not necessarily a set), E.
 * An edge can then be defined as (u, v) where u and v are elements of V.
 */
public class Graph {
    // Create a resizable 2d array. The first dimension serves as the set of Vertices, while the second serves as a "bucket"
    // of weights associated with edges for each Vertex.
    private Vector<Vector<Integer>> unweightedGraph;

    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println("Specify a file (relative filepath) from which to build our graph:");
//        Scanner in = new Scanner(System.in);
//        File file = new File(in.nextLine());
        Scanner scanner = new Scanner(new File("./src/CustomDataStructures/Graph/smallUnweighted.txt"));
        Graph graph = new Graph(scanner);
        System.out.println(graph.toString());
//        try { graph.addEdgeUnweighted(1,6); }
//        catch (Exception e) { System.out.println(e); }
//        try { graph.addEdgeUnweighted(1,2); }
//        catch (Exception e) { System.out.println(e); }
//        System.out.println(graph.toString());
        System.out.println(graph.bfs(3));
        graph.dfs(0);
    }

    public Graph(int[] V) {
        for (int i : V) {
            unweightedGraph.set(i, new Vector<Integer>());
        }
    }

    public Graph(Scanner sc) throws FileNotFoundException, NoSuchElementException {
        int i, V, E;
        unweightedGraph = new Vector<Vector<Integer>>();

        if (sc.hasNextLine()) {
            V = Integer.parseInt(sc.nextLine());
        } else throw new NoSuchElementException();

        if (sc.hasNextLine()) {
            E = Integer.parseInt(sc.nextLine());
        } else throw new NoSuchElementException();

        for (i = 0; i < V; i++) {
            unweightedGraph.add(new Vector<Integer>());
        }
        for (i=0; i < E; i++) {
            String[] line;
            if (sc.hasNextLine()) {
                line = sc.nextLine().split(" ");
                unweightedGraph.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
            }
        }
    }

    public String toString() {
        int i;
        String res = "";

        for (i=0; i<unweightedGraph.size(); i++)
            res += "[" + i + "]: " + unweightedGraph.get(i).toString() + "\n";
        return res;
    }

    public void addVertexUnweighted() {
        unweightedGraph.add(new Vector<Integer>());
    }

    public void addEdgeUnweighted(int from, int to) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (to < 0 || to >= unweightedGraph.size())
            throw new IndexOutOfBoundsException("Vertex \"" + to + "\" not found in Graph");
        else if (from < 0 || from >= unweightedGraph.size())
            throw new IndexOutOfBoundsException("Vertex \"" + from + "\" not found in Graph");
        else if (unweightedGraph.get(from).contains(to))
            throw new IllegalArgumentException("Edge already exists from Vertex \"" + from + "\" to Vertex \"" + to + "\"");
        else unweightedGraph.get(from).add(to);
    }

    public String bfs(int s) {
        String res = "";
        boolean[] visited = new boolean[unweightedGraph.size()];
        LinkedList<Integer> queuedVertices = new LinkedList<Integer>();

        visited[s] = true;
        queuedVertices.add(s);

        while (queuedVertices.size()!=0) {
            s = queuedVertices.poll();
            res += s + " ";
            Iterator<Integer> i = unweightedGraph.get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queuedVertices.add(n);
                }
            }
        }
        return res;
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " ");
        Iterator<Integer> i = unweightedGraph.get(v).listIterator();
        while(i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public void dfs(int s) {
        if (s < 0 || s >= unweightedGraph.size()) throw new IndexOutOfBoundsException("Node specified is not within the Graph");
        boolean[] visited = new boolean[unweightedGraph.size()];
        visited[s] = true;
        DFSUtil(s, visited);
    }

}
