package com.check.configs;

import com.check.batch.AppointmentBatch;
import com.check.batch.ScheduleProcessor;
import com.check.models.Appointment;
import com.check.models.Schedule;
import com.check.repositories.JPARepository.ScheduleRepository;
import com.common.configs.DatabaseConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@Import({DatabaseConfig.class})
public class BatchConfiguration {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private ScheduleRepository repository;

    @Bean
    public FlatFileItemReader<AppointmentBatch> reader() {
        FlatFileItemReader<AppointmentBatch> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("checkwork/src/main/resources/appointments.csv"));
        itemReader.setName("CSV-Reader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    @Bean
    public ScheduleProcessor processor() {
        return new ScheduleProcessor();
    }

    @Bean
    public RepositoryItemWriter<Schedule> writer() {
        RepositoryItemWriter<Schedule> writer = new RepositoryItemWriter<>();
        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1() {
        return new StepBuilder("appointments.csv", jobRepository)
                .<AppointmentBatch, Schedule>chunk(1000, platformTransactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job runJob() {
        return new JobBuilder("importSchedules", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();

    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

    private DefaultLineMapper<AppointmentBatch> lineMapper() {
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
