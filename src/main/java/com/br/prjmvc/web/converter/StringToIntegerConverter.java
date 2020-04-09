package com.br.prjmvc.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIntegerConverter implements Converter<String, Integer>{

	@Override
	public Integer convert(String text) {
		
		text = text.trim();
		
		if(text.matches("[0-9]+")) {
			return Integer.valueOf(text);
		}
		
		return null;
	}

}
