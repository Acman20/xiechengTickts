/**
  * Copyright 2021 json.cn 
  */
package model.pojo;

/**
 * Auto-generated: 2021-05-18 14:15:4
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class SeatList {

    private String seatName;
    private String showSeatName;
    private String price;
    private double orderPrice;
    private int inventory;
    private String inventoryStr;
    private boolean isBookable;
    private String buttonDisplayName;
    private int buttonType;
    public void setSeatName(String seatName) {
         this.seatName = seatName;
     }
     public String getSeatName() {
         return seatName;
     }

    public void setShowSeatName(String showSeatName) {
         this.showSeatName = showSeatName;
     }
     public String getShowSeatName() {
         return showSeatName;
     }

    public void setPrice(String price) {
         this.price = price;
     }
     public String getPrice() {
         return price;
     }

    public void setOrderPrice(double orderPrice) {
         this.orderPrice = orderPrice;
     }
     public double getOrderPrice() {
         return orderPrice;
     }

    public void setInventory(int inventory) {
         this.inventory = inventory;
     }
     public int getInventory() {
         return inventory;
     }

    public void setInventoryStr(String inventoryStr) {
         this.inventoryStr = inventoryStr;
     }
     public String getInventoryStr() {
         return inventoryStr;
     }

    public void setIsBookable(boolean isBookable) {
         this.isBookable = isBookable;
     }
     public boolean getIsBookable() {
         return isBookable;
     }

    public void setButtonDisplayName(String buttonDisplayName) {
         this.buttonDisplayName = buttonDisplayName;
     }
     public String getButtonDisplayName() {
         return buttonDisplayName;
     }

    public void setButtonType(int buttonType) {
         this.buttonType = buttonType;
     }
     public int getButtonType() {
         return buttonType;
     }

}