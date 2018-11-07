package br.com.steventos.security;

import static br.com.steventos.security.Role.USUARIO;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

@NameBinding
@Target({ TYPE, METHOD })
@Retention(RUNTIME)
public @interface AuthorizationRole {

	Role value() default USUARIO;
	
}
