class ListArray {

    private int top;
    private LinkedList head;

    ListArray() {
        this.top = 0;
        this.head = null;
    }

    void addLast(int value) {

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
    void addFirst(int value) {

        LinkedList tempObj = new LinkedList(value);

        if (isEmpty()) {
            this.head = tempObj;
        } else {
            tempObj.next = this.head;
            this.head = tempObj;
        }

        this.top++;

    }

    void add(int index, int value) {
        if (index < 0 || index > top) {
            System.out.println("Invalid index");
            return;
        }
        if (index == top) {
            addLast(value);
            return;
        }
        if (index == 0) {
            addFirst(value);
            return;
        }

        LinkedList temp = new LinkedList(value);

        LinkedList current = this.head;
        int turn = 0;

        while (turn < index - 2) {
            current = current.next;

            turn++;
        }

        temp.next = current.next;
        current.next = temp;

        this.top++;
    }

    void removeFirst() {

        if (isEmpty()) {
            System.out.println("List is already empty");
            return;
        }

        head = head.next;

        this.top--;

    }
    int get(int index) {

        if (index < 0 || index >= top) {
            System.out.println("Invalid index");
            return -1;
        }
        LinkedList current = this.head;
        int turn = 0;

        while (turn < index) {
            current = current.next;
            turn++;
        }

        return current.data;

    }

    void remove(int index) {

        if (index < 0 || index >= top) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        LinkedList current = this.head;
        int turn = 0;

        while (turn < index - 2) {
            current = current.next;

            turn++;
        }
        
        current.next=current.next.next;
        
        // current.next;
        // System.out.println(current.data);

        this.top--;

    }

    int sizeOfArray() {
        return this.top;
    }

    boolean isEmpty() {
        return this.top <= 0;
    }

    void printList() {

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
    // 5->10->15->20->25->30->null;

    void temp() {

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