package store;

public class Item<E> {
    /* COMPLETE ITEM CLASS */

    private  int itemNumber;
    private  String itemName;
    private  double itemPrice;
    private  double itemCost;
    private  int itemNo =0;
    
    
    public Item() {

    }

    public Item(int itemNumber, String itemName, double itemPrice) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        itemNo++;
        
    }
    
    int getItemNumber(){
        return this.itemNumber;
    }
    
   String getItemName(){
       return this.itemName ;
   }
   
   double getItemPrice(){
       return this.itemPrice;
   }
   
   double itemCost(){
       return this.itemCost;
   }
   
    @Override
    public String toString(){
        return "            -    Number: "+itemNumber+"\n            -    Name: "+itemName+"\n            -    Price: "+itemPrice+"\n";
    }

}