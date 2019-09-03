package br.com.pla.backend;

import java.util.List;

import br.com.pla.backend.Reader.IRead;
import br.com.pla.backend.Reader.ReadLocalFile;
import br.com.pla.backend.Reader.ReadRemoteJson;
import br.com.pla.backend.entity.ContaCorrente;
import br.com.pla.backend.entity.Entry;

public class App {

	public static void main(String[] args) {
		ContaCorrente contaCorrente = new ContaCorrente();
		
		// TODO move db.log path to a configuration file
		IRead readLogFile = new ReadLocalFile();
		List<Entry> lines = readLogFile.getEntries("/home/juanpla/workspace/backend-test/db.log");
		contaCorrente.addAllEntries(lines);
		
		IRead readPagamentos = new ReadRemoteJson();
		lines = readPagamentos.getEntries("https://my-json-server.typicode.com/cairano/backend-test/pagamentos");
		contaCorrente.addAllEntries(lines);
		
		//TODO Read from https://my-json-server.typicode.com/cairano/backend-test/recebimentos
		
		//TODO Read from https://my-json-server.typicode.com/cairano/backend-test/db
		
		
		//TODO exibir o log de movimentações de forma ordenada;
		//TODO informar o total de gastos por categoria;
		//TODO informar qual categoria cliente gastou mais;
		//TODO informar qual foi o mês que cliente mais gastou;
		//TODO quanto de dinheiro o cliente gastou;
		//TODO quanto de dinheiro o cliente recebeu;
		//TODO saldo total de movimentações do cliente
	}

}
