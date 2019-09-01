package br.com.pla.backend.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.pla.backend.Reader.IRead;
import br.com.pla.backend.Reader.ReadLocalFile;
import br.com.pla.backend.entity.Entry;

class ReadLocalFileTest {
	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void test() {
		IRead readLogFile = new ReadLocalFile();
		List<Entry> lines = readLogFile.getEntries("/home/juanpla/workspace/backend-test/db.log");
		assertEquals(20, lines.size());
	}

}
