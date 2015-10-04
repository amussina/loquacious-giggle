import java.util.LinkedList;

class MyStack {

    LinkedList<Integer> q1 = new LinkedList<Integer>();
    LinkedList<Integer> q2 = new LinkedList<Integer>();

    LinkedList<Integer> mainQ = q1;
    LinkedList<Integer> secQ = q2;

    // Push element x onto stack.
    public void push(int x) {
        mainQ.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (mainQ.isEmpty() && secQ.isEmpty()) {
            return;
        }

        if (mainQ.isEmpty() && !secQ.isEmpty()) {
            swap();
        }

        if (mainQ.size() == 1) {
            mainQ.pop();

            if (!secQ.isEmpty()) {
                swap();
            }
        } else if (mainQ.size() > 1) {
            int sizeMain = mainQ.size();

            for (int i = 0; i < sizeMain - 1; i++) {
                secQ.add(mainQ.remove());
            }
            mainQ.remove();

            swap();
        }
    }

    private void swap() {
        LinkedList<Integer> tmp = mainQ;
        mainQ = secQ;
        secQ = tmp;
    }

    // Get the top element.
    public int top() {
        if (mainQ.isEmpty() && secQ.isEmpty()) {
            return -1;
        }
        if (mainQ.isEmpty() && !secQ.isEmpty()) {
            swap();
        }
        if (mainQ.size() == 1) {
            return mainQ.peek();
        } else if (mainQ.size() > 1) {
            int sizeMain = mainQ.size();

            for (int i = 0; i < sizeMain - 1; i++) {
                secQ.add(mainQ.remove());
            }
            return mainQ.peek();
        }
        return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return mainQ.isEmpty() && secQ.isEmpty();
    }

    public static void main(String [] args) {

        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        int top = myStack.top();
        System.out.print(top);

        myStack.push(3);
        myStack.push(4);

        top = myStack.top();
        System.out.print(top);

        myStack.push(5);
        top = myStack.top();
        System.out.print(top);

        myStack.pop();

        top = myStack.top();
        System.out.print(top);

    }
}