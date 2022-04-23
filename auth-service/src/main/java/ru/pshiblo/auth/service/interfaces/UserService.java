package ru.pshiblo.auth.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import ru.pshiblo.auth.domain.User;

/**
 * @author Maxim Pshiblo
 */
public interface UserService {
    User getUserById(int userId);
    User getByUsername(String username);
}
