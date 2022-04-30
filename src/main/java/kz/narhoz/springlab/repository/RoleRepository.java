package kz.narhoz.springlab.repository;

import kz.narhoz.springlab.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}