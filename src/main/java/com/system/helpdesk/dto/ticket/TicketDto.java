package com.system.helpdesk.dto.ticket;

import com.system.helpdesk.model.Status;
import com.system.helpdesk.model.User;

public record TicketDto(String description, Status status, User user) {
}
