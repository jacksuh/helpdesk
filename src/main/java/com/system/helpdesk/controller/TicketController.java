package com.system.helpdesk.controller;
import com.system.helpdesk.dto.ticket.TicketDetalingDto;
import com.system.helpdesk.dto.ticket.TicketDto;
import com.system.helpdesk.dto.ticket.TicketSolutionDto;
import com.system.helpdesk.model.Ticket;
import com.system.helpdesk.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping
    public ResponseEntity createdTicket(@RequestBody @Valid TicketDto dto, UriComponentsBuilder uriBuilder) {
        Ticket t = service.saveTicket(dto);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(t.getNumberTicket()).toUri();
        return ResponseEntity.created(uri).body(new TicketDetalingDto(t));
    }


    @GetMapping
    public ResponseEntity<Page<Ticket>> getAllTicket(@PageableDefault(sort = "id", page = 0, size = 10) Pageable page){
        Page<Ticket> listTicket = service.getAll(page);
        return ResponseEntity.ok(listTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTicket(@PathVariable("id") Long id, @RequestBody TicketSolutionDto dto){
        Ticket t = service.updateTicket(dto,id);

        return t != null?
                ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable Long id){
        service.deleteTicket(id);
        return ResponseEntity.ok().build();
    }

}
