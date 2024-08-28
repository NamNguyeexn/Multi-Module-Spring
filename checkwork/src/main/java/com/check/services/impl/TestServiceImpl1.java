package com.check.services.impl;

//import com.check.services.TestService;
import com.check.services.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

        import java.util.Stack;

import static java.lang.Thread.currentThread;

@Service
@Slf4j
@Qualifier("Service1")
public class TestServiceImpl1 implements ITestService {
    private static final String hello = "HELLO FROM TEST SERVICE 1 - INTEGER ";
    private static final Stack<Integer> st = new Stack<Integer>();
    public String getHello(){
        return hello + " AT THREAD " + currentThread().getName();
    }
    @Override
    public String getData() {
        StringBuilder res = new StringBuilder();
        if (st.empty()) return res.append("NULL").toString();
        while(!st.empty()) {
            int mid = st.pop();
            res.append(mid).append(" ");
        }
        return res.toString();
    }
    @Override
    public void addData() {
        for (int i = 0; i < 5; i++){
            st.push(i);
        }
    }
}
