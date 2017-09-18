package br.com.welisson.parser;

import java.util.Optional;

/**
 * {@link MyInteger}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/09/2017
 */
public class MyInteger implements Parser<Integer> {
	@Override public Optional<Integer> parse(String data) {
		return Optional.of(Integer.parseInt(data));
	}
}
