package lesson3;


import lesson3.queue.Queue;
import lesson3.stack.Stack;
import lesson4.LinkedDeque;
import lesson4.LinkedListStack;
import lesson4.deque.Deque;

public class Test3 {

    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static void testStack() {

//        Stack<Integer> stack = new StackImpl<>(4);
        Stack<Integer> stack = new LinkedListStack<>();

        System.out.println(stack.push(12));
        System.out.println(stack.push(16));
        System.out.println(stack.push(22));
        System.out.println(stack.push(5));
        System.out.println(stack.push(1));
        System.out.println(stack.push(32));

        stack.display();

        System.out.println("top value: " + stack.pop());
        System.out.println("top value: " + stack.peek());
        stack.display();
    }

    private static void testQueue() {

        Deque<Integer> queue = new LinkedDeque<>();

        System.out.println("add element: " + queue.insertLeft(34));
        System.out.println("add element: " + queue.insertLeft(12));
        System.out.println("add element: " + queue.insertLeft(20));
        System.out.println("add element: " + queue.insertLeft(16));
        System.out.println("add element: " + queue.insertLeft(14));
        System.out.println("add element: " + queue.insertLeft(17));
        System.out.println("add element: " + queue.insertRight(55));
        System.out.println("add element: " + queue.insertRight(66));


        queue.display();
        System.out.println("remove: " + queue.removeLeft());
        System.out.println("remove: " + queue.removeRight());
        queue.display();


    }

}
