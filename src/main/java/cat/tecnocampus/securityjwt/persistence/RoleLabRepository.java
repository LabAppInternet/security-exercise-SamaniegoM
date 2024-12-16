package cat.tecnocampus.securityjwt.persistence;

import cat.tecnocampus.securityjwt.domain.Role;
import cat.tecnocampus.securityjwt.domain.UserLab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleLabRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findRoleById(int id);
}
