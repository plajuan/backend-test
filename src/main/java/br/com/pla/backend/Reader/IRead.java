package br.com.pla.backend.Reader;

import java.util.List;

import br.com.pla.backend.entity.Entry;

public interface IRead {
	public List<Entry> getEntries(String path);
}
