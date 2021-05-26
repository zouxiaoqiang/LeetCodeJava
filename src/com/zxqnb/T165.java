package com.zxqnb;

public class T165 {
    private int[] getNextChunk(int p, int n, String version) {
        if (p >= n) {
            return new int[]{0, p};
        }
        int pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            pEnd++;
        }
        int i = Integer.parseInt(version.substring(p, pEnd));
        p = pEnd + 1;
        return new int[] {i, p};
    }

    public int compareVersion(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int p1 = 0, p2 = 0;
        int i1, i2;
        int[] pair = new int[2];
        while (p1 < n1 || p2 < n2) {
            pair = getNextChunk(p1, n1, version1);
            i1 = pair[0];
            p1 = pair[1];
            pair = getNextChunk(p2, n2, version2);
            i2 = pair[0];
            p2 = pair[1];
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            }
        }
        return 0;
    }
}
