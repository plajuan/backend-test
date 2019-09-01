package br.com.pla.backend.entity;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {
	private List<Entry> entries = new ArrayList<Entry>();
	
	public void addEntry(Entry entry) {
		entries.add(entry);		
	}
	
	public void addAllEntries(List<Entry> entries) {
		this.entries.addAll(entries);
	}
}
