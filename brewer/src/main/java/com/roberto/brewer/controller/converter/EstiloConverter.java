package com.roberto.brewer.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.roberto.brewer.model.Estilo;

public class EstiloConverter implements Converter<String, Estilo> {

	@Override
	public Estilo convert(String id) {
		Estilo estilo = new Estilo();
		estilo.setCodigo(Long.valueOf(id));
		return estilo;
	}

}
