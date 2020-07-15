package com.springboot.admin.controller.api;

import com.springboot.admin.domain.model.network.Header;
import com.springboot.admin.interfaces.CrudInterface;
import com.springboot.admin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

    @Autowired(required = false)
    protected BaseService<Req, Res, Entity> baseService;

    @Override
    @PostMapping(path = "")
    public Header<Res> create(@RequestBody Header<Req> request) {
        return baseService.create(request);
    }

    @Override
    @GetMapping(path = "{id}")
    public Header<Res> read(@PathVariable("id") Long id) {
        return baseService.read(id);
    }

    @Override
    @PutMapping(path = "")
    public Header<Res> update(@RequestBody Header<Req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping(path = "{id}")
    public Header<Res> delete(@PathVariable("id") Long id) {
        return baseService.delete(id);
    }
}
