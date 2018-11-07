package br.com.steventos.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import br.com.steventos.model.impl.Evento;
import br.com.steventos.model.impl.Hospedagem;
import br.com.steventos.model.impl.Local;
import br.com.steventos.model.impl.Pessoa;
import br.com.steventos.model.impl.Transporte;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Evento.class), 
				@Type(value = Hospedagem.class),
				@Type(value = Pessoa.class), 
				@Type(value = Transporte.class), 
				@Type(value = Local.class)  
			  })
@MappedSuperclass
public abstract class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
