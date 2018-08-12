package com.holmesycl.algorithms.graph;

import com.holmesycl.algorithms.graph.search.BreadthFirstPaths;
import com.holmesycl.algorithms.graph.search.DepthFirstPaths;
import com.holmesycl.algorithms.graph.search.DepthFirstSearch;
import com.holmesycl.algorithms.structure.Bag;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
                s += "\n";
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        Search search = new DepthFirstSearch(graph, 0);
        System.out.println(search.count());
        System.out.println(search.marked(3));

        Paths path = new DepthFirstPaths(graph, 0);
        System.out.println(path.pathTo(3));

        path = new BreadthFirstPaths(graph, 0);
        System.out.println(path.pathTo(3));

        CC cc = new CC(graph);
        System.out.println(cc.connected(1,2));
        System.out.println(cc.id(5));
        System.out.println(cc.count());

    }


}
