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

        if (topPoint <= (arr.length - loadFactor) && arr.length > initiateSizeOfArr) {
            int[] tempArray = new int[arr.length - loadFactor];
            for (int i = 0; i < topPoint; i++) {
                tempArray[i] = arr[i];
            }
            arr = tempArray;
        }
    }

    boolean isEmpty() {
        return topPoint <= 0;
    }

    void displayStack() {

        System.out.print("[");

        for (int i = topPoint; i > 0; i--) {
            System.out.print(arr[i - 1] + ",");
        }

        System.out.println(isEmpty() ? "Stack is Empty]" : "\b]");

    }

    void findIndex(int value) {

        if (!contains(value)) {
            System.out.println("This value does not exist");
            return;

        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                System.out.println("Index of " + value + ": " + (arr.length - 1 - i));
                return;
            }

        }

        System.out.println("This value does not exist");
    }

    boolean contains(int value) {
        for (int i = 0; i < arr.length; i++) {

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

}