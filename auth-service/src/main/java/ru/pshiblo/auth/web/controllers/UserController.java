package ru.pshiblo.auth.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pshiblo.auth.domain.User;
import ru.pshiblo.auth.service.interfaces.UserService;
import ru.pshiblo.auth.web.dto.response.UserDto;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("#oauth2.hasScope('user')")
    @GetMapping("/current")
    public UserDto getCurrent(@AuthenticationPrincipal Principal principal) {
        return new UserDto();
    }

    //@PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping("/userinfo/{userId}")
    public User getUserInfo(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId.intValue());
    }
}
