package br.com.welisson.parser.proxy;

/**
 * {@link EndOfFileException}
 *
 * @author Welisson Oliveira
 * @version 1.0 16/09/2017
 */
public class EndOfFileException extends AbstractReaderFileException {
	public EndOfFileException(String message) {
		super(message);
	}

	public Throwable getCause(){
		return new Throwable("Não é possível ler mais o arquivo pois o mesmo cheou ao fim");
	}
}
