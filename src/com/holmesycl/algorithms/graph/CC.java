package com.holmesycl.algorithms.graph;

public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if(!marked[i]){
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(Graph G, int i) {
        marked[i] = true;
        id[i] = count;
        for (int w : G.adj(i)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

}
