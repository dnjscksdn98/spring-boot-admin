package com.springboot.admin.controller.api;

import com.springboot.admin.domain.model.network.Header;
import com.springboot.admin.domain.model.network.request.ItemApiRequest;
import com.springboot.admin.domain.model.network.response.ItemApiResponse;
import com.springboot.admin.interfaces.CrudInterface;
import com.springboot.admin.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/items")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping(path = "/{id}")
    public Header<ItemApiResponse> read(@PathVariable("id") Long id) {
        return itemApiLogicService.read(id);
    }

    @Override
    @PutMapping
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.update(request);
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public Header<ItemApiResponse> delete(@PathVariable("id") Long id) {
        return itemApiLogicService.delete(id);
    }
}
