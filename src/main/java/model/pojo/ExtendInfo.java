/**
  * Copyright 2021 json.cn 
  */
package model.pojo;
import java.util.Date;

/**
 * Auto-generated: 2021-05-18 14:15:4
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class ExtendInfo {

    private Date departDate;
    private String departStationList;
    private String endStationList;
    private String departStationFilterMap;
    private String endStationFilterMap;
    private String departCityName;
    private String arriveCityName;
    private String gtMinPrice;
    public void setDepartDate(Date departDate) {
         this.departDate = departDate;
     }
     public Date getDepartDate() {
         return departDate;
     }

    public void setDepartStationList(String departStationList) {
         this.departStationList = departStationList;
     }
     public String getDepartStationList() {
         return departStationList;
     }

    public void setEndStationList(String endStationList) {
         this.endStationList = endStationList;
     }
     public String getEndStationList() {
         return endStationList;
     }

    public void setDepartStationFilterMap(String departStationFilterMap) {
         this.departStationFilterMap = departStationFilterMap;
     }
     public String getDepartStationFilterMap() {
         return departStationFilterMap;
     }

    public void setEndStationFilterMap(String endStationFilterMap) {
         this.endStationFilterMap = endStationFilterMap;
     }
     public String getEndStationFilterMap() {
         return endStationFilterMap;
     }

    public void setDepartCityName(String departCityName) {
         this.departCityName = departCityName;
     }
     public String getDepartCityName() {
         return departCityName;
     }

    public void setArriveCityName(String arriveCityName) {
         this.arriveCityName = arriveCityName;
     }
     public String getArriveCityName() {
         return arriveCityName;
     }

    public void setGtMinPrice(String gtMinPrice) {
         this.gtMinPrice = gtMinPrice;
     }
     public String getGtMinPrice() {
         return gtMinPrice;
     }

}