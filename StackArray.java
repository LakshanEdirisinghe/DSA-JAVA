// Stack
// ####################################################################################

class StackArray {

    private int arr[];
    private int topPoint;
    private double loadFactor;
    private int initiateSizeOfArr;

    StackArray(int pSize, double pLoadFactor) {
        this.initiateSizeOfArr = pSize;
        this.arr = new int[initiateSizeOfArr];
        this.loadFactor = pLoadFactor;
        this.topPoint = 0;

    }

    void push(int value) {

        if (this.topPoint >= this.arr.length) {

            int[] tempArray = new int[(int) (this.arr.length + (this.initiateSizeOfArr *
                    this.loadFactor))];

            for (int i = 0; i < this.arr.length; i++) {
                tempArray[i] = arr[i];
            }
            this.arr = tempArray;

        }
        this.arr[topPoint++] = value;

    }

    void pop() {

        if (isEmpty()) {
            System.out.println("Stack is already empty");
            return;
        }

        if (this.topPoint - 1 <= (arr.length - ((int) (this.initiateSizeOfArr *
                this.loadFactor)))) {

            int[] tempArray = new int[arr.length - ((int) (this.initiateSizeOfArr *
                    this.loadFactor))];

            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = arr[i];
            }

            arr = tempArray;

        }

        this.topPoint--;

    }

    boolean isEmpty() {
        return topPoint <= 0;
    }

    void displayArray() {

        // here is displayed real Array
        final int arrg[] = this.arr;
        final int sizeOfArry = this.arr.length;

        System.out.print("[");
        for (int i = 0; i < sizeOfArry; i++) {
            System.out.print(arrg[i] + ",");
        }
        System.out.println("\b]");
    }

    void displayArrayAdvance() {

        System.out.print("[");

        for (int i = this.topPoint; i > 0; i--) {
            System.out.print(arr[i - 1] + ",");
        }

        System.out.println(isEmpty() ? "Stack is Empty]" : "\b]");

    }

    void indexOf(int value) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                System.out.println("Index of " + value + ": " + (arr.length - 1 - i));
                return;
            }
            // System.out.println(arr.length-1-i);

        }

        System.out.println("This value does not exist");
    }

    void contains(int value) {
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                System.out.println("Contains " + value + ": " + true);
                return;
            }
        }
        System.out.println("This value does not exist");

    }

    void peek() {
        System.out.println("Top data: " + arr[this.topPoint - 1]);
    }

    void sizeOf() {
        System.out.println("Stck Size: " + this.topPoint);
    }

    void poll() {
        this.peek();
        this.pop();
    }

    void clear() {

        this.arr = new int[initiateSizeOfArr];
        this.topPoint = 0;

    }

    void copy() {
        // purpose of this method was not sized up, therefor it is not devaloped
    }

}