package model;

import java.util.ArrayList;
import java.util.List;

/* 票的信息*/

public class TicketNews {
    private final String number;
    private final String start;
    private final String end;
    private final String startTime;
    private final String endTime;
    private final List<Ticket> Tickets;

    public TicketNews(String number, String start, String end, String startTime, String endTime) {
        this.number = number;
        this.start = start;
        this.end = end;
        this.startTime = startTime;
        this.endTime = endTime;
        this.Tickets = new ArrayList<>();
    }
    public void addTicket(Ticket ticket){
        Tickets.add(ticket);
    }

    public String getNumber() {
        return number;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public List<Ticket> getTickets() {
        return Tickets;
    }

    public Ticket containTicket(String name){
        for (Ticket ticket : getTickets()) {
            if(ticket.getName().equals(name)){
                return ticket;
            }
        }
        return null;
    }

}
