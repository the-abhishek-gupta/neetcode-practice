class WordDictionary {
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        Trie node = trie;
        for (char c : word.toCharArray()){
            if (node.children[c-'a'] == null)
                node.children[c-'a'] = new Trie();
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchDFS(word, trie, 0);
    }
    private boolean searchDFS(String word, Trie node, int index){
        if (node == null)
            return false;
        if (index == word.length())
            return node.isEnd;

        char c = word.charAt(index);
        if (c == '.'){
            for (Trie child : node.children){
                if (child != null && searchDFS(word, child, index+1))
                    return true;
            }
            return false;
        }
        else{
            return searchDFS(word, node.children[c-'a'], index+1);
        }
    }
}
class Trie{
    Trie[] children;
    boolean isEnd;
    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }
}
