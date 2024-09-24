package com.check.batch.steps.readers;

import com.check.batch.DTO.AppointmentBatch;
import com.check.batch.steps.filters.AppointmentMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class AppointmentReader {
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Bean
    public FlatFileItemReader<AppointmentBatch> getReader() {
        FlatFileItemReader<AppointmentBatch> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("checkwork/src/main/resources/appointments.csv"));
        itemReader.setName("CSV-Reader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(appointmentMapper.getMapperAppointment());
        return itemReader;
    }
}
