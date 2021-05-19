/**
  * Copyright 2021 json.cn 
  */
package model.pojo;
import java.util.List;

/**
 * Auto-generated: 2021-05-18 14:15:4
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class TransferList {

    private String departStation;
    private String arriveStation;
    private String transferStation;
    private String transferTakeTime;
    private String showPriceText;
    private List<TrainTransferInfos> trainTransferInfos;
    private Object totalRuntime;
    private int totalRuntimeValue;
    private int index;
    private String tagList;
    public void setDepartStation(String departStation) {
         this.departStation = departStation;
     }
     public String getDepartStation() {
         return departStation;
     }

    public void setArriveStation(String arriveStation) {
         this.arriveStation = arriveStation;
     }
     public String getArriveStation() {
         return arriveStation;
     }

    public void setTransferStation(String transferStation) {
         this.transferStation = transferStation;
     }
     public String getTransferStation() {
         return transferStation;
     }

    public void setTransferTakeTime(String transferTakeTime) {
         this.transferTakeTime = transferTakeTime;
     }
     public String getTransferTakeTime() {
         return transferTakeTime;
     }

    public void setShowPriceText(String showPriceText) {
         this.showPriceText = showPriceText;
     }
     public String getShowPriceText() {
         return showPriceText;
     }

    public void setTrainTransferInfos(List<TrainTransferInfos> trainTransferInfos) {
         this.trainTransferInfos = trainTransferInfos;
     }
     public List<TrainTransferInfos> getTrainTransferInfos() {
         return trainTransferInfos;
     }

    public void setTotalRuntime(Object totalRuntime) {
         this.totalRuntime = totalRuntime;
     }
     public Object getTotalRuntime() {
         return totalRuntime;
     }

    public void setTotalRuntimeValue(int totalRuntimeValue) {
         this.totalRuntimeValue = totalRuntimeValue;
     }
     public int getTotalRuntimeValue() {
         return totalRuntimeValue;
     }

    public void setIndex(int index) {
         this.index = index;
     }
     public int getIndex() {
         return index;
     }

    public void setTagList(String tagList) {
         this.tagList = tagList;
     }
     public String getTagList() {
         return tagList;
     }

}