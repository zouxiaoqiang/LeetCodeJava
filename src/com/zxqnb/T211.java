package com.zxqnb;

public class T211 {
    class WordDictionary {

        private WordDictionary[] children;
        private boolean end;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            children = new WordDictionary[26];
            end = false;
        }

        public void addWord(String word) {
            WordDictionary wd = this;
            for (int i = 0, len = word.length(); i < len; i++) {
                int index = word.charAt(i) - 'a';
                if (wd.children[index] == null) {
                    wd.children[index] = new WordDictionary();
                }
                wd = wd.children[index];
            }
            wd.end = true;
        }

        public boolean search(String word) {
            return dfs(word, this);
        }

        private boolean dfs(String word, WordDictionary wd) {
            if (wd == null) {
                return false;
            }
            if (word.length() == 0) {
                return wd.end;
            }
            char ch = word.charAt(0);
            if (word.charAt(0) == '.') {
                for (int i = 0; i < 26; i++) {
                    if (dfs(word.substring(1), wd.children[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                return dfs(word.substring(1), wd.children[ch - 'a']);
            }
        }
    }
}
