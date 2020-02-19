package fileReader;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileV2 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Path basePath = Paths.get("D:\\Downloads");
       // Stream<Path> subPath = Files.walk(basePath, 1).filter(Files::isRegularFile);
        String destination = "D:\\Downloads\\Bills";
        String source = "D:\\Downloads";
        //String pattern = "SearchTicket";
        Stream<String> inputData = Files.lines(Paths.get("D://Downloads//test.txt"));
        List<String> baseData = inputData.map(x -> x.toString()).collect(Collectors.toList());
        List <String> listFinal = new ArrayList<>();
        for(String input : baseData){
            Stream<Path> subPath = Files.walk(basePath, 1).filter(Files::isRegularFile);
            List<String> result = subPath.map(x -> x.getFileName().toString())
                    .filter(f -> f.contains(input)).collect(Collectors.toList());
            listFinal.addAll(result);
            }
        listFinal.forEach(System.out::println);

        int i = 0;
        for (String results : listFinal) {

            String newD = destination+"\\"+ results;
            String newS = source+"\\"+results;
            Files.move(Paths.get(newS), Paths.get(newD), StandardCopyOption.REPLACE_EXISTING);
            i++;
        }
System.out.println(i);
    }
}
