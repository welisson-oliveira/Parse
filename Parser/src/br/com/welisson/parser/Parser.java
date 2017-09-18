package br.com.welisson.parser;

import java.util.Optional;

/**
 * {@link Parser}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/09/2017
 */
public interface Parser<T> {
	Optional<T> parse(final String data);
}
