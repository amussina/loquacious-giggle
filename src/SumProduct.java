import java.util.Stack;

public class SumProduct {

    public static int calc(String s) {
       Stack<Integer> stack = new Stack<Integer>();

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c != '+' &&  c!= '*') {
                int val = Character.getNumericValue(c);
                stack.push(val);
            } else {
                if (c == '*') {
                    int mult = stack.pop() * stack.pop();
                    stack.push(mult);
                } else if (c=='+'){
                    int sum = stack.pop() + stack.pop();
                    stack.push(sum);
                }
            }
        }
        return stack.pop();
    }

    private static  int getPriority(char c) {
        if (c=='*') {
            return 1;
        }
        return 0;
    }

    public static  String toReversePolishNotation(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '+' &&  c!= '*') {

                sb.append(c);
            } else {

                if (stack.isEmpty()) {
                    stack.push(c);
                } else {

                    while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                        sb.append(stack.pop());

                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "1+9*2+7+8+1*3";
        String postFix = toReversePolishNotation(str);
        System.out.println(str);
        System.out.println(postFix);
        System.out.println(calc(postFix));
    }
}
