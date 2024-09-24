package com.check.batch.steps.filters;

import com.check.batch.DTO.AppointmentBatch;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public DefaultLineMapper<AppointmentBatch> getMapperAppointment() {
        DefaultLineMapper<AppointmentBatch> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "name", "hostid", "joinid", "start", "end", "detail", "type", "room", "info");
        BeanWrapperFieldSetMapper<AppointmentBatch> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(AppointmentBatch.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
}
