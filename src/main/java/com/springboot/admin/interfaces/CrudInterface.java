package com.springboot.admin.interfaces;

import com.springboot.admin.domain.model.network.Header;

public interface CrudInterface<Request, Response> {

    Header<Response> create(Header<Request> request);

    Header<Response> read(Long id);

    Header<Response> update(Header<Request> request);

    Header<Response> delete(Long id);
}
