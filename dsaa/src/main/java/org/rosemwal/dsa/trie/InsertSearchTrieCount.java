package org.rosemwal.dsa.trie;

    class Node   {

        Node[] links = new Node[26];

        int currentPrefix=0;
        int currentEndsWith=0;

        Node()  {

        }

        boolean containsKey(char ch)    {
            return links[ch-'a'] != null;
        }

        Node get(char ch)    {
            return links[ch-'a'];
        }

        void put(char ch, Node node)    {
            links[ch-'a'] = node;
        }

        void increaseNodeEnd()   {
            currentEndsWith +=1;
        }

        void increaseNodePrefix()   {
            this.currentPrefix+=1;
        }

        int getEnd()   {
            return currentEndsWith;
        }

        int getCurrentPrefix()   {
            return currentPrefix;
        }
    }

class Trie   {

        Node root;

        Trie()  {
            root = new Node();
        }

        void insert(String str) {

            Node node = root;
            for (int i=0; i<str.length(); i++)   {

                if(!node.containsKey(str.charAt(i)))    {
                    node.put(str.charAt(i), new Node());
                }
                node = node.get(str.charAt(i));
                node.increaseNodePrefix();
            }
            node.increaseNodeEnd();
        }

        int countWordsEqualsTo(String str) {

            Node node = root;
            for (int i=0; i<str.length(); i++)   {
                if (!node.containsKey(str.charAt(i)))    {
                    return 0;
                }
                node = node.get(str.charAt(i));
            }

            return node.getEnd();
        }

        int countWordsStartingWith(String str) {

            Node node = root;
            for (int i=0; i<str.length(); i++)   {
                if (!node.containsKey(str.charAt(i)))    {
                    return 0;
                }
                node = node.get(str.charAt(i));
            }

            return node.getCurrentPrefix();
        }


    public static void main(String[] args)  {

        Trie trie = new Trie();
        String str1 = "apple";
        String str2 = "apps";
        String str3 = "apnl";
        String str4 = "bac";
        String str5 = "bat";

        trie.insert(str1);
        trie.insert(str2);
        trie.insert(str3);
        trie.insert(str1);
        trie.insert(str4);
        trie.insert(str5);
        trie.insert(str1);

        System.out.println("Counting words equal to apple " + trie.countWordsEqualsTo("apple"));
        System.out.println("Counting words equal to applea " + trie.countWordsEqualsTo("appla"));
        System.out.println("Counting words starting with app " + trie.countWordsStartingWith("app"));
        System.out.println("Counting words equal to bat " + trie.countWordsEqualsTo("bat"));
        System.out.println("Counting words starting with ba " + trie.countWordsStartingWith("ba"));
    }
}
