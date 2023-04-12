package com.system.helpdesk.controller;

import com.system.helpdesk.dto.TokenJwtDto;
import com.system.helpdesk.dto.UserAuthentication;
import com.system.helpdesk.infra.springsecurity.TokenService;
import com.system.helpdesk.model.User;
import com.system.helpdesk.service.AutenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AutenticationService service;


    @PostMapping
    public ResponseEntity login(@RequestBody UserAuthentication dto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto(tokenJWT));
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllClient(@PageableDefault(sort = "id", page = 0, size = 10) Pageable page){
        Page<User> listClient = service.getAll(page);
        return ResponseEntity.ok(listClient);
    }


}
