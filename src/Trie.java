
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        insertHelper(root, word, 0);


    }

    private void insertHelper(TrieNode cur, String word, int i) {

        char charToInsert = word.charAt(i);
        TrieNode node;
        if (cur.child[charToInsert - 'a'] == null) {
            node = new TrieNode();
            node.val = charToInsert;
            cur.child[charToInsert - 'a'] = node;
        } else {
            node = cur.child[charToInsert - 'a'];
        }

        if (i == word.length() - 1) {
            node.isEndOfString = true;
        } else {
            insertHelper(node, word, i + 1);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        return searchHelper(root.child[word.charAt(0) - 'a'], word, 0);
    }

    private boolean searchHelper(TrieNode cur, String word, int i) {
        char searchedChar = word.charAt(i);

        if (cur != null) {
            if (cur.val == searchedChar) {
                if (cur.isEndOfString && i == word.length() - 1) {
                    return true;
                } else if (!cur.isEndOfString && i == word.length() - 1) {
                    return false;
                } else if (i < word.length() - 1) {
                    char nextChar = word.charAt(i+1);
                    return searchHelper (cur.child[nextChar - 'a'], word, i+1);
                }
            }

            return false;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        if (prefix.length() == 0) {
            return true;
        }

        return startsWithHelper(root.child[prefix.charAt(0) - 'a'], prefix, 0);

    }
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    private boolean startsWithHelper(TrieNode cur, String prefix, int i) {
        char searchedChar = prefix.charAt(i);

        if (cur != null) {
            if (cur.val == searchedChar) {
                if (i == prefix.length() - 1) {
                    return true;
                } else {
                    char nextChar = prefix.charAt(i+1);

                    return startsWithHelper (cur.child[nextChar - 'a'], prefix, i+1);
                }
            }

            return false;
        }
        return false;
    }


    public static void  main(String [] args) {
        // Your Trie object will be instantiated and called as such:
        Trie trie = new Trie();
        trie.insert("somestring");
        System.out.println("search for word \"some\": " + trie.search("some"));
        System.out.println("search for prefix \"some\": " + trie.startsWith("some"));
        System.out.println("search for \"somestring\": " + trie.search("somestring"));

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");