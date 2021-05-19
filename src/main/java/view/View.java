package view;

import informationAcquisition.InformationAcquisition;
import model.Ticket;
import model.TicketNews;
import model.pojo.TrainTransferInfos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


public class View extends JFrame {

    /*总体布局*/
    public View() {

        setTitle("火车票查询");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        addThings();
        setSize(1000, 700);
        setVisible(true);
    }

    /*添加*/
    public void addThings() {
        Font f = new Font("微软雅黑", Font.PLAIN, 20);
        /*始发地*/
        JLabel startLabel = new JLabel();
        startLabel.setSize(60, 35);
        startLabel.setLocation(200, 10);
        startLabel.setText("始发地");
        startLabel.setFont(f);
        add(startLabel);
        /*始发地输入*/
        JTextField startField = new JTextField();
        startField.setSize(90, 35);
        startField.setLocation(190, 50);
        startField.setFont(f);
        add(startField);
        /*箭头*/
        JLabel arrow = new JLabel();
        arrow.setSize(100, 35);
        arrow.setLocation(350, 35);
        arrow.setText("-------->");
        arrow.setFont(new Font("仿宋", Font.BOLD, 30));
        arrow.setFont(f);
        add(arrow);
        /*目的地*/
        JLabel endLabel = new JLabel();
        endLabel.setSize(60, 35);
        endLabel.setLocation(500, 10);
        endLabel.setText("目的地");
        endLabel.setFont(f);
        add(endLabel);
        /*目的地输入*/
        JTextField endField = new JTextField();
        endField.setSize(90, 35);
        endField.setLocation(490, 50);
        endField.setFont(f);
        add(endField);
        /*日期选择*/
        JLabel time = new JLabel();
        time.setSize(60, 35);
        time.setLocation(750, 10);
        time.setText("日期");
        time.setFont(f);
        add(time);

        JComboBox choice = new JComboBox();
        choice.setSize(120, 35);
        choice.setLocation(720, 50);
        choice.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 14; i++) {
            choice.addItem(simpleDateFormat.format(new Date(System.currentTimeMillis() + i * 1000 * 60 * 60 * 24)));
        }
        add(choice);


        /*车次表格*/
        ResultTable resultTable = new ResultTable();
        JScrollPane jScrollPane = new JScrollPane(resultTable);
        jScrollPane.setBounds(0, 200, 900, 400);
        add(jScrollPane);

        /*按钮*/
        JButton jButton = new JButton();
        jButton.setSize(100, 35);
        jButton.setLocation(400, 120);
        jButton.setText("查询");
        jButton.setFont(f);
        jButton.addActionListener(e -> {
            String start = startField.getText();
            String end = endField.getText();
            if(start.length() == 0 || end.length() == 0){
                message("有内容没输入!");
                return;
            }
            try {
                jScrollPane.remove(resultTable);
                jScrollPane.setViewportView(new ResultTable(start,end,choice.getSelectedItem().toString()));
                jScrollPane.validate();
            } catch (IOException | URISyntaxException ioException) {
                ioException.printStackTrace();
            }
        });
        add(jButton);


    }

    public static void message(String msg) {
        JOptionPane.showMessageDialog(null, msg, "", JOptionPane.INFORMATION_MESSAGE);
    }

}

class ResultTable extends JTable {

    DefaultTableModel defaultModel;

    public ResultTable() {
        setEnabled(false);
        setBounds(0, 0, 900, 400);
    }

    public ResultTable(String start, String end, String date) throws IOException, URISyntaxException {
        this();
        List<TicketNews> trainInfoList = InformationAcquisition.getTicketNews(start, end, date);
        if (trainInfoList == null) {
            return;
        }
        if (trainInfoList.size() == 0) {
            View.message("当天已经没车了!");
            return;
        }
        String[] name = {"车次", "开始点", "结束点", "开始时间", "到达时间"};
        String[][] data = new String[trainInfoList.size()][6];
        for (int i = 0; i < trainInfoList.size(); i++) {
            TicketNews train = trainInfoList.get(i);
            data[i][0] = train.getNumber();
            data[i][1] = train.getStart();
            data[i][2] = train.getEnd();
            data[i][3] = train.getStartTime();
            data[i][4] = train.getEndTime();

        }

        Map<String, List<String>> seatMap = new LinkedHashMap<>();

        Set<String> seatSet = new HashSet<>();
        for (TicketNews trainInfo : trainInfoList) {
            for (Ticket ticket : trainInfo.getTickets()) {
                seatSet.add(ticket.getName());
            }
        }

        for (TicketNews trainInfo : trainInfoList) {
            for (String seat : seatSet) {
                List<String> list = new ArrayList<>();
                ;
                if (seatMap.containsKey(seat)) {
                    list = seatMap.get(seat);
                }
                Ticket ticket = trainInfo.containTicket(seat);
                if (ticket == null) {
                    list.add(null);
                    continue;
                }
                list.add(ticket.getPrince() + "元/" + (ticket.getAmount() == 99 ? "有票" : "剩" + ticket.getAmount() + "张"));
                seatMap.put(seat, list);
            }
        }
        defaultModel = new DefaultTableModel(data, name);
        for (String s : seatMap.keySet()) {
            List<String> list = seatMap.get(s);
            defaultModel.addColumn(s, list.toArray(new String[list.size()]));
        }
        setModel(defaultModel);
    }
}
