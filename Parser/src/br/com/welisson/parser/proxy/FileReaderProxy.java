package br.com.welisson.parser.proxy;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * {@link FileReaderProxy}
 *
 * @author Welisson Oliveira
 * @version 1.0 15/09/2017
 */
public interface FileReaderProxy {

	int getId() throws IOException;

	LocalDateTime getCreationDate() throws IOException;

	String getName() throws IOException;

	List<Optional> readNextLine() throws IOException;

}
