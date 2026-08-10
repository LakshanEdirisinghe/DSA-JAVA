class ListArray {

    private int top;
    private DataObjet head;

    ListArray() {
        top = 0;
        head = null;
    }

    void addLast(int value) {

        if (top == 0) {
            head = new DataObjet(value);
        } else {
            DataObjet tempObj = new DataObjet(value);

            DataObjet current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = tempObj;

        }

        top++;

    }
    void addFirst(int value) {

        DataObjet tempObj = new DataObjet(value);

        if (isEmpty()) {
            head = tempObj;
        } else {
            tempObj.next = head;
            head = tempObj;
        }

        top++;

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

        DataObjet temp = new DataObjet(value);

        DataObjet current = head;
        int turn = 0;

        while (turn < index - 2) {
            current = current.next;

            turn++;
        }

        temp.next = current.next;
        current.next = temp;

        top++;
    }

    void removeFirst() {

        if (isEmpty()) {
            System.out.println("List is already empty");
            return;
        }

        head = head.next;

        top--;

    }
    int get(int index) {

        if (index < 0 || index >= top) {
            System.out.println("Invalid index");
            return -1;
        }
        DataObjet current = head;
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

        DataObjet current = head;
        int turn = 0;

        while (turn < index - 2) {
            current = current.next;

            turn++;
        }
        
        current.next=current.next.next;
        
        // current.next;
        // System.out.println(current.data);

        top--;

    }

    int sizeOfArray() {
        return top;
    }

    boolean isEmpty() {
        return top <= 0;
    }

    void printList() {

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("[");

        DataObjet currentObj = head;

        while (currentObj != null) {
            System.out.print(currentObj.data + ", ");

            currentObj = currentObj.next;
        }

        System.out.println(isEmpty() ? "List is Empty]" : "\b\b]");
    }

    int indexOf(int value) {

        DataObjet currentObj = head;
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
        head = null;
        top = 0;
        System.out.println("List cleared");
    }
    // 5->10->15->20->25->30->null;

    void temp() {

    }

}

class DataObjet {

    int data;
    DataObjet next;

    DataObjet(int data) {
        this.data = data;
        next = null;
    }
}