public class Iterator {

    private Node currentNode;
    private LinkedList list;

    public Iterator(LinkedList list) {
        this.list = list;
        this.currentNode = list.getFirstNode();
    }

    // возвращаем истину, если элемент не последний в списке
    public boolean hasNext() {
        if ( currentNode.getNext() == null ) {
            return false;
        }
        return true;
    }

    // переходим к следующему элементу и возвращаем хранимые данные
    public String next() {
        currentNode = currentNode.getNext();
        return currentNode.getData();
    }

}
