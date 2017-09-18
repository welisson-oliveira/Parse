package br.com.welisson.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * {@link Write}
 *
 * @author Welisson Oliveira
 * @version 1.0 16/09/2017
 */
public class Write extends StandardReading{
	final BufferedWriter writer;

	public Write(){
		String absolutePath = new File("src/copy.txt").getAbsolutePath();
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(absolutePath, true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.writer = new BufferedWriter(fileWriter);

	}

	@Override protected void id(final int id) {
		try {
			writer.write(id+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override protected void name(final String name) {
		try {
			writer.write(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override protected void creationDate(final LocalDateTime creationDate) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		try {
			writer.write(creationDate.format(formatter));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override protected void columnData(final Optional data) {

		try {
			writer.write(data.get().toString()+"\t");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override protected void nextLine() {
		try {
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override protected void end() {

		try {
			writer.flush();
			writer.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
