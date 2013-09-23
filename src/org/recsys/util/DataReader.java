package org.recsys.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

public class DataReader {
	
	private DataGrid ratingGrid = new DataGrid();
		
	public void readData(String dataFile) throws IOException {
		
		CSVReader csvReader = new CSVReader(new FileReader(dataFile));
		String [] nextLine;
		
		// stores userId, movieId, rating data in the DataGrid
		while( (nextLine = csvReader.readNext()) != null) {
			ratingGrid.putData(nextLine[0], nextLine[1], nextLine[2]);
		}
	}
}
