package net.sharplab.springframework.security.webauthn.sample.app.web.admin;

import lombok.Data;
import net.sharplab.springframework.security.webauthn.sample.domain.model.Group;
import net.sharplab.springframework.security.webauthn.sample.domain.model.User;

import java.util.List;

/**
 * Dto for Authority
 */
@Data
public class AuthorityDto {

    private String authority;

    private List<User> users;
    private List<Group> groups;
}
