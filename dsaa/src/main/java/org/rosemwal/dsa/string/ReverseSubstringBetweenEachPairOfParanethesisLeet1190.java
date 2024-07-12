package org.rosemwal.dsa.string;

import java.util.Stack;

//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/?envType=daily-question&envId=2024-07-11
public class ReverseSubstringBetweenEachPairOfParanethesisLeet1190 {

    public static void main(String[] args)  {

        System.out.println(reverseParentheses("(u(love)i)"));
    }

    public static String reverseParentheses(String s) {

        String res = "";
        char[] chArray = s.toCharArray();
        Stack<Character> st = new Stack<Character>();

        for (int i=0;i<chArray.length; i++)   {

            if (chArray[i] ==')')   {
                reverseString(st);
            }   else    {
                st.push(chArray[i]);
            }
        }

        while(!st.isEmpty()) {
            res=Character.toString(st.pop())+res;
        }
        return res;
    }

    public static void reverseString(Stack<Character> st)  {

        String str = "";

        while(!st.isEmpty() && st.peek() != '(')    {
            str+=Character.toString(st.pop());
        }

        if (st.peek() == '(')   {
            st.pop();
        }

        System.out.println(str);

        for (int i=0; i<str.length(); i++)    {
            st.push(str.charAt(i));
        }
    }
}
