/**
 * Simple Utility for reading text file
 * This utility may be used if you want to file content as Text or as List of lines
 * @author java at heart
 */
package com.codekata.trigram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TextFileReader {

	private final String fileName;
	private final StringBuilder fileData;
	private Boolean lowerCaseMode = new Boolean(false);
	private final static String LINE_SEPARATOR = System.getProperty("line.separator");

	public TextFileReader(String fileName){
		fileData = new StringBuilder();
		this.fileName = fileName;
	}

	public Boolean isLowerCaseMode() {
		return lowerCaseMode;
	}

	public void setLowerCaseMode(Boolean lowerCaseMode) {
		this.lowerCaseMode = lowerCaseMode;
	}

	private void readFile() {

		BufferedReader fin = null;
		try {
			fin = new BufferedReader(new FileReader(fileName));
			String line = fin.readLine();
			while(line != null) {
				if(lowerCaseMode){
					line = line.toLowerCase();
				}
				fileData.append(line).append(LINE_SEPARATOR);
				line = fin.readLine();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		// TODO close the file Input stream
	}

	public String getFileContent() {
		readFile();
		return fileData.toString();
	}
	public List<String> getFileContentList() {
		readFile();
		final String lines[] = fileData.toString().split(LINE_SEPARATOR);
		return new ArrayList<String>(Arrays.asList(lines));
	}
}