import java.util.*;

public class NormalTree {
    public static void main(String[] args) {

        TreeController treeController = new TreeController();

        treeController.insert("A", 10);
        treeController.insert("B", 15);
        treeController.insert("C", 20);
        treeController.insert("D", 25);
        treeController.insert("E", 30);
        treeController.insert("F", 35);
        treeController.insert("G", 40);

        treeController.levelOrderPrint();
    }
}

class TreeController {

    private ObjectData root;

    public void insert(String name, int age) {
        ObjectData newNode = new ObjectData(name, age);

        if (root == null) {
            root = newNode;
            return;
        }

        ObjectData currentNode = root;
        ObjectData parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;

            if (age < currentNode.age) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        if (age < parentNode.age) {
            parentNode.left = newNode;
        } else {
            parentNode.right = newNode;
        }
    }

    public ObjectData search(int age) {
        ObjectData currentNode = root;

        while (currentNode != null) {
            if (age == currentNode.age) {
                return currentNode;
            }

            if (age < currentNode.age) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return null;
    }

    public void delete(int age) {
        root = deleteNode(root, age);
    }

    private ObjectData deleteNode(ObjectData currentNode, int age) {
        if (currentNode == null) {
            return null;
        }

        if (age < currentNode.age) {
            currentNode.left = deleteNode(currentNode.left, age);
            return currentNode;
        }

        if (age > currentNode.age) {
            currentNode.right = deleteNode(currentNode.right, age);
            return currentNode;
        }

        if (currentNode.left == null) {
            return currentNode.right;
        }

        if (currentNode.right == null) {
            return currentNode.left;
        }

        ObjectData successor = findMin(currentNode.right);
        currentNode.name = successor.name;
        currentNode.age = successor.age;
        currentNode.right = deleteNode(currentNode.right, successor.age);
        return currentNode;
    }

    private ObjectData findMin(ObjectData currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    public void preOrderPrint() {
        preOrderPrint(root);
    }

    private void preOrderPrint(ObjectData rootNode) {

        if (rootNode == null) {
            return;
        }

       System.out.print(rootNode.name + ", " + rootNode.age + " -> ");

        preOrderPrint(rootNode.left);

        preOrderPrint(rootNode.right);
    }

    public void postOrderPrint() {
        postOrderPrint(root);
    }

    private void postOrderPrint(ObjectData rootNode) {

        if (rootNode == null) {
            return;
        }

        postOrderPrint(rootNode.left);

        postOrderPrint(rootNode.right);

        System.out.print(rootNode.name + ", " + rootNode.age + " -> ");

    }

    public void inOrderPrint() {
        inOrderPrint(root);
    }

    private void inOrderPrint(ObjectData rootNode) {

        if (rootNode == null) {
            return;
        }

        inOrderPrint(rootNode.left);

        System.out.print(rootNode.name + ", " + rootNode.age + " -> ");

        inOrderPrint(rootNode.right);

    }

    public void levelOrderPrint() {
        
        if (root == null) {
            return;
        }

        Queue<ObjectData> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ObjectData currentNode = queue.poll();
            System.out.print(currentNode.name + ", " + currentNode.age + " -> ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

    }

}

class ObjectData {

    String name;
    int age;

    ObjectData left;
    ObjectData right;

    ObjectData(String name, int age) {
        this.name = name;
        this.age = age;

        this.left = null;
        this.right = null;
    }
}


