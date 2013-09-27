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
	
	private DataGrid ratingGrid; 
	
	public DataReader() {
		ratingGrid = new DataGrid();
	}
	
	public DataGrid readData(String dataFile) throws IOException {
		
		CSVReader csvReader = new CSVReader(new FileReader(dataFile));
		String [] nextLine;
		
		// stores userId, movieId, rating data in the DataGrid
		while( (nextLine = csvReader.readNext()) != null) {
			ratingGrid.putData(Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1]), Double.parseDouble(nextLine[2]));
		}
		return ratingGrid;
	}
	
	public DataGrid getRatingGrid() {
		return this.ratingGrid;
	}
}
