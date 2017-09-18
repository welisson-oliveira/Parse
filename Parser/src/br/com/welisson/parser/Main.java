package br.com.welisson.parser;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String... args) {
		final String fileName1 = new File("src/document.txt").getAbsolutePath();
		final String fileName2 = new File("src/document2.txt").getAbsolutePath();
		final String fileName3 = new File("src/document3.txt").getAbsolutePath();
		//		final String fileName4 = new File("src/document_too_large.txt").getAbsolutePath();

		final List<String> paths = Arrays.asList(fileName1, fileName2, fileName3);
		//		final List<String> paths = Arrays.asList(fileName4);

		paths.forEach(path -> new Print().read(path));
		paths.forEach(path -> new Write().read(path));

	}

}