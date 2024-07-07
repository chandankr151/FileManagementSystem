package com.fileManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManagementSystem {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		System.out.println("=================Welcome to FileManagementSystem=========================");

		boolean flag = true;

		do {

			System.out.println("1. Create File");
			System.out.println("2. Write into file");
			System.out.println("3. Read from file");
			System.out.println("4. Exit");

			System.out.print("\n\nEnter Your choice: ");
			int choice = s.nextInt();
			// s.close();

			switch (choice) {
			case 1:
				createFile();
				break;
			case 2:
				writeIntoFile();
				break;
			case 3:
				readFromFile();
				break;
			case 4:
				flag = false;
				System.out.println("Thank you.");
				break;
			default:
				System.out.println("Invalid Input\nTry Again!!!\n\n");
			}

		} while (flag);
	}

	private static void readFromFile() throws Exception {
		FileReader fr = new FileReader("FileContainer\\fileSystem.txt");
		BufferedReader br = new BufferedReader(fr);

		String data = br.readLine();
		while (data != null) {
			System.out.println(data);
			data = br.readLine();
		}
		br.close();
	}

	private static void writeIntoFile() throws Exception {
		FileWriter fr = new FileWriter("FileContainer\\fileSystem.txt", true);
		PrintWriter pr = new PrintWriter(fr);

		s.nextLine();
		System.out.print("\nEnter data to write into file: ");
		String data = s.nextLine();

		pr.write(data);
		pr.flush();
		pr.close();
		System.out.println("Your containt written into file successfully.\nThank you.");
	}

	private static void createFile() throws Exception {

		File file = new File("FileContainer");

		if (file.exists()) {
			System.out.println("Directory already exists: \n\n");
		} else {
			file.mkdir();
			FileWriter fr = new FileWriter("FileContainer\\fileSystem.txt", true);
			System.out.println("File Created Successfully\n\n");
			fr.close();
		}
	}
}