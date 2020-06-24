package store;

public class Order<E> {
    /* COMPLETE ORDER CLASS */

    private int orderNumber;
    private int itemNo = 0;
    DLL<Item> items;

    public Order() { }
    
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        items = new DLL();
    }
    
    
    void addItem(Item newItem) {
        
        Node newNode = new Node();
        newNode.setItem(newItem);
        items.addFirst(newItem);
    }
    


    void removeItem(int itemNumber) {
        Node<Item> focusNode = items.getHead();
        if (focusNode.getItem().getItemNumber() == itemNumber) {
            items.removeFirst();
        } else {

            while (focusNode != null) {

                if (focusNode.getNext().getItem().getItemNumber() == itemNumber) {
                    focusNode.setNext(focusNode.getNext().getNext());
                }
                focusNode = focusNode.getNext();
            }
        }
    }

    void searchByNumber(int itemNumber) {
        
        Node<Item> focusNode = items.getHead();
       

            while (focusNode != null) {

                if (focusNode.getItem().getItemNumber() == itemNumber) {
                    System.out.println(focusNode.getItem());
                }
                focusNode = focusNode.getNext();
            }
    }

    void searchByName(String itemName) {
        Node<Item> focusNode = items.getHead();
       

            while (focusNode != null) {

                if (focusNode.getItem().getItemName().contains(itemName)) {
                    System.out.println(focusNode.getItem()); 
                }
                focusNode = focusNode.getNext();
            }
    }

    void searchByPrice(int itemPrice) {
        Node<Item> focusNode = items.getHead();
        
        while (focusNode != null) {
            
                if (focusNode.getItem().getItemPrice() == itemPrice) {
                    System.out.println();
                }
                focusNode = focusNode.getNext();
            }
    }

    void printOrder() {
        Node focusNode = items.getHead();
        System.out.println("Order #" + orderNumber);
        while (focusNode != null) {
            System.out.println("        Item #" + (++itemNo));
            System.out.println(focusNode.getItem());

            focusNode = focusNode.getNext();
        }
        System.out.println();
    }

    public  int getOrderNumber(){
        return this.orderNumber;
    }
    
}