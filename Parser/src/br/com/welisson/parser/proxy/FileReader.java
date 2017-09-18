package br.com.welisson.parser.proxy;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * {@link FileReader}
 *
 * @author Welisson Oliveira
 * @version 1.0 16/09/2017
 */
public class FileReader implements FileReaderProxy {

	private final RealFileReader realFile;
	private Document document;

	public FileReader(final String path) throws IOException {
		realFile = new RealFileReader(path);
		document = new Document(realFile.getId(), realFile.getCreationDate(), realFile.getName());

	}

	@Override
	public int getId() {
		try {
			return document.getId();
		} catch (NullPointerException e) {
			throw new EndOfFileException("End of File");
		}
	}

	@Override
	public LocalDateTime getCreationDate() {
		try {
			return document.getCreationDate();
		} catch (NullPointerException e) {
			throw new EndOfFileException("End of File");
		}

	}

	@Override
	public String getName() {
		try {
			return document.getName();
		} catch (NullPointerException e) {
			throw new EndOfFileException("End of File");
		}
	}

	@Override
	public List<Optional> readNextLine() throws IOException {
		final List<Optional> data = realFile.readNextLine();
		if (data == null) {
			document = null;
		}
		return data;
	}
}
