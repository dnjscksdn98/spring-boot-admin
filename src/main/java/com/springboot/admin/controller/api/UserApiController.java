package com.springboot.admin.controller.api;

import com.springboot.admin.domain.model.network.Header;
import com.springboot.admin.domain.model.network.request.UserApiRequest;
import com.springboot.admin.domain.model.network.response.UserApiResponse;
import com.springboot.admin.interfaces.CrudInterface;
import com.springboot.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/users")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping(path = "/{id}")
    public Header<UserApiResponse> read(@PathVariable("id") Long id) {
        log.info("read id : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public Header<UserApiResponse> delete(@PathVariable("id") Long id) {
        log.info("delete id : {}", id);
        return userApiLogicService.delete(id);
    }
}
