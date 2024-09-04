package com.check.proxy;

import com.check.proxy.impl.IReportImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportProxy implements IReport{
    private final IReportImpl iReport;
    public ReportProxy(IReportImpl report){
        this.iReport = report;
    }
    public boolean condition(){
        return true;
    }
    @Override
    public String createReport() {
        return condition() ? "Creating " + iReport.createReport() : "Waiting";
    }
}
