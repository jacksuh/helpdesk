package com.system.helpdesk.dto.user;
import com.system.helpdesk.model.User;

public record UserDetalingDto(Long id, String login) {
    public UserDetalingDto(User user){
        this(user.getId(), user.getLogin());
    }
}
