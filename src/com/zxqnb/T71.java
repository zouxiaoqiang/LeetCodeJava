package com.zxqnb;

import java.util.ArrayList;
import java.util.List;

public class T71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        List<String> names = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != '/') {
                int j = i;
                while (j < path.length() && path.charAt(j) != '/') {
                    j++;
                }
                names.add(path.substring(i, j));
                i = j;
            }
        }
        List<String> ans = new ArrayList<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (ans.size() > 0) {
                    ans.remove(ans.size() - 1);
                }
            } else if (!".".equals(name)) {
                ans.add(name);
            }
        }
        return "/" + String.join("/", ans);
    }
}
