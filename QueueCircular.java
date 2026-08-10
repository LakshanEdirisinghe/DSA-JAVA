public class QueueCircular {

    private int arr[];
    private int frontPoint;
    private int rearPoint;
    private int maxSize;
    private int nItems;

    QueueCircular(int size) {
        maxSize = size;
        arr = new int[maxSize];
        frontPoint = -1;
        rearPoint = -1;
        nItems = 0;
    }

    void Insert(int value) {

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        // First element
        if (isEmpty()) {
            frontPoint = 0;
            rearPoint = 0;
        } else {

            // Move rear circularly
            if (rearPoint == maxSize - 1) {
                rearPoint = 0;
            } else {
                rearPoint++;
            }
        }

        arr[rearPoint] = value;
        nItems++;
    }

    void Remove() {

        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return;
        }

        // Removing the last element
        if (nItems == 1) {
            frontPoint = -1;
            rearPoint = -1;
            nItems = 0;
            return;
        }

        // Move front circularly
        if (frontPoint == maxSize - 1) {
            frontPoint = 0;
        } else {
            frontPoint++;
        }

        nItems--;
    }

    void Peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Front data: " + arr[frontPoint]);
    }

    void Display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("[");

        for (int i = 0; i < nItems; i++) {
            int index = frontPoint + i;

            if (index >= maxSize) {
                index -= maxSize;
            }

            System.out.print(arr[index]);

            if (i < nItems - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    boolean isEmpty() {
        return (nItems == 0);
    }

    boolean isFull() {
        return (nItems == maxSize);
    }

}
