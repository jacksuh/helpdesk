package com.system.helpdesk.dto.ticket;
import com.system.helpdesk.model.Status;
import com.system.helpdesk.model.Ticket;


public record TicketDetalingDto(Long id, String description, Status status, int NumberTicket, String user) {

    public TicketDetalingDto(Ticket ticket){
        this(ticket.getId(), ticket.getDescription(), ticket.getStatus(), ticket.getNumberTicket(), ticket.getUser().getLogin());
    }
}
