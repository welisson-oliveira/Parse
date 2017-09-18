package br.com.welisson.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * {@link MyDate}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/09/2017
 */
public class MyDate implements Parser<LocalDate> {
	@Override public Optional<LocalDate> parse(String data) {
		return Optional.of(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"))) ;
	}
}
