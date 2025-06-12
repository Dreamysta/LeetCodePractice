public class LeetCode208 {
    static class Trie {
        // 定义内部类 TrieNode，用于表示前缀树的节点
        private class TrieNode {
            // 每个节点最多有26个子节点（对应小写字母 a-z）
            TrieNode[] children = new TrieNode[26];
            // 表示该节点是否是某个单词的结尾
            boolean isEndofWord = false;
        }

        // Trie 的根节点，初始化时是空的
        private TrieNode root;

        // 构造函数，初始化 Trie 对象
        public Trie() {
            root = new TrieNode(); // 创建根节点
        }

        // 向 Trie 中插入一个字符串 word
        public void insert(String word) {
            TrieNode node = root;  // 从根节点开始
            for (char ch : word.toCharArray()) {  // 遍历单词中的每个字符
                int index = ch - 'a';  // 计算字符在数组中的索引（0~25）
                if (node.children[index] == null) {
                    // 如果对应子节点不存在，就新建一个
                    node.children[index] = new TrieNode();
                }
                // 向下移动到子节点
                node = node.children[index];
            }
            // 单词插入完毕，标记当前节点为单词结束节点
            node.isEndofWord = true;
        }

        // 查找某个单词是否在 Trie 中完全存在
        public boolean search(String word) {
            TrieNode node = searchPrefix(word); // 尝试查找整个单词的路径
            // 返回：路径存在且最后一个节点是单词结尾
            return node != null && node.isEndofWord;
        }

        // 判断 Trie 中是否存在以 prefix 开头的单词
        public boolean startsWith(String prefix) {
            // 返回前缀路径是否存在（不需要是完整单词）
            return searchPrefix(prefix) != null;
        }

        // 私有辅助方法：查找某个字符串对应的最后一个节点
        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;  //从根节点开始
            for (char ch : prefix.toCharArray()) {  //遍历每个字符
                int index = ch - 'a';  // 计算字符索引
                if (node.children[index] == null) {
                    // 如果路径中断，前缀不存在
                    return null;
                }
                node = node.children[index];  // 继续向下查找
            }
            // 返回最后一个匹配的节点
            return node;
        }
    }

    // 主函数，测试 Trie
    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true

        trie.insert("app");
        System.out.println(trie.search("app"));     // true


    }
}













