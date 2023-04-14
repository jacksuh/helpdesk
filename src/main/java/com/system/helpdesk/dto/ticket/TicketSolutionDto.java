package com.system.helpdesk.dto.ticket;
import com.system.helpdesk.model.Status;

public record TicketSolutionDto(String solution, Status status, String userclosed) {

   }
