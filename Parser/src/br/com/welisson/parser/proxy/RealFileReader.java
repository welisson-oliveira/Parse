package br.com.welisson.parser.proxy;

import br.com.welisson.parser.MyDate;
import br.com.welisson.parser.MyFloat;
import br.com.welisson.parser.MyInteger;
import br.com.welisson.parser.MyString;
import br.com.welisson.parser.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * {@link RealFileReader}
 *
 * @author Welisson Oliveira
 * @version 1.0 16/09/2017
 */
public class RealFileReader implements FileReaderProxy {

	private final BufferedReader file;
	private List<Parser> configuration;

	public RealFileReader(final String path) throws FileNotFoundException {
		final BufferedReader reader = new BufferedReader(new FileReader(path));
		this.file = reader;
	}

	@Override
	public int getId() throws IOException {
		final int id = Integer.parseInt(file.readLine());
		configuration = getConfiguration(id);
		return id;
	}

	@Override
	public LocalDateTime getCreationDate() throws IOException {
		return LocalDateTime.parse(file.readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	@Override
	public String getName() throws IOException {
		return file.readLine();
	}

	@Override
	public List<Optional> readNextLine() throws IOException {

		if (file.ready()) {
			final String line = file.readLine();

			final List<Optional> returnLine = new ArrayList<>();

			if (line == "" || line == null || line.isEmpty()) {
				returnLine.add(Optional.empty());
				return returnLine;
			}

			final String[] data = line.split("\\t+");
			for (int i = 0; i < data.length; i++) {
				final Optional parse = configuration.get(i).parse(data[i]);
				if (parse.isPresent()) {
					returnLine.add(parse);
				}
			}
			return returnLine;
		}
		return null;
	}

	private List<Parser> getConfiguration(final int id) {
		Map<Integer, List<Parser>> configurations = new HashMap<>();
		configurations
				.put(1, Arrays.asList(new MyInteger(), new MyFloat(), new MyDate(), new MyString(), new MyInteger()));
		configurations.put(2,
				Arrays.asList(new MyInteger(), new MyFloat(), new MyDate(), new MyString(), new MyInteger(),
						new MyString()));
		configurations.put(3, Arrays.asList(new MyInteger(), new MyString()));

		return configurations.get(id);
	}
}
