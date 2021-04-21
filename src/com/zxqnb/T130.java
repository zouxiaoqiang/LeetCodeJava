package com.zxqnb;

import java.awt.geom.QuadCurve2D;
import java.util.LinkedList;
import java.util.Queue;

public class T130 {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] step = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                q.offer(new int[] {i, n - 1});
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
            }
            if (board[m - 1][j] == 'O') {
                q.offer(new int[] {m - 1, j});
            }
        }
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            board[x][y] = 'A';
            for (int[] move: step) {
                int mx = move[0] + cell[0], my = move[1] + cell[1];
                if (mx < 0 || mx >= m || my < 0 || my >= n || board[mx][my] != 'O') {
                    continue;
                }
                q.offer(new int[]{mx, my});
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int m, n;

    public void solve1(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}
