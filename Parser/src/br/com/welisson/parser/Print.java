package br.com.welisson.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * {@link Print}
 *
 * @author Welisson Oliveira
 * @version 1.0 16/09/2017
 */
public class Print extends StandardReading {

	@Override protected void end() {
		System.out.println("Fim do arquivo!\n");
	}

	@Override protected void name(final String name) {
		print(Optional.of(name));
	}

	@Override protected void columnData(final Optional data) {
		print(data);
	}

	@Override protected void nextLine() {
		print(Optional.empty());
	}

	@Override protected void creationDate(final LocalDateTime creationDate) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		print(Optional.of(creationDate.format(formatter)));
	}

	@Override protected void id(int id) {
		print(Optional.of(id));
	}

	private void print(final Optional<?> data){
		if(data.isPresent()) {
			System.out.print(data.get().toString()+"\t");
		}else {
			System.out.print("\n");
		}
	}
}
