/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.api.resource;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.core.Response;

import br.eti.deividferreira.library.api.data.AuthorNew;
import br.eti.deividferreira.library.api.support.PageRequest;

/**
 *
 *
 * @author Deivid Ferreira
 *
 * @version 
 * @since 01/03/2020 22:27:28
 */
public class AuthorResource implements AuthorApi {

	@Override
	public Response add(@Valid AuthorNew author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(
			@NotEmpty(message = "{legume-id.not-empty}") String legumeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response list(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
