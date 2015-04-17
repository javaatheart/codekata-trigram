package com.codekata.trigram;

import java.util.List;
/**
 * @author java_at_heart
 *
 */
public final class TrigramGenerator {

	public static void main(String[] args) {

		final TextFileReader fileReader = new TextFileReader("story.txt");
		fileReader.setLowerCaseMode(true);
		final List<String> fileLines = fileReader.getFileContentList();
		final Trigram trigramFinal = new Trigram();

		for(final String line : fileLines){
			trigramFinal.putAll(generateTrigrams(line));
		}
		System.out.println(trigramFinal);
	}

	public static Trigram generateTrigrams(String line) {

		final Trigram trigram = new Trigram();
		// Replace multiple spaces with single space with regex
		final String[] words = line.replaceAll("[ ]+", Trigram.SPACE).split(Trigram.SPACE);
		final int last = words.length - 3;

		for (int index = 0; index <= last; index++) {
			trigram.put(words[index], words[index + 1], words[index + 2]);
		}
		return trigram;
	}
}