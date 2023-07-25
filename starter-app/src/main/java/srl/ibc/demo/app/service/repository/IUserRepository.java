package srl.ibc.demo.app.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import srl.ibc.demo.app.service.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
