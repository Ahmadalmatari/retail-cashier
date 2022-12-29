package com.example.retailcashier.servieces;

import com.example.retailcashier.models.User;
import com.example.retailcashier.repositories.UserRepository;
import com.example.retailcashier.servieces.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createNewUser(UserDto userDto){

        User user = new User();
        user.setName(userDto.getName());
        user.setCustomerType(userDto.getCustomerType());

        userRepository.save(user);

        return "The User Has Been Added";
    }

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public User updateUser(UserDto userDto){
        User user = userRepository.findById(userDto.getId()).get();
        user.setName(userDto.getName());
        user.setCustomerType(userDto.getCustomerType());
        return userRepository.save(user);

    }
    
    public String deleteUser(Long id){
        
        userRepository.deleteById(id);
        
        return "The User Has Been Deleted !!";
    }
}
