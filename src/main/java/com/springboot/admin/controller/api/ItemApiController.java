package com.springboot.admin.controller.api;

import com.springboot.admin.domain.model.Item;
import com.springboot.admin.domain.model.network.request.ItemApiRequest;
import com.springboot.admin.domain.model.network.response.ItemApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/items")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
