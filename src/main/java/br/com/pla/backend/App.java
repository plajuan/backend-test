package br.com.pla.backend;

import java.util.List;

import br.com.pla.backend.Reader.IRead;
import br.com.pla.backend.Reader.ReadLocalFile;
import br.com.pla.backend.Reader.ReadRemoteJson;
import br.com.pla.backend.entity.Entry;

public class App {

	public static void main(String[] args) {
		// TODO Read from log file
		IRead readLogFile = new ReadLocalFile();
		List<Entry> lines = readLogFile.getEntries("/home/juanpla/workspace/backend-test/db.log");
System.out.println(lines.size());
		//TODO Read from https://my-json-server.typicode.com/cairano/backend-test/pagamentos
		IRead readPagamentos = new ReadRemoteJson();
		lines = readPagamentos.getEntries("https://my-json-server.typicode.com/cairano/backend-test/pagamentos");
		
		//TODO Read from https://my-json-server.typicode.com/cairano/backend-test/recebimentos
		
		//TODO Read from https://my-json-server.typicode.com/cairano/backend-test/db

	}

}
