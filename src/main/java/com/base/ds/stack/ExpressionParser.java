package com.base.ds.stack;

import static com.base.utils.InputUtil.sysout;

public class ExpressionParser {

    public static void main(String[] args) {
        // String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String exp = "2^(3+4)+3*(1+3)/2-9";
        String postfix = infixToPostfix(exp);
        String prefix = infixToPrefix(exp);
        sysout(String.format("\ninfix  => %s = %d", exp, 125));
        sysout(String.format("postfix=> %s = %d", postfix, evaluatePostfix(postfix)));
        sysout(String.format("prefix => %s = %d", prefix, evaluatePrefix(prefix)));

        // infixToPostfix("((H*((((A+((B+C)*D))*F)*G)*E))+J)");
        // infixToPrefix("((H*((((A+((B+C)*D))*F)*G)*E))+J)");
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
            default:
                return -1;
        }
    }

    static Integer operate(int o1, int o2, char operator) {
        switch (operator) {
            case '+':
                return o1 + o2;
            case '-':
                return o1 - o2;
            case '*':
                return o1 * o2;
            case '/':
                return o1 / o2;
            case '^':
                return (int) Math.pow(o1, o2);
            default:
                return null;
        }
    }

    public static String infixToPostfix(String expr) {
        assert expr != null;
        StringBuilder builder = new StringBuilder("");
        Stack<Character> stack = new Stack<Character>();
        for (Character chr : expr.toCharArray()) {
            if (Character.isLetterOrDigit(chr)) {
                builder.append(chr);
            } else if (chr == '(') {
                stack.push(chr);
            } else if (chr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                stack.pop();
            } else {
                int chrPrec = precedence(chr);
                while (!stack.isEmpty() && precedence(stack.peek()) >= chrPrec) {
                    builder.append(stack.pop());
                }
                stack.push(chr);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Bad expresion";
            }
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public static String infixToPrefix(String expr) {
        assert expr != null;
        StringBuilder builder = new StringBuilder();
        for (int i = expr.length() - 1; i > -1; i--) {
            char chr = expr.charAt(i);
            chr = chr == ')' ? '(' : chr == '(' ? ')' : chr;
            builder.append(chr);
        }
        String postfix = infixToPostfix(builder.toString());
        builder.setLength(0);
        builder.append(postfix).reverse();
        return builder.toString();
    }

    static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        for (Character chr : expr.toCharArray()) {
            if (Character.isDigit(chr)) {
                stack.push(Character.getNumericValue(chr));
            } else {
                // first one that comes out is the second operand
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(operate(o2, o1, chr));
            }
        }

        return stack.pop();
    }

    static int evaluatePrefix(String expr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = expr.length() - 1; i > -1; i--) {
            char chr = expr.charAt(i);
            if (Character.isDigit(chr)) {
                stack.push(Character.getNumericValue(chr));
            } else {
                // first one that comes out is the second operand
                stack.push(operate(stack.pop(), stack.pop(), chr));
            }
        }
        return stack.pop();
    }
}
