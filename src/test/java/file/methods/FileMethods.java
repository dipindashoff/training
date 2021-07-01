package file.methods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import junit.framework.Assert;

public class FileMethods {

	public static void main(String[] args) {

		try {
			// Create a New File
			new File("D://hi.txt").createNewFile();

			// Write into the file
			BufferedWriter bw = new BufferedWriter(new FileWriter("F://hi.txt"));
			bw.write("I <3 Spidey");
			bw.flush();

			// Read File
			List<String> list = new ArrayList<>();
			Stream<String> stream = Files.lines(Paths.get("F://hi.txt"));
			list = stream.collect(Collectors.toList());

			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
