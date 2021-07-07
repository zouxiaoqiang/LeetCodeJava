package com.zxqnb;

public class T208 {
    class Trie {
        private Trie[] children;
        private boolean end;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new Trie[26];
            end = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0, len = word.length(); i < len; i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie prefix = searchPrefix(word);
            return prefix != null && prefix.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0, len = prefix.length(); i < len; i++) {
                int index = prefix.charAt(i);
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

    }
}
