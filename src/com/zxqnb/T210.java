package com.zxqnb;

import java.util.*;

public class T210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] courses = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            courses[prerequisite[1]][prerequisite[0]] = 1;
            degree[prerequisite[0]]++;
        }
        Queue<Integer> visitQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                visitQueue.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int cnt = 0;
        while (!visitQueue.isEmpty()) {
            int visit = visitQueue.poll();
            ans[cnt++] = visit;
            for (int j = 0; j < numCourses; j++) {
                if (courses[visit][j] == 1) {
                    degree[j]--;
                    if (degree[j] == 0) {
                        visitQueue.add(j);
                    }
                }
            }
        }
        return cnt == numCourses ? ans : new int[]{};
    }

    private int[] visited;
    private boolean valid;
    private int index;
    private int[] ans;
    private List<List<Integer>> edges;

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        visited = new int[numCourses];
        valid = true;
        ans = new int[numCourses];
        index = numCourses - 1;
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        return ans;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (int e : edges.get(i)) {
            if (visited[e] == 0) {
                dfs(e);
                if (!valid) {
                    return;
                }
            } else if (visited[e] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        ans[index--] = i;
    }
}
