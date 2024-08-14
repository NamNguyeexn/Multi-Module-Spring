package com.check.services.impl;

import com.check.services.TestService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Stack;

import static java.lang.Thread.currentThread;

@Service
@Qualifier("Service2")
public class TestServiceImpl2 implements TestService {
    private static final String hello = "HELLO FROM TEST SERVICE 2 - STRING ";
    private static final Stack<String> st = new Stack<>();
    public String getHello(){
        return hello + " AT THREAD " + currentThread().getName();
    }
    @Override
    public String getData() {
        StringBuilder res = new StringBuilder();
        if (st.empty()) return res.append("NULL").toString();
        while(!st.empty()) {
            String mid = st.pop();
            res.append(mid).append(" ");
        }
        return res.toString();
    }
    @Override
    public void addData() {
        for (int i = 0; i < 5; i++){
            st.add(String.valueOf('a' + i));
        }
    }
}
