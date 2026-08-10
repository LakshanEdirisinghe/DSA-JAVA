class QueueArray {

    private int arr[];
    private int frontPoint;
    private int rearPoint;
    private int maxSize;
    private int nItems;

    QueueArray(int pSize) {

        maxSize = pSize;
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

        if (isEmpty()) {
            frontPoint = 0;
        }

        arr[++rearPoint] = value;
        nItems++;

    }

    void Remove() {

        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return;

        }

        frontPoint++;
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

        for (int i = frontPoint; i <= rearPoint; i++) {
            System.out.print(arr[i]);

            if (i < rearPoint) {
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