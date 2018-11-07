package br.com.steventos.filter;

import static javax.ws.rs.Priorities.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.google.firebase.auth.FirebaseAuthException;

import br.com.steventos.dao.impl.PessoaDAO;
import br.com.steventos.security.AuthorizationRole;
import br.com.steventos.security.FirebaseAdminSDK;
import br.com.steventos.security.Role;

@AuthorizationRole
@Provider
@Priority(AUTHORIZATION)
public class SecurityFilter implements ContainerRequestFilter {

	private static final String USUARIO_PERMISSAO = "Usuário não tem permissão para acessar esse recurso";

	private static final String UNAUTHORIZED_RESPONSE = "Você não tem permissão para acessar o recurso solicitado.";

	private static final String INVALID_TOKEN = "Token inválido.";

	@Inject
	private FirebaseAdminSDK adminSDK;

	@Inject
	private PessoaDAO pessoaDAO;

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		Method method = resourceInfo.getResourceMethod();

		String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (method != null && token != null) {
			AuthorizationRole role = method.getAnnotation(AuthorizationRole.class);

			try {
				checkAuthorization(token, role.value());
			} catch (IllegalArgumentException | FirebaseAuthException e) {
				requestContext.abortWith(buildResponse(UNAUTHORIZED, INVALID_TOKEN));
			} catch (NoResultException e) {
				requestContext.abortWith(buildResponse(UNAUTHORIZED, USUARIO_PERMISSAO));
			}

		} else {
			requestContext.abortWith(buildResponse(UNAUTHORIZED, UNAUTHORIZED_RESPONSE));
		}
	}

	private void checkAuthorization(String token, Role role)
			throws FirebaseAuthException, NoResultException {

		switch (role) {
		case ADMINISTRADOR:
			System.out.println("Administrador autenticando com o token: " + token);
			String email = adminSDK.validToken(token);
			pessoaDAO.findByEmailAndRole(email, role);
			break;
		case DONO_RECURSO:
			System.out.println("Dono de Recurso autenticando com o token: " + token);
			break;
		case USUARIO:
			System.out.println("Usuário autenticando com o token: " + token);
			break;
		}

	}

	private Response buildResponse(Status status, String message) {
		return Response.status(status).entity(message).build();
	}
}
