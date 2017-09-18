package br.com.welisson.parser;

import java.util.Optional;

/**
 * {@link MyString}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/09/2017
 */
public class MyString implements Parser{
	@Override public Optional<String> parse(String data) {
		return Optional.of(data);
	}
}
