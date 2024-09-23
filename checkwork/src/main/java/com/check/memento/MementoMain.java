package com.check.memento;

import java.util.ArrayList;
import java.util.List;

public class MementoMain {
    public static void main(String[] args) {
        Paper paper = new Paper("aaa", "111");
        PaperTaker taker = new PaperTaker();
        taker.savePaper(paper, "State#1");
        Paper p2 = new Paper("aaa", "222");
        taker.savePaper(p2, "State#2");
        System.out.println(taker.getPaper("State#1"));

    }
}
