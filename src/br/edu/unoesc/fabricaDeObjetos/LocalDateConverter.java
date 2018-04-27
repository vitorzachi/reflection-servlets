package br.edu.unoesc.fabricaDeObjetos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter 
		implements ConversorWeb<LocalDate> {

	@Override
	public LocalDate converter(String valor) {
		return LocalDate.parse(valor, 
				DateTimeFormatter.ISO_DATE);
	}

}
