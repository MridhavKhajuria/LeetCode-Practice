class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean exists = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        word = word.toLowerCase();
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.exists = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode root){
        if (index == word.length()) return root.exists;

        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode child : root.children){
                if(child != null && dfs(word, index + 1, child)){
                    return true;
                }
            }
            return false;
        }
         else{
        int i = c - 'a';
        if(root.children[i] == null) return false;
        return dfs(word, index + 1, root.children[i]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */