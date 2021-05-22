package com.zxqnb;

public class T79 {
    private boolean[][] visited;
    private int m, n;
    private final int[][] step = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean dfs(char[][] board, String word, int cur, int x, int y) {
        if (cur == word.length()) {
            return true;
        }
        for (int[] dir : step) {
            int dx = x + dir[0], dy = y + dir[1];
            if (dx > -1 && dx < m && dy > -1 && dy < n && !visited[dx][dy] && board[dx][dy] == word.charAt(cur)) {
                visited[dx][dy] = true;
                if (dfs(board, word, cur + 1, dx, dy)) {
                    return true;
                }
                visited[dx][dy] = false;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        if (word.length() > m * n) {
            return false;
        }
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    if (dfs(board, word, 1, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
}
