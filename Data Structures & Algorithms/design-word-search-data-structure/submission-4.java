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
        return dfs(trie, word, 0);
    }
    public boolean dfs(Trie node, String word, int index){
        if (index == word.length())
            return node.isEnd;
        char c = word.charAt(index);
        boolean flag = false;
        if (c != '.'){
            if (node.children[c-'a'] == null)
                return false;
            node = node.children[c-'a'];
            flag = dfs(node, word, index+1);
        }
        else{
            for (char ch = 'a'; ch <= 'z'; ch++){
                if (node.children[ch-'a'] != null){
                    Trie child = node.children[ch-'a'];
                    if (child != null)
                        flag = flag || dfs(child, word, index+1);
                }
            }
        }
        
        return flag;
    }
}
class Trie{
    Trie[] children;
    boolean isEnd;
    Trie(){
        children = new Trie[26];
        isEnd = false;
    }
}
