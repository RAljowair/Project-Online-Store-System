package store;

public class Store<E> {

    /* STORE CLASS FUNCTIONS AND DATA FIELDS SHOULD BE HERE */
    Queue<Order> newOrders;
    Queue<Order> processedOrders;
    Queue<Order> removedOrders;
    DLL<Item> items;
    private double sales;

//   All Store's items
    Item iPhoneX = new Item(111, "iPhone X", 3750);
    Item iPhoneXMax = new Item(133, "Bose Headphone", 1099);
    Item Samsung = new Item(231, "Samsung Galaxy Note 10", 2500);
    Item boseHeadPhone = new Item(133, "Bose Headphone", 1099);
    Item appleAirPods = new Item(131, "Apple AirPods", 599);

    public Store() {
        this.newOrders = new Queue();
        this.processedOrders = new Queue();
        this.removedOrders = new Queue();
        this.items = new DLL();
        items.addFirst(iPhoneX);
        items.addFirst(iPhoneXMax);
        items.addFirst(Samsung);
        items.addFirst(boseHeadPhone);
        items.addFirst(appleAirPods);

    }
    
    

    void restOrders() {
        newOrders = null;
        removedOrders = null;
        processedOrders = null;
    }

    void addNewOrder(Order newOrder) {
        newOrders.enqueue(newOrder);
    }

    void processOrder() {
        Order<Item> focusOrder = newOrders.dequeue();
        Node<Item> focusNode = focusOrder.items.getHead();
        processedOrders.enqueue(focusOrder);
        double itemPrice;

        while (focusNode != null) {
            itemPrice = focusNode.getItem().getItemPrice();
            this.sales = sales + itemPrice;
            focusNode = focusNode.getNext();
        }
    }

    void removeOrder(int orderNumber) {
        Queue<Order> temp = new Queue();
        Order focusOrder = newOrders.dequeue();

        while (focusOrder != null) {
            if (focusOrder.getOrderNumber() == orderNumber) {
                removedOrders.enqueue(focusOrder);
            } else {
                temp.enqueue(focusOrder);
            }
            focusOrder = newOrders.dequeue();
        }

        newOrders = temp;
    }

    void printAllOrders(Queue<Order> Orders) {
        Queue<Order> temp = new Queue();
        Order focusOrder;

        if (Orders.first() != null) {
            focusOrder = Orders.dequeue();
            while (focusOrder != null) {
                focusOrder.printOrder();
                focusOrder = Orders.dequeue();
                temp.enqueue(focusOrder);
            }
        } else {
            System.out.println("There is no Orders");
        }
    }

    double calculatSales() {
        return this.sales;
    }
   
    
// For 2 MARKS BOUNS 
/*  
     void genearteItemsTree(){
         
     }
    
     void binarySearchItems(){
        
     }
*/

    /* AFTER COMPLETING THE REQUIREMENTS ALL ERRORS SHOULD BE RESOLVED */
    public static void main(String[] args) {
        Store store = new Store();
        Order o4 = new Order(4);
        o4.addItem(new Item(111, "iPhone X", 3750));
        o4.addItem(new Item(133, "Bose Headphone", 1099));
        store.addNewOrder(o4);
        Order o5 = new Order(5);
        o5.addItem(new Item(122, "iPhone X Max", 5550));
        store.addNewOrder(o5);
        Order o1 = new Order(1);
        o1.addItem(new Item(111, "iPhone X", 3750));
        o1.addItem(new Item(122, "iPhone X Max", 5550));
        o1.addItem(new Item(231, "Samsung Galaxy Note 10", 2500));
        store.addNewOrder(o1);
        Order o2 = new Order(2);
        o2.addItem(new Item(122, "iPhone X Max", 5550));
        o2.addItem(new Item(131, "Apple AirPods", 599));
        store.addNewOrder(o2);
        Order o3 = new Order(3);
        o3.addItem(new Item(231, "Samsung Galaxy Note 10", 2500));
        store.addNewOrder(o3);
        store.removeOrder(5);
        store.processOrder();
        System.out.println("[New:]");
        store.printAllOrders(store.newOrders);
        System.out.println("[Processed:]");
        store.printAllOrders(store.processedOrders);
        System.out.println("[Removed:]");
        store.printAllOrders(store.removedOrders);

//        o1.searchByName("iPhone X");
//        o1.searchByNumber(111);
//        o2.searchByPrice(2500);

    }

}