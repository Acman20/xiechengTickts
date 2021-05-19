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
public class Data {

    private List<TransferList> transferList;
    private ExtendInfo extendInfo;
    public void setTransferList(List<TransferList> transferList) {
         this.transferList = transferList;
     }
     public List<TransferList> getTransferList() {
         return transferList;
     }

    public void setExtendInfo(ExtendInfo extendInfo) {
         this.extendInfo = extendInfo;
     }
     public ExtendInfo getExtendInfo() {
         return extendInfo;
     }

}