package br.com.welisson.parser.proxy;

/**
 * {@link AbstractReaderFileException}
 *
 * @author Welisson Oliveira
 * @version 1.0 16/09/2017
 */
public abstract class AbstractReaderFileException extends RuntimeException {
	public AbstractReaderFileException(String message) {
		super(message);
	}
}
