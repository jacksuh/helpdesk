package com.system.helpdesk.service;

import com.system.helpdesk.dto.ticket.TicketDto;
import com.system.helpdesk.dto.ticket.TicketSolutionDto;
import com.system.helpdesk.dto.user.UserDto;
import com.system.helpdesk.model.Ticket;
import com.system.helpdesk.model.User;
import com.system.helpdesk.repository.TicketRepository;
import com.system.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Random;

@Service
public class TicketService {


    @Autowired
    private TicketRepository repository;

    @Autowired
    private UserRepository userRepository;

    private Random random = new Random();

    public Page<Ticket> getAll(Pageable page) {
        return repository.findAll(page);
    }


    public Ticket saveTicket(TicketDto dto) {
        int r = random.nextInt(100000);
        Long idUser = dto.user().getId();
            User user = userRepository.findById(idUser)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        Ticket t = new Ticket();
        t.setNumberTicket(r);
        t.setUser(user);
        t.setStatus(dto.status());
        t.setDescription(dto.description());
        return repository.save(t);
    }

    public Ticket updateTicket(TicketSolutionDto dto, Long id) {
        Optional<Ticket> optional = repository.findById(id);
        Ticket tk = optional.get();
        tk.setUserclosed(dto.userclosed());
        tk.setSolution(dto.solution());
        tk.setStatus(dto.status());

        return repository.save(tk);
    }

    public void deleteTicket(Long id) {
        Optional<Ticket> ticket = repository.findById(id);
        if (ticket.isPresent()) {
            repository.deleteById(id);
        }

    }


}
