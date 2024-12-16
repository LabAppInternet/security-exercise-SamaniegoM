package cat.tecnocampus.securityjwt.application;

import cat.tecnocampus.securityjwt.domain.UserLab;
import cat.tecnocampus.securityjwt.persistence.RoleLabRepository;
import cat.tecnocampus.securityjwt.persistence.UserLabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class UserController {
    @Autowired
    private RoleLabRepository roleLabRepository;
    @Autowired
    private UserLabRepository userLabRepository;

    public void createSingleRolUser(String email, String username, String password,int roleId) {
        UserLab userLab = new UserLab(username, email, password);
        userLab.setRoles(Set.of(roleLabRepository.findRoleById(roleId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect Role Id"))));
        userLabRepository.save(userLab);
    }
}
