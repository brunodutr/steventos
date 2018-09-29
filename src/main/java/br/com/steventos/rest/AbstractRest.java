package br.com.steventos.rest;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.steventos.dao.AbstractDAO;

public abstract class AbstractRest<T, K extends AbstractDAO<T>> {

	@Inject
	protected K dao;

	private Class<T> clazz;

	public AbstractRest(Class<T> clazz) {
		this.clazz = clazz;
	}

	@GET
	public List<T> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final List<T> objects = dao.findAll();
		return objects;
	}

	@POST
	public Response create(@Valid final T entity) {

		T object = dao.create(entity);
		return Response.created(UriBuilder.fromResource(clazz).path(String.valueOf(object)).build()).build();
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

}
