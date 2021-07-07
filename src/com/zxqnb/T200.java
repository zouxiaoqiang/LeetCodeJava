package com.zxqnb;


import java.util.LinkedList;
import java.util.Queue;

public class T200 {

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dx = x + step[i][0], dy = y + step[i][1];
            if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == '1' && !visited[dx][dy]) {
                dfs(grid, dx, dy);
            }
        }
    }

    private boolean[][] visited;
    private int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(char[][] grid, Queue<Point> queue) {
        Point point;
        int x, y, dx, dy;
        while (!queue.isEmpty()) {
            point = queue.poll();
            x = point.x;
            y = point.y;
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                dx = x + step[i][0];
                dy = y + step[i][1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == '1' && !visited[dx][dy]) {
                    queue.offer(new Point(dx, dy));
                }
            }
        }
    }

    private class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        UnionFind(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            count = 0;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        int getCount() {
            return count;
        }

    }

    public int numIslands2(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    public int numIslands1(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new Point(i, j));
                    bfs(grid, queue);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
