import java.util.Stack;

class MyQueue {

    Stack<Integer> stackForPush = new Stack<Integer>();
    Stack<Integer> stackForPop = new Stack<Integer>();


    // Push element x to the back of queue.
    public void push(int x) {
        stackForPush.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stackForPush.isEmpty() && stackForPop.isEmpty()) {
            return;
        } else if (!stackForPop.isEmpty()) {
            stackForPop.pop();
        } else if (!stackForPush.isEmpty()) {
            while (!stackForPush.isEmpty()) {
                stackForPop.push(stackForPush.pop());
            }
            stackForPop.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (stackForPush.isEmpty() && stackForPop.isEmpty()) {
            return -1;
        } else if (!stackForPop.isEmpty()) {
            return stackForPop.peek();
        } else if (!stackForPush.isEmpty()) {
            while (!stackForPush.isEmpty()) {
                stackForPop.push(stackForPush.pop());
            }
            return stackForPop.peek();
        }
        return -1;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stackForPush.isEmpty() && stackForPop.isEmpty());
    }


}