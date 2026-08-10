// Stack
// ####################################################################################

class StackArray {

    private int arr[];
    private int topPoint;
    private int maxSize;

    StackArray(int pSize) {
        maxSize = pSize;
        arr = new int[maxSize];
        topPoint = -1;

    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            arr[++topPoint] = value;
        }

    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack is already empty");
            return;
        }
        topPoint--;

    }

    boolean isEmpty() {
        return (topPoint == -1);
    }

    boolean isFull() {
        return (topPoint == maxSize - 1);
    }

    void displayStack() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.print("[");

        for (int i = topPoint; i >= 0; i--) {
            System.out.print(arr[i]);

            if (i > 0) {
                System.out.print(",");
            }
        }

        System.out.println("]");

    }

    void findIndex(int value) {

        for (int i = topPoint; i >= 0; i--) {

            if (arr[i] == value) {
                System.out.println("Index of " + value + ": " + (topPoint - i));
                return;
            }

        }

        System.out.println("This value does not exist");
    }

    boolean contains(int value) {
        for (int i = 0; i <= topPoint; i++) {

            if (arr[i] == value) {
                return true;
            }
        }

        return false;
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Top data: " + arr[topPoint]);
    }

    void sizeOf() {
        System.out.println("Stack Size: " + (topPoint + 1));
    }

    void poll() {
        peek();
        pop();
    }

    void clear() {

        arr = new int[maxSize];
        topPoint = -1;

    }

}