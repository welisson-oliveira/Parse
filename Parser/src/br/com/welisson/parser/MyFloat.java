package br.com.welisson.parser;

import java.util.Optional;

/**
 * {@link MyFloat}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/09/2017
 */
public class MyFloat implements Parser<Float> {
	@Override public Optional parse(String data) {
		return Optional.of(Float.parseFloat(data));
	}
}
