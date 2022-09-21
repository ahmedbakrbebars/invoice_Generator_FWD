package model;

public class InoviceLine {
    int InoviceNumber;
    String ItemName;
    float ItemPrice;
    int ItemCount;

    public InoviceLine(int InoviceNumber, String ItemName, float ItemPrice, int ItemCount){
        this.InoviceNumber = InoviceNumber;
        this.ItemCount = ItemCount;
        this.ItemName = ItemName;
        this.ItemPrice = ItemPrice;
    }
    public int getInoviceNumber(){
        return InoviceNumber;
    }
    public float getItemPrice() {
        return ItemPrice;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getItemCount() {
        return ItemCount;
    }
    public float getItemTotal() {
        return ItemCount * ItemPrice;
    }
}
