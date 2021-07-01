package exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TryWithResources {

	public static void main(String[] args) {

		// Read from a file
		String fileName = "C://Users//Dipin//Downloads//lines.txt";

		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			// 1. filter line 3
			// 2. convert all content to upper case
			// 3. convert it into a List
			list = stream
					.filter(line -> !line.startsWith("line3"))
					.map(String::toUpperCase)
					.collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);

		System.out.println();
		List<String> list2 = new ArrayList<>();
		try (Stream<String> stream2 = Files.lines(Paths.get(fileName))) {
			
			list2 = stream2
					.filter(line -> !line.startsWith("line3"))
					.map(String::toUpperCase)
					.map(x-> x.toLowerCase())
					.collect(Collectors.toList());
			
			
			list2.forEach(System.out::println);
					

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
