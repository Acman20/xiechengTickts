package informationAcquisition;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import model.Ticket;
import model.TicketNews;
import model.pojo.JsonRootBean;
import model.pojo.SeatList;
import model.pojo.TrainTransferInfos;
import model.pojo.TransferList;
import view.View;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InformationAcquisition {
    /* 携程火车票api */
    public static final String apiUrl="https://trains.ctrip.com/pages/booking/getTransferList?departureStation=%s&arrivalStation=%s&departDateStr=%s";

    public static final OkHttpClient client=new OkHttpClient();



    /*转换为实体类*/
    public static List<TicketNews> getTicketNews(String start,String end,String date) throws IOException {
        List<TicketNews> TicketNewsList=new ArrayList<>();
        start = URLEncoder.encode(start, Charset.forName("UTF-8"));
        end = URLEncoder.encode(end, Charset.forName("UTF-8"));
        String newUrl =new String(String.format(apiUrl,start,end,date).getBytes(),"UTF-8");
        /*
        Request request = new Request.Builder()
                .addHeader("user-agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Mobile Safari/537.36 Edg/90.0.818.62")
                .addHeader("cookie","_RDG=28d83576ca303722401dfed4b2dc8c96bd; _RGUID=b775c31f-c4f2-4865-8d82-3405c56b589a; _RSG=bXay4_nmrTBQYrQ5N0D2s8; _RF1=183.145.120.59; login_uid=2654D81AB72469406563806D09DD212D; login_type=6; cticket=8A58090F0D91BCC623F4FFA870DD418EE781EAE95B348798199AF6180A527451; AHeadUserInfo=VipGrade=0&VipGradeName=%C6%D5%CD%A8%BB%E1%D4%B1&UserName=&NoReadMessageCount=0; ticket_ctrip=bJ9RlCHVwlu1ZjyusRi+ypZ7X2r4+yojDy5HrhNx+DHkuuYsUUyYza5Se/pdK+588wzTqdUGR0rqBc8DUGyPSF0iyLNOnc7AdkLp4ti7LtptN9nBnSGo8E9kvSBP73+vtwLYmB+pnj0LjM/GipboagkUcLZsn/DFvJhR7WyNVLm3QBq7wSXsOzEWUyreVApHMor2qpQITV7ksSkH/n0sQD45wC0WgvHNPihuT/iyHg3xQl3qdKIKDYM2x/oZtr1VQ+Hh7OVJy1XXpOFfTTAElUI0nTv2UraTa62z9KpVUcE=; DUID=u=116A5B076B11BAD70D08A389E602F320&v=0; IsNonUser=F; _PRO_sso_lat_assertion_=3ca4e005f262881af8a6314a0579e113d8b8f33fc9b44b692afd4b24be522936bf0cdfb8e4e50c424e9d97614bba90ca33167b16bcdd3f0eb3a99fb32f55182e65a52d9d95cbcd84f4d5bc34bba9ff385459689e22f26e15b5c86f1e6933930d06929c96b122f97793769d8da6408140b4d86deefab8e662914e23fccf474543; _PRO_sso_lat_assertion_signature_=7b1302fb6e3320f690900625a5e5771e15262e5621496a3c4bcea07a076b4ec0dccd7bc270fa89e4ed9e8f6b5eab0d6f40a1a65af47089d8dca2ad44226d3b66440e33012a3f1318a19949ec2d42842f41bd273b6a3a2c46ab569a1fb04c879f0e12ee5c73a6ea5216c8e0d8d66e3f942d80a374c1d9b44d27bfaf2e45118c60; ibulanguage=CN; ibulocale=zh_cn; cookiePricesDisplayed=CNY; MKT_CKID=1621261490841.edi4m.021g; MKT_CKID_LMT=1621348798500; _ga=GA1.2.759112197.1621348799; _gid=GA1.2.1503982006.1621348799; MKT_Pagesource=PC; _bfa=1.1621348667162.3d9gjq.1.1621348667162.1621348667162.1.13; Session=SmartLinkCode=tieyou&SmartLinkKeyWord=&SmartLinkQuary=_UTF.&SmartLinkHost=www.tieyou.com&SmartLinkLanguage=zh; __zpspc=9.1.1621348798.1621349895.5%234%7C%7C%7C%7C%7C%23; _jzqco=%7C%7C%7C%7C1621349895400%7C1.1245910142.1621349895319.1621349895319.1621349895319.1621349895319.1621349895319.0.0.0.1.1")
                .url(newUrl)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        */
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(600*1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        UnexpectedPage page = webClient.getPage(newUrl);
        InputStream is = page.getInputStream();
        StringBuilder jsonStr = new StringBuilder();
        byte[] bs = new byte[1024];
        int size = is.read(bs);
        while (size != -1){
            jsonStr.append(new String(bs,0,size,"UTF-8"));
            size = is.read(bs);
        }
        /*处理json文件*/
        //String jsonStr = page.getContent();
        System.out.println(jsonStr.toString());
        JsonRootBean jsonRoot;
        List<TransferList> trains;

        jsonRoot = new Gson().fromJson(jsonStr.toString(), JsonRootBean.class);
        trains = jsonRoot.getData().getTransferList();


        for (TransferList train : trains) {
            TrainTransferInfos trainInfo = train.getTrainTransferInfos().get(0);
            TicketNews ti = new TicketNews(trainInfo.getTrainNumber(), train.getDepartStation(), train.getArriveStation(),trainInfo.getDepartTime(), trainInfo.getArriveTime());
            for (SeatList seat : trainInfo.getSeatList()) {
                Ticket ticket = new Ticket(seat.getSeatName(), seat.getOrderPrice(), seat.getInventory());
                ti.addTicket(ticket);
            }
            TicketNewsList.add(ti);
        }
        System.out.println(TicketNewsList);
        return TicketNewsList;
    }




}











