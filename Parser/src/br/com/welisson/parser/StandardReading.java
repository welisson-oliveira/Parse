package br.com.welisson.parser;

import br.com.welisson.parser.proxy.FileReader;
import br.com.welisson.parser.proxy.FileReaderProxy;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * {@link StandardReading}
 *
 * @author Welisson Oliveira
 * @version 1.0 16/09/2017
 */
public abstract class StandardReading {

	public void read(final String path) {
		final FileReaderProxy file;
		try {
			file = new FileReader(path);

			id(file.getId());
			nextLine();
			creationDate(file.getCreationDate());
			nextLine();
			name(file.getName());
			nextLine();

			List<Optional> datas;
			while ((datas = file.readNextLine()) != null) {
				for (final Optional data : datas) {
					if (data.isPresent()) {
						columnData(data);
					}
				}
				nextLine();

			}
			end();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	protected abstract void id(int id);

	protected abstract void creationDate(LocalDateTime creationDate);

	protected abstract void name(String name);

	protected abstract void columnData(Optional data);

	protected abstract void nextLine();

	protected abstract void end();






}
