/**
  * Copyright 2021 json.cn 
  */
package model.pojo;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2021-05-18 14:15:4
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class TrainTransferInfos {

    private int sequence;
    private String trainNo;
    private String trainNumber;
    private String departStation;
    private String departStationPy;
    private String arriveStation;
    private String arriveStationPy;
    private Date departDate;
    private String departTime;
    private Date arriveDate;
    private String arriveTime;
    private boolean isStartStation;
    private boolean isEndStation;
    private String runTime;
    private String preSaleTime;
    private int takeDays;
    private boolean isBookable;
    private List<SeatList> seatList;
    private int curSeatIndex;
    public void setSequence(int sequence) {
         this.sequence = sequence;
     }
     public int getSequence() {
         return sequence;
     }

    public void setTrainNo(String trainNo) {
         this.trainNo = trainNo;
     }
     public String getTrainNo() {
         return trainNo;
     }

    public void setTrainNumber(String trainNumber) {
         this.trainNumber = trainNumber;
     }
     public String getTrainNumber() {
         return trainNumber;
     }

    public void setDepartStation(String departStation) {
         this.departStation = departStation;
     }
     public String getDepartStation() {
         return departStation;
     }

    public void setDepartStationPy(String departStationPy) {
         this.departStationPy = departStationPy;
     }
     public String getDepartStationPy() {
         return departStationPy;
     }

    public void setArriveStation(String arriveStation) {
         this.arriveStation = arriveStation;
     }
     public String getArriveStation() {
         return arriveStation;
     }

    public void setArriveStationPy(String arriveStationPy) {
         this.arriveStationPy = arriveStationPy;
     }
     public String getArriveStationPy() {
         return arriveStationPy;
     }

    public void setDepartDate(Date departDate) {
         this.departDate = departDate;
     }
     public Date getDepartDate() {
         return departDate;
     }

    public void setDepartTime(String departTime) {
         this.departTime = departTime;
     }
     public String getDepartTime() {
         return departTime;
     }

    public void setArriveDate(Date arriveDate) {
         this.arriveDate = arriveDate;
     }
     public Date getArriveDate() {
         return arriveDate;
     }

    public void setArriveTime(String arriveTime) {
         this.arriveTime = arriveTime;
     }
     public String getArriveTime() {
         return arriveTime;
     }

    public void setIsStartStation(boolean isStartStation) {
         this.isStartStation = isStartStation;
     }
     public boolean getIsStartStation() {
         return isStartStation;
     }

    public void setIsEndStation(boolean isEndStation) {
         this.isEndStation = isEndStation;
     }
     public boolean getIsEndStation() {
         return isEndStation;
     }

    public void setRunTime(String runTime) {
         this.runTime = runTime;
     }
     public String getRunTime() {
         return runTime;
     }

    public void setPreSaleTime(String preSaleTime) {
         this.preSaleTime = preSaleTime;
     }
     public String getPreSaleTime() {
         return preSaleTime;
     }

    public void setTakeDays(int takeDays) {
         this.takeDays = takeDays;
     }
     public int getTakeDays() {
         return takeDays;
     }

    public void setIsBookable(boolean isBookable) {
         this.isBookable = isBookable;
     }
     public boolean getIsBookable() {
         return isBookable;
     }

    public void setSeatList(List<SeatList> seatList) {
         this.seatList = seatList;
     }
     public List<SeatList> getSeatList() {
         return seatList;
     }

    public void setCurSeatIndex(int curSeatIndex) {
         this.curSeatIndex = curSeatIndex;
     }
     public int getCurSeatIndex() {
         return curSeatIndex;
     }

}