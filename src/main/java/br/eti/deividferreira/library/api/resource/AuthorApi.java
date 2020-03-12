/*
 * Copyright 2019 Deivid Ferreira, Inc.
 */

package br.eti.deividferreira.library.api.resource;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.eti.deividferreira.library.api.data.AuthorNew;
import br.eti.deividferreira.library.api.support.PageRequest;
import br.eti.deividferreira.library.model.entities.Author;

/**
 *
 *
 * @author Deivid Ferreira
 *
 * @version 
 * @since 01/03/2020 21:52:39
 */
@Path("authors")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public interface AuthorApi {
	
	@POST
	@Operation(
			operationId = "AddAuthor",
			summary = "Add a Author"
	)
	@RequestBody(
			content = @Content(
					mediaType = APPLICATION_JSON,
					schema = @Schema(implementation = AuthorNew.class)),
			description = "The Author to create",
			required = true
	)
	@APIResponse(
			responseCode = "201",
			description = "Author created",
			content = @Content(
					mediaType = APPLICATION_JSON,
					schema = @Schema(implementation = Author.class))
	)
	@APIResponse(
			name = "notFound",
			responseCode = "400",
			description = "Author data is invalid"
	)
	@APIResponse(
			name = "notFound",
			responseCode = "404",
			description = "Author provision not found"
	)
	@APIResponse(
			name = "internalError",
			responseCode = "500",
			description = "Internal Server Error"
	)
	Response add(@Valid final AuthorNew author);
	
	@DELETE
   @Path("{id}")
   @Operation(
           operationId = "DeleteAuthor",
           summary = "Delete a Author"
   )
   @APIResponse(
           responseCode = "204",
           description = "Empty response"
   )
   @APIResponse(
           name = "notFound",
           responseCode = "404",
           description = "Author not found"
   )
   @APIResponse(
           name = "internalError",
           responseCode = "500",
           description = "Internal Server Error"
   )
	Response delete(@Parameter(name = "id",
							description = "Id of the Author to delete",
							required = true,
							example = "81471222-5798-11e9-ae24-57fa13b361e1",
							schema = @Schema(description="uuid", required = true))
						@PathParam("id")
						@NotEmpty(message = "{legume-id.not-empty}") final String legumeId);
	
	@Operation(
         operationId = "ListAuthors",
         summary = "List all authors"
	)
	@APIResponse(
         responseCode = "200",
         description = "The List with all authors"
	)
	@APIResponse(
         name = "notFound",
         responseCode = "404",
         description = "Author list not found"
	)
	@APIResponse(
         name = "internalError",
         responseCode = "500",
         description = "Internal Server Error"
	)
	@GET
	Response list(@BeanParam PageRequest pageRequest);
	
	@GET
	@Path("search")
	@APIResponse(
			name = "notFound",
			responseCode = "404",
			description = "Author not found"
	)
	@APIResponse(
         name = "internalError",
         responseCode = "500",
         description = "Internal Server Error"
	)
	Response search(@Parameter(
				name = "name",
				description = "the name for search author",
				in = ParameterIn.QUERY,
				schema = @Schema(type = SchemaType.STRING, implementation = String.class),
				example = "Machado de Assis",
				required = true
			) @QueryParam("name") String name);

}
