package com.nagarro.training.TshirtData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class Data extends Thread {
	private  static final int INTERVAL = 1000;

	public void run() {
		while (true) {
			try {
				readCSV();
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	private void readCSV() {
		{
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			for (File csvFile : CSVFileList()) {
				try {

					FileReader filereader = new FileReader(csvFile);
					CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
					CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
					csvReader.skip(1);

					List<String[]> rows = csvReader.readAll();
					for (String[] row : rows) {
						TshirtData data = new TshirtData(row[0], row[1], row[2], row[3],row[4],
								Double.parseDouble(row[5]), Double.parseDouble(row[6]), row[7].charAt(0));
						session.save(data);
					}
					csvReader.close();

				} catch (IOException | CsvException e) {
					e.printStackTrace();
				}
			}	

			String tableName = "tshirts";
			String sql = String.format("TRUNCATE TABLE %s", tableName);
			session.createNativeQuery(sql).executeUpdate();

			transaction.commit();
			session.close();
			factory.close();
		}

	}

	private static List<File> CSVFileList() {
		final String loc="C:\\Users\\prakharsrivastava01\\eclipse-workspace\\TshirtRecommendation\\resources";
		File directory = new File(loc);
		File[] files = directory.listFiles();
		List<File> csvFiles = new ArrayList<>();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".csv")) {
				csvFiles.add(file);
			}
		}
		return csvFiles; 
	}
}
