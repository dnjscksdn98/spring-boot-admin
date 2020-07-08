package com.springboot.admin.service;

import com.springboot.admin.domain.model.User;
import com.springboot.admin.domain.model.network.Header;
import com.springboot.admin.domain.model.network.request.UserApiRequest;
import com.springboot.admin.domain.model.network.response.UserApiResponse;
import com.springboot.admin.domain.repository.UserRepository;
import com.springboot.admin.interfaces.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    private UserRepository userRepository;

    @Autowired
    public UserApiLogicService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(user);

        return response(savedUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return userRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("Entity not found"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional
                .map(user -> {
                    user.setAccount(userApiRequest.getAccount())
                            .setPassword(userApiRequest.getPassword())
                            .setStatus(userApiRequest.getStatus())
                            .setPhoneNumber(userApiRequest.getPhoneNumber())
                            .setRegisteredAt(userApiRequest.getRegisteredAt())
                            .setUnregisteredAt(userApiRequest.getUnregisteredAt());
                    return user;
                })
                .map(user -> userRepository.save(user))
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("Entity not found"));
    }

    @Override
    public Header delete(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return optional
                .map(user -> {
                    userRepository.delete(user);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("Entity not found"));
    }

    private Header<UserApiResponse> response(User user) {
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        return Header.OK(userApiResponse);
    }
}
