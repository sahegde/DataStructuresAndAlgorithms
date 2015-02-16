import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class searchDocFiles {
	public void search_recursively(String file_name,String search_str) {
		LineNumberReader br = null;
		String sCurrentLine = null;
		try { 
			br = new LineNumberReader(new FileReader(file_name));
			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.indexOf(search_str) != -1) {
					System.out.println("Found in File: "+file_name+" String "+sCurrentLine+" Line no "+br.getLineNumber()+"\\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		searchDocFiles workerObj = new searchDocFiles();
		Scanner readObj = new Scanner(System.in);
		System.out.println("Enter the Search String");
		String search_str = readObj.nextLine();
		try {
			Path dir = FileSystems.getDefault().getPath("C:\\Users\\sahegde\\Desktop\\PayPal\\gitHubRepo\\InfoRepo\\");
			DirectoryStream<Path> stream = Files.newDirectoryStream( dir );
			for(Path path : stream) {
				workerObj.search_recursively("C:\\Users\\sahegde\\Desktop\\PayPal\\gitHubRepo\\InfoRepo\\"+path.getFileName().toString(),search_str);
			}
			stream.close();
		}
		catch(Exception e) {
			
		}
	}
}
