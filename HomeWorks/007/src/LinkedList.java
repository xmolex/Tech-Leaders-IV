public class LinkedList {

    private Node firstNode;
    private Node currentNode;
    private int size;

    public LinkedList() {
        this.firstNode = new Node();
        this.currentNode = this.firstNode;
        this.size = 0;
    }

    // получаем элемент из коллекции по индексу
    public String get(int pos) {
        String currentStr = "";
        int currentPosition = 0;
        Iterator listIterator = new Iterator(this);
        while (listIterator.hasNext()) {

            // переходим на следующий элемент, получая значение
            currentStr = listIterator.next();
            if (currentPosition == pos) {
                return currentStr;
            }

            currentPosition++;
        }

        return "";
    }

    // добавляем новый элемент в коллекцию
    public void add(String str) {
        Node createNode = new Node();
        currentNode.setNext(createNode);
        createNode.setData(str);
        currentNode = createNode;
        size++;
    }

    // возвращаем корневой элемент с которого все начинается (не содержит данные, типа -1)
    public Node getFirstNode() {
        return firstNode;
    }

    public int size() {
        return size;
    }
}
