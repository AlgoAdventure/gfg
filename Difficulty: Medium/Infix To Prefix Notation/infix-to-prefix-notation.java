import java.util.*;

class Solution {
    
    public String infixToPrefix(String s) {
        // Reverse the infix expression
        StringBuilder input = new StringBuilder(s);
        input.reverse();

        // Replace ( with ) and vice versa
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                input.setCharAt(i, ')');
            } else if (c == ')') {
                input.setCharAt(i, '(');
            }
        }

        // Convert to postfix
        String postfix = toPostfix(input.toString());

        // Reverse postfix to get prefix
        return new StringBuilder(postfix).reverse().toString();
    }

    private String toPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop(); // remove '('
            } else { // operator
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    result.append(stack.pop());
                }

                while (!stack.isEmpty() && precedence(c) == precedence(stack.peek()) && !isRightAssociative(c)) {
                    result.append(stack.pop());
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private int precedence(char c) {
        switch (c) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default: return -1;
        }
    }

    private boolean isRightAssociative(char c) {
        return c == '^';
    }
}
