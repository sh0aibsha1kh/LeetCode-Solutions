import java.util.Stack;

class Solution {
    /**
     * Returns true if the string contains valid parenthesis.
     * 
     * Use a stack to record complementary bracket pairs. If something doesn't match
     * up while popping from the stack, return false. At the end, return true if the
     * stack is empty; which means the string must contain a valid ordering of
     * parentheses.
     * 
     * Time complexity: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()")); // true
        System.out.println(s.isValid("()[]{}")); // true
        System.out.println(s.isValid("(]")); // false
        System.out.println(s.isValid("([)]")); // false
        System.out.println(s.isValid("{[]}")); // true
    }
}