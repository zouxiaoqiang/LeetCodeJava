package com.zxqnb;

import java.util.LinkedList;
import java.util.Queue;

public class T207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites.length == 0) {
            return true;
        }
        int[][] mat = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            mat[prerequisite[1]][prerequisite[0]] = 1;
            degree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            visited++;
            for (int j = 0; j < numCourses; j++) {
                if (mat[i][j] == 1) {
                    degree[j]--;
                    if (degree[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }
        return visited == numCourses;
    }
}
