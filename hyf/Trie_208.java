package waitsolve;

import datastruct.TrieNode;

public class Trie_208 {
    private TrieNode root = new TrieNode('/');
    public void insert(String word){
        TrieNode currentNode = root;
        int strLen = word.length();
        for(int i = 0;i < strLen;i++){
            if(currentNode.getChild(word.charAt(i)) == null){
                currentNode.setChild(word.charAt(i));
            }
            currentNode = currentNode.getChild(word.charAt(i));
        }
        currentNode.setEndNode(true);
    }

    public boolean find(String word){
        TrieNode currentNode = root;
        int strLen = word.length();
        int i = 0;
        for(;i < strLen;i++){
            if(currentNode.getChild(word.charAt(i)) == null){
                break;
            }
            currentNode = currentNode.getChild(word.charAt(i));
        }
        return i == strLen && currentNode.isEndNode();
    }

    public boolean startWith(String prefix){
        TrieNode currentNode = root;
        int strLen = prefix.length();
        for(int i = 0;i < strLen;i++){
            if(currentNode.getChild(prefix.charAt(i)) == null){
                return false;
            }
            currentNode = currentNode.getChild(prefix.charAt(i));
        }
        return true;
    }
}
