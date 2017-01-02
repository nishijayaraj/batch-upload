package com.space.batch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpload {
	
	public static void main(String[] args) throws IOException, SQLException {
		
		String line = "";
		String delimiter = ",";
	    int count = 1;
	    DBConnector.createConnection();
		Connection dbConn = DBConnector.getDBConnection();
		System.out.println(dbConn);
		PreparedStatement ps = DBConnector.getPSInstance();
		dbConn.setAutoCommit(false);
		String inputFile = "input.csv";
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		 while ((line = br.readLine()) != null) {
				String[] entities = line.split(delimiter);
				try {
                    ps.setString(1,entities[0]);
                    ps.setString(2,entities[1]);
                    ps.setString(3,entities[2]);
					
					ps.addBatch();
                    if(count%1000==0){
					ps.executeBatch();
					dbConn.commit();
					}
                    count++;
					
					System.out.println("Records are inserted into DBUSER table!");

				} catch (SQLException e) {

					System.out.println(e.getMessage());

				}
		 
		 }
		 dbConn.close();

	}
	
	


}
