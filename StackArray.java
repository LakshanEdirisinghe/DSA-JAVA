// Stack
// ####################################################################################

class StackArray {

    private int arr[];
    private int topPoint;
    private int loadFactor;
    private int initiateSizeOfArr;

    StackArray(int pSize) {
        initiateSizeOfArr = pSize;
        arr = new int[initiateSizeOfArr];
        loadFactor = pSize;
        topPoint = 0;

    }

    void push(int value) {

        if (topPoint >= arr.length) {

            int[] tempArray = new int[arr.length + loadFactor];

            for (int i = 0; i < arr.length; i++) {
                tempArray[i] = arr[i];
            }
            arr = tempArray;

        }
        arr[topPoint++] = value;

    }

    void pop() {

        if (isEmpty()) {
            System.out.println("Stack is already empty");
            return;
        }

        topPoint--;

        if (topPoint - 1 <= (arr.length - loadFactor)) {

            int[] tempArray = new int[arr.length - loadFactor];

            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = arr[i];
            }

            arr = tempArray;

        }

    }

    boolean isEmpty() {
        return topPoint <= 0;
    }

    void displayArray() {

        // here is displayed real Array
        final int arrg[] = arr;
        final int sizeOfArry = arr.length;

        System.out.print("[");
        for (int i = 0; i < sizeOfArry; i++) {
            System.out.print(arrg[i] + ",");
        }
        System.out.println("\b]");
    }

    void displayArrayAdvance() {

        System.out.print("[");

        for (int i = topPoint; i > 0; i--) {
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
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.println("Top data: " + arr[topPoint - 1]);
    }

    void sizeOf() {
        System.out.println("Stck Size: " + topPoint);
    }

    void poll() {
        peek();
        pop();
    }

    void clear() {

        arr = new int[initiateSizeOfArr];
        topPoint = 0;

    }

    void copy() {
        // purpose of this method was not sized up, therefor it is not devaloped
    }

}