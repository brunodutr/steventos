package br.com.steventos.rest;

import static br.com.steventos.security.Role.ADMINISTRADOR;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.com.steventos.dao.AbstractDAO;
import br.com.steventos.dto.AutocompleteDTO;
import br.com.steventos.model.BaseModel;
import br.com.steventos.security.AuthorizationRole;

@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public abstract class AbstractRest<T, K extends AbstractDAO<T>> {

	@Inject
	protected K dao;

	@GET
	@AuthorizationRole(ADMINISTRADOR)
	public List<T> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<T> objects = dao.findAll();
		return objects;
	}

	@POST
	public T create(@Valid final T entity) {
		T object = dao.create(entity);
		return object;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		T object = dao.find(id);
		if (object == null) {
			return Response.status(NOT_FOUND).build();
		}
		return Response.ok(object).build();
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, @Valid final T object) {
		dao.update(object);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		dao.delete(id);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}/{campo:[\\S]+(s\\b)}")
	public Collection<?> listField(@PathParam("id") Long id, @PathParam("campo") String campo) {

		try {
			return dao.getField(id, campo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new HashSet<>();

	}

	@POST
	@Path("/{id:[0-9][0-9]*}/{campo:[\\S]+(s\\b)}")
	public void insertIntoField(@PathParam("id") Long id, @PathParam("campo") String campo, BaseModel object) {
		try {
			dao.setField(id, campo, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@POST
	@Path("/autocomplete")
	public List<T> getAutocomplete(AutocompleteDTO dto) {
		return dao.findAutocomplete(dto);
	}

}
