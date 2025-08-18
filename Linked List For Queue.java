class QueueArray {

    private int top;
    private LinkedList head;

    QueueArray() {
        this.top = 0;
        this.head = null;
    }

    void push(int value) {

        if (top == 0) {
            this.head = new LinkedList(value);
        } else {
            LinkedList tempObj = new LinkedList(value);

            LinkedList current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = tempObj;

        }

        this.top++;

    }

    void pop() {

        if (isEmpty()) {
            System.out.println("List is already empty");
            return;
        }

        head = head.next;

        this.top--;

    }

    int sizeOfArray() {
        return this.top;
    }

    boolean isEmpty() {
        return this.top <= 0;
    }

    void poll() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Polling: " + peek());
        pop();
    }

    void printArray() {

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("[");

        LinkedList currentObj = head;

        while (currentObj != null) {
            System.out.print(currentObj.data + ", ");

            currentObj = currentObj.next;
        }

        System.out.println(isEmpty() ? "List is Empty]" : "\b\b]");
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

    int indexOf(int value) {

        LinkedList currentObj = head;
        int index = 0;

        while (currentObj != null) {

            if (currentObj.data == value) {
                return index;
            }

            currentObj = currentObj.next;
            index++;
        }

        return -1;

    }

    boolean contains(int value) {

        return indexOf(value) != -1;

    }

    void clear() {
        this.head = null;
        this.top = 0;
        System.out.println("List cleared");
    }


}

class LinkedList {

    int data;
    LinkedList next;

    LinkedList(int data) {
        this.data = data;
        this.next = null;
    }
}