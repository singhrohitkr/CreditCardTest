package fileReader;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.xml.xpath.XPath;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileName {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path basePath = Paths.get("D:\\Downloads");
		String pattern = "bluetooth_dch_intel_win10_64_ver206004";
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:"+ pattern + "*" );
		Stream <Path> subPath = Files.walk(basePath,1);
		Stream <Path> fileNames = Files.list(basePath);
		File home = new File("D:\\Downloads");
		FilenameFilter test = (dir, name) -> {
			String lowerCaseFileName = name.toLowerCase();

			if (lowerCaseFileName.contains(pattern)) {
				//System.out.println(lowerCaseFileName);
				//System.out.println("true");
				return true;
			} else {
				//System.out.println("false");
				return false;
			}
		};

		//List of all files name as pattern
			List <String> resultList = Arrays.asList(home.list(test));
			resultList.forEach(System.out::println);

		}


		

	}
//subPath.filter(Files::isRegularFile).forEach(System.out::println);
		/*List<String> result = subPath.filter(Files::isRegularFile)
				.map(x -> x.toString()).collect(Collectors.toList());
		result.forEach(System.out::println);*/
		/*List<String> result= fileNames.filter(Files::isRegularFile)
				.map(x -> x.toString()).collect(Collectors.toList());
		result.forEach(System.out::println);*/

