package com.holmesycl.algorithms.graph.search;

import com.holmesycl.algorithms.graph.Graph;
import com.holmesycl.algorithms.graph.Paths;

import java.util.Stack;

public class DepthFirstPaths extends Paths {

    public DepthFirstPaths(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
}
