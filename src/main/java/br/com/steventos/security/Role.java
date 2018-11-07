package br.com.steventos.security;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.codehaus.jackson.annotate.JsonCreator;

public enum Role {

	ADMINISTRADOR(0), DONO_RECURSO(1), USUARIO(2);

	private int codigo;

	private static Map<Integer, Role> FORMAT_MAP = Stream.of(Role.values())
			.collect(Collectors.toMap(s -> s.codigo, Function.identity()));

	private Role(final int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	@JsonCreator
	public static Role fromInteger(Integer integer) {
		return Optional.ofNullable(FORMAT_MAP.get(integer)).orElseThrow(() -> new IllegalArgumentException());
	}
}
