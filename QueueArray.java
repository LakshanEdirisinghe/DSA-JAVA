class QueueArray {

    private int arr[];
    private int frontPoint;
    private int rearPoint;
    private int size;
    private double loadFactor;
    private int initiateSizeOfArr;

    QueueArray(int pSize) {
        this.initiateSizeOfArr = pSize;
        this.arr = new int[initiateSizeOfArr];
        this.loadFactor = pSize;
        this.frontPoint = 0;
        this.rearPoint = 0;
        this.size = 0;

    }

    void Insert(int value) {
        if (this.size >= this.arr.length) {
            int growth = (int) (this.initiateSizeOfArr * this.loadFactor);

            if (growth <= 0) {
                growth = 1;
            }

            int newCapacity = this.arr.length + growth;
            int[] tempArray = new int[newCapacity];

            for (int i = 0; i < this.size; i++) {
                tempArray[i] = this.arr[(this.frontPoint + i) % this.arr.length];
            }

            this.arr = tempArray;
            this.frontPoint = 0;
            this.rearPoint = this.size;
        }

        this.arr[this.rearPoint] = value;
        this.rearPoint = (this.rearPoint + 1) % this.arr.length;
        this.size++;

    }

    void Remove() {

        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return;
        }

        this.arr[this.frontPoint] = 0;
        this.frontPoint = (this.frontPoint + 1) % this.arr.length;
        this.size--;

        if (this.size == 0) {
            this.frontPoint = 0;
            this.rearPoint = 0;
        }
    }

    void Peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Front data: " + this.arr[this.frontPoint]);
    }

    void Display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("[");

        for (int i = 0; i < this.size; i++) {
            System.out.print(this.arr[(this.frontPoint + i) % this.arr.length]);

            if (i < this.size - 1) {
                System.out.print(",");
            }
        }

        System.out.println("]");
    }

    boolean isEmpty() {
        return this.size <= 0;
    }

}