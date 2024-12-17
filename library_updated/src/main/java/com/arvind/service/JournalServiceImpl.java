package com.arvind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.arvind.entity.journals;
import com.arvind.repository.JournalRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepo;

    @Override
    public journals saveJournals(journals journal) {
        return journalRepo.save(journal);
    }

    @Override
    public List<journals> getAllJournals() {
        return journalRepo.findAll();
    }

    @Override
    public journals getJournalsById(int id) {
        return journalRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJournal(int id) {
        if (journalRepo.existsById(id)) {
            journalRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public void removeSessionMessage() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest().getSession();
        session.removeAttribute("msg");
    }
}
