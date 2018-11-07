package br.com.steventos.security;

public enum Role {

	ADMINISTRADOR(0), DONO_RECURSO(1), USUARIO(2);
	
	private int codigo;

    private Role(final int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
