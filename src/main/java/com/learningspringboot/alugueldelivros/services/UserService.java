package com.learningspringboot.alugueldelivros.services;

import com.learningspringboot.alugueldelivros.entities.User;
import com.learningspringboot.alugueldelivros.repositories.UserRepository;
import com.learningspringboot.alugueldelivros.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User usr) {
        return repository.save(usr);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);

        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setEmail(obj.getEmail());
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
    }

}
