package br.com.welisson.parser.proxy;

import java.time.LocalDateTime;

/**
 * {@link Document}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/09/2017
 */
public class Document {

	private final int id;
	private final LocalDateTime creationDate;
	private final String name;

	public Document(final int id, final LocalDateTime creationDate, final String name){
		this.id = id;
		this.creationDate = creationDate;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getName() {
		return name;
	}

}
