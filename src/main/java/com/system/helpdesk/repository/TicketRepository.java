package com.system.helpdesk.repository;
import com.system.helpdesk.model.Ticket;
import com.system.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

}

