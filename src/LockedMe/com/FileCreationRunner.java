package LockedMe.com;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileCreationRunner {
	Path path;

	public void createDirectory() {
		this.path = Paths.get("./resources/UserFiles");
		try {
			Files.createDirectories(path);
			System.out.println("Directory is created");
		} catch (IOException e) {
			System.out.println("Failed to crete directory!");
			e.printStackTrace();
		}
		// return path
	}

	public Path getdirectoPath() {
		return this.path;
	}

	public void createFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Name You Want To Create ");
		String fileName = sc.next();
		Path newFilePath = Paths.get(this.path + "/" + fileName);
		try {
			Files.createFile(newFilePath);
			System.out.println("File Created Sucessfully");
		} catch (FileAlreadyExistsException e) {
			System.out.println("File Already Exist !! Enter new File Name ");
			this.createFile();
		}

		catch (IOException e) {
			System.out.println("Failed To Create File");
			e.printStackTrace();
		}
	}

	public void listAllFiles() {
		String dir = this.path.toString();
		File[] listOfFiles = new File(dir).listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				System.out.println(file.getName());
			} else if (file.isFile()) {
				System.out.println(file.getName());
			}

		}

	}

	public void deleteFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Name You Want To Delete ");
		String fileToDelete = sc.next();
		Path deleteFilePath = Paths.get(this.path + "/" + fileToDelete);
		try {
			Files.delete(deleteFilePath);
			System.out.println("File Deleted sucessfully");
		} catch (NoSuchFileException e) {
			System.out.println("No Such File Exist!! Enter new file name to delete");
			this.deleteFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void listAllFilesAscending() {
		String dir = this.path.toString();
		File[] listOfFiles = new File(dir).listFiles();
		List<File> listFiles = Arrays.asList(listOfFiles);
		Collections.sort(listFiles);
		Iterator<File> it = listFiles.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getName());
		}
		
	}
	public void searchFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Name You Want To Search ");
		String fileToSearch = sc.next();
		Path searchFilePath = Paths.get(this.path + "/" + fileToSearch);
		if (Files.exists(searchFilePath)) {
			
			if (Files.isRegularFile(searchFilePath)) {
				System.out.println("File Exist");
				
			}
			if (Files.isDirectory(searchFilePath)) {
				System.out.println("File Exist But it is a Directory.");
			}
			
		}else {
			System.out.println("File Doest Exist!!!!!!");
		}
		
		
	}
}
