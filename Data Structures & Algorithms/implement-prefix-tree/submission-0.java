class PrefixTree {

    Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie node = root;
        for (char ch : word.toCharArray()){
            int pos = ch-'a';
            if (node.children[pos] == null)
                node.children[pos] = new Trie();
            node = node.children[pos];
        }
        node.end = true;
    }

    public boolean search(String word) {
        Trie node = root;
        for (char ch : word.toCharArray()){
            int pos = ch - 'a';
            if (node.children[pos] == null)
                return false;
            node = node.children[pos];
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        Trie node = root;
        for (char ch : prefix.toCharArray()){
            int pos = ch - 'a';
            if (node.children[pos] == null)
                return false;
            node = node.children[pos];
        }
        return true;
    }
}

class Trie{
    Trie[] children = new Trie[26];
    boolean end = false;
}
