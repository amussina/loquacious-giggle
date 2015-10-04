class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean isEndOfString;
    TrieNode [] child;

    public TrieNode() {
        child = new TrieNode[26];
    }
}

public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        addWordHelper(root, word, 0);
    }

    private void addWordHelper(TrieNode cur, String word, int i) {
        char charToInsert = word.charAt(i);
        TrieNode next;

        if (cur.child[charToInsert - 'a'] == null) {
            // add
            next = new TrieNode();
            next.val = charToInsert;
            cur.child[charToInsert - 'a'] = next;
        } else {
            // use current node
            next = cur.child[charToInsert - 'a'];
        }

        // check if end of word
        if (i == word.length() -1) {
            next.isEndOfString = true;
        } else {
            // keep adding chars
            addWordHelper(next, word, i+1);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        return searchForWordOrPattern(root, word, 0);
    }

    private boolean searchHelper(TrieNode cur, String word, int i) {
        if (cur == null) {
            return false;
        }
        char searchedChar = word.charAt(i);
        if (cur.val != searchedChar && searchedChar != '.') {
            return false;
        }

        if (i == word.length() - 1) {
            return cur.isEndOfString;
        } else {
            return searchForWordOrPattern(cur, word, i + 1);
        }
    }

    private boolean searchForWordOrPattern(TrieNode cur, String word, int i) {

        if (i == word.length()) {
            return false;
        }

        char routingChar = word.charAt(i);

        if (cur == null) {
            return false;
        }



        if (routingChar == '.') {
            for (int j=0;j<26;j++) {
                if (searchHelper(cur.child[j], word, i)) {
                    return true;
                }
            }
            return false;
        } else {
            return searchHelper(cur.child[routingChar - 'a'], word, i);
        }
    }

    public static void  main(String [] args) {
        // Your Trie object will be instantiated and called as such:
        WordDictionary dic = new WordDictionary();
        dic.addWord("dad");
        System.out.println("search for \"dad\": " + dic.search("dad"));
        System.out.println("search for \"d.d\": " + dic.search("d.d"));

    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");