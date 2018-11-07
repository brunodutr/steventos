package br.com.steventos.filter;

import static javax.ws.rs.Priorities.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import br.com.steventos.security.AuthorizationRole;

@AuthorizationRole
@Provider
@Priority(AUTHORIZATION)
public class SecurityFilter implements ContainerRequestFilter {

	private static final String UNAUTHORIZED_RESPONSE = "Você não tem permissão para acessar o recurso solicitado.";

	private static final String INVALID_TOKEN = "Token inválido.";

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		Method method = resourceInfo.getResourceMethod();

		String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		
		if (method != null && token != null) {
			AuthorizationRole role = method.getAnnotation(AuthorizationRole.class);

			try {
				switch (role.value()) {
				case ADMINISTRADOR:
					System.out.println("Administrador autenticando com o token: " + token);
					validToken(token);
					break;
				case DONO_RECURSO:
					System.out.println("Dono de Recurso autenticando com o token: " + token);
					break;
				case USUARIO:
					System.out.println("Usuário autenticando com o token: " + token);
					break;
				}
			} catch (Exception e) {
				requestContext.abortWith(buildResponse(UNAUTHORIZED, INVALID_TOKEN));
			}

		} else {
			requestContext.abortWith(buildResponse(UNAUTHORIZED, UNAUTHORIZED_RESPONSE));
		}
	}

	private void validToken(String token) throws Exception {

		if (!token.equalsIgnoreCase("Br123456")) {
			throw new Exception();
		}

	}

	private Response buildResponse(Status status, String message) {
		return Response.status(status).entity(message).build();
	}
}
