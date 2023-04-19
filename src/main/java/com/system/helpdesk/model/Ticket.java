package com.system.helpdesk.model;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "Ticket")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberTicket;

    private String description;

    private String solution;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String userclosed;
    @ManyToOne
    private User user;

}
