package org.rosemwal.dsa.trie;

public class InsertSearchTrie {

    static class Node   {

        Node[] links = new Node[26];
        boolean flag = false;

        public Node()   {

        }

        boolean containsKey(char ch)    {
            return links[ch -'a'] != null;
        }

        Node get(char ch)    {
            return links[ch-'a'];
        }

        void put(char ch, Node node)   {
            links[ch-'a'] = node;
        }

        void setEnd()   {
            flag = true;
        }
    }

    static Node root;

    static class Trie   {


        static void insert(String str) {
            Node node = root;

            char[] chars = str.toCharArray();

            for(int i=0; i<chars.length; i++)   {

                if(!node.containsKey(chars[i])) {
                    node.put(chars[i], new Node());
                }
                node = node.get(chars[i]);
            }
            node.setEnd();
        }

        static boolean search(String word) {
            Node node = root;

            for(int i=0; i<word.length(); i++)  {
                if(!node.containsKey(word.charAt(i)))   {
                    return false;
                }
                node = node.get(word.charAt(i));
            }

            if(node.flag)   {
                return true;
            }
            return false;
        }

        static boolean startsWith(String word) {
            Node node = root;

            for(int i=0; i<word.length(); i++)  {
                if(!node.containsKey(word.charAt(i)))   {
                    return false;
                }
                node = node.get(word.charAt(i));
            }

            return true;
        }
    }

    public static void main(String[] args)  {

        root = new Node();
        String str1 = "apple";
        String str2 = "apps";
        String str3 = "apnl";
        String str4 = "bac";
        String str5 = "bat";

        Trie.insert(str1);
        Trie.insert(str2);
        Trie.insert(str3);
        Trie.insert(str4);
        Trie.insert(str5);

        System.out.println("Searching app " + Trie.search("app"));
        System.out.println("Searching apps " + Trie.search("apps"));
        System.out.println("Searching bac " + Trie.search("bac"));
        System.out.println("Searching bacs " + Trie.search("bacs"));
        System.out.println("Searching ba " + Trie.search("ba"));


        System.out.println("Startswith ba " + Trie.startsWith("ba"));
        System.out.println("Startswith bax " + Trie.startsWith("ba"));

    }
}
