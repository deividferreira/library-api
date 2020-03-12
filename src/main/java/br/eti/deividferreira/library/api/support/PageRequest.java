/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.api.support;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author Deivid Ferreira
 *
 * @version
 * @since 02/03/2020 21:55:10
 */
@NoArgsConstructor
@AllArgsConstructor
public final class PageRequest {

	@Getter
	@Parameter(
			name = "page",
			description = "the number of page",
			in = ParameterIn.QUERY,
			schema = @Schema(type = SchemaType.INTEGER, implementation = Integer.class),
			example = "0",
			required = false
	)
	@QueryParam("page")
	@DefaultValue("0")
	private int pageNum;

	@Getter
	@Parameter(
			name = "size",
			description = "the size of page",
			in = ParameterIn.QUERY,
			schema = @Schema(type = SchemaType.INTEGER, implementation = Integer.class),
			example = "10",
			required = false
	)
	@QueryParam("size")
	@DefaultValue("10")
	private int pageSize;

}
