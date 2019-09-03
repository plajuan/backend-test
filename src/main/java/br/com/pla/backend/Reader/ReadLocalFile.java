package br.com.pla.backend.Reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.pla.backend.entity.Entry;

public class ReadLocalFile implements IRead{

	@Override
	public List<Entry> getEntries(String path) {
		List<Entry> lista = new ArrayList<Entry>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			lista = stream.skip(1).map( line ->  new Entry(line.split("\\t")) ).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}
