package com.arvind.service;

import java.util.List;

import com.arvind.entity.journals;

public interface JournalService {

	public journals saveJournals(journals j);

	public List<journals> getAllJournals();

	public journals getJournalsById(int id);

	public boolean deleteJournal(int id);

}
