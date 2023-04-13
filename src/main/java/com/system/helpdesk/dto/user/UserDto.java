package com.system.helpdesk.dto.user;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
