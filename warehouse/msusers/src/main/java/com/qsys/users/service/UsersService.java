package com.qsys.users.service;

import com.qsys.users.entity.Users;
import com.qsys.users.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Integer id) {
        Optional<Users> user = usersRepository.findById(id);
        return user.orElse(new Users());
    }

    public Users getUserByEmail(String email) {
        Optional<Users> user = Optional.ofNullable(usersRepository.findByEmail(email));
        return user.orElse(new Users());
    }

    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        usersRepository.deleteById(id);
    }

}
