
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderInJava 
{
	public static void main(String... args)
	{
		List<String> csv = readFromCSV("Igotthisfromawebsite.txt");
		
		for (String s : csv)
		{
			System.out.println(s);
		}
	}

	public static List<String> readFromCSV(String filename)
	{
		List<String> something = new ArrayList<>();
		Path pathToFile = Paths.get(filename);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
		{
			String line = br.readLine();
			
			while (line != null)
			{
				String[] elements = line.split(",");
				
				for (String s: elements)
				{
					something.add(s);
				}
				
				line = br.readLine();
			}
		}
		
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return something;
	}
}
