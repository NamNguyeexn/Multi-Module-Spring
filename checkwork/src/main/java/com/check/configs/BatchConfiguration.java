//package com.check.configs;
//
//import com.check.adapters.ScheduleAdapter;
//import com.check.listeners.JobCompletionNotificationListener;
//import com.check.models.Appointment;
//import com.check.models.Schedule;
//import com.check.processors.ScheduleItemProcessor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//import java.nio.charset.StandardCharsets;
//
//import static java.nio.file.Files.lines;
//
//@Configuration
//public class BatchConfiguration {
//    @Autowired
//    private ScheduleAdapter scheduleAdapter;
//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean
//    public FlatFileItemReader<Schedule> reader() {
//        return new FlatFileItemReaderBuilder<Schedule>()
//                .name("scheduleItemReader")
//                .resource(resource)
//                .delimited()
//                .names("name", "hostid", "joinid", "start", "end", "detail", "type", "room", "info")
//                .targetType(Schedule.class)
//                .build();
//    }
//
//    @Bean
//    public ScheduleItemProcessor processor() {
//        return new ScheduleItemProcessor();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Schedule> writer(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<Schedule>()
//                .sql("INSERT INTO schedule (hostname, joinname, start, end, type, detail) " +
//                        "VALUES (:hostname, :joinname, :start, :end, :type, :detail)")
//                .dataSource(dataSource)
//                .beanMapped()
//                .build();
//    }
//
//    @Bean
//    public Job importUserJob(JobRepository jobRepository, Step step1, JobCompletionNotificationListener listener) {
//        return new JobBuilder("importScheduleJob", jobRepository)
//                .listener(listener)
//                .start(step1)
//                .build();
//    }
//    @Bean
//    public Step step1(JobRepository jobRepository,
//                      DataSourceTransactionManager transactionManager,
//                      FlatFileItemReader<Appointment> reader,
//                      ScheduleItemProcessor processor,
//                      JdbcBatchItemWriter<Schedule> writer) {
//        return new StepBuilder("step1", jobRepository)
//                .<Appointment, Schedule> chunk(3, transactionManager)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
//}
