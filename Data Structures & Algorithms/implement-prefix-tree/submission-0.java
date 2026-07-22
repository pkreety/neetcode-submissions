class Trie{
  HashMap<Character, Trie> childrens;
  char c;
  boolean isWord;

  Trie(){

     isWord = false;
    childrens = new HashMap<>();
  }

  Trie(char c) {
    this.c = c;
    isWord = false;
    childrens = new HashMap<>();
  }

}

class PrefixTree {
    Trie root;


    public PrefixTree() {
        root = new Trie();
         
    }

    public void insert(String word) {
        Trie current = root;
        for(char c: word.toCharArray()){
            if(current.childrens.containsKey(c)){
                current = current.childrens.get(c);
            } else {
                current.childrens.put(c, new Trie(c));
                current = current.childrens.get(c);
            }
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        Trie current = root;
        for(char c: word.toCharArray()){
                if(!current.childrens.containsKey(c)){
                    return false;
                } else {
                    current = current.childrens.get(c);
                }
            }

        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie current = root;
        for(char c: prefix.toCharArray()){
                if(!current.childrens.containsKey(c)){
                    return false;
                } else {
                    current = current.childrens.get(c);
                }
            }

        return true;
    }
}
