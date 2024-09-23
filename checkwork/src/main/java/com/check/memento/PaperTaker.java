package com.check.memento;

import java.util.HashMap;
import java.util.Map;

public class PaperTaker {
    private final Map<String, Paper> savedPapers = new HashMap<>();
    public void savePaper(Paper paper, String savedName) {
        savedPapers.put(savedName, paper);
    }
    public Paper getPaper(String savedName) {
        return savedPapers.get(savedName);
    }
    public void clearSavedPapers() {
        savedPapers.clear();
    }
}
