package com.check.configs;

//import com.check.batch.DTO.AppointmentBatch;
//import com.check.batch.DTO.WorkHourBatch;
import com.check.batch.steps.AppointmentToScheduleStep;
import com.check.batch.steps.UserStateToUserStep;
import com.check.batch.steps.WorkHourToPerEvaluationStep;
//import com.check.batch.steps.processors.ScheduleProcessor;
//import com.check.batch.steps.processors.UserStateProcessor;
//import com.check.batch.steps.processors.WorkHourProcessor;
//import com.check.models.*;
//import com.check.repositories.JPARepository.PerEvaluationRepository;
//import com.check.repositories.JPARepository.ScheduleRepository;
//import com.check.repositories.JPARepository.UserStateRepository;
import com.common.configs.DatabaseConfig;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.data.RepositoryItemWriter;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.PagingQueryProvider;
//import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
//import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.transaction.PlatformTransactionManager;

//import javax.sql.DataSource;


@Configuration
@Import({DatabaseConfig.class})
public class BatchConfiguration {
//    @Autowired
//    private JobRepository jobRepository;
//    @Autowired
//    private PlatformTransactionManager platformTransactionManager;
//    @Autowired
//    private ScheduleRepository scheduleRepository;
//    @Autowired
//    private UserStateRepository userStateRepository;
//    @Autowired
//    private PerEvaluationRepository perEvaluationRepository;
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private PagingQueryProvider queryProvider;
    @Autowired
    public AppointmentToScheduleStep appointmentToScheduleStep;
    @Autowired
    private UserStateToUserStep userStateToUserStep;
    @Autowired
    private WorkHourToPerEvaluationStep workHourToPerEvaluationStep;
//    @Bean
//    public FlatFileItemReader<AppointmentBatch> appointmentReader() {
//        FlatFileItemReader<AppointmentBatch> itemReader = new FlatFileItemReader<>();
//        itemReader.setResource(new FileSystemResource("checkwork/src/main/resources/appointments.csv"));
//        itemReader.setName("CSV-Reader");
//        itemReader.setLinesToSkip(1);
//        itemReader.setLineMapper(lineMapperAppointment());
//        return itemReader;
//    }
//
//    @Bean
//    public JdbcPagingItemReader<User> userReader() throws Exception {
//        SqlPagingQueryProviderFactoryBean queryProviderFactoryBean = queryProviderUserState();
//        PagingQueryProvider queryProvider = queryProviderFactoryBean.getObject();
//        assert queryProvider != null;
//        return new JdbcPagingItemReaderBuilder<User>()
//                .name("pagingUserReader")
//                .dataSource(dataSource)
//                .queryProvider(queryProvider)
//                .rowMapper(new BeanPropertyRowMapper<>(User.class))
//                .pageSize(1000)
//                .build();
//    }
//
//    @Bean
//    public JdbcPagingItemReader<WorkHourBatch> workHourReader() throws Exception {
//        SqlPagingQueryProviderFactoryBean queryProviderFactoryBean = queryProviderPerEvaluation();
//        PagingQueryProvider queryProvider = queryProviderFactoryBean.getObject();
//        assert queryProvider != null;
//        return new JdbcPagingItemReaderBuilder<WorkHourBatch>()
//                .name("pagingUserReader")
//                .dataSource(dataSource)
//                .queryProvider(queryProvider)
//                .rowMapper(new BeanPropertyRowMapper<>(WorkHourBatch.class))
//                .pageSize(1000)
//                .build();
//    }
//
//
//    @Bean
//    public ScheduleProcessor scheduleProcessor() {
//        return new ScheduleProcessor();
//    }
//
//    @Bean
//    public UserStateProcessor userStateProcessor(){
//        return new UserStateProcessor();
//    }
//
//    @Bean
//    public WorkHourProcessor workHourProcessor(){
//        return new WorkHourProcessor();
//    }
//
//    @Bean
//    public RepositoryItemWriter<Schedule> scheduleWriter() {
//        RepositoryItemWriter<Schedule> writer = new RepositoryItemWriter<>();
//        writer.setRepository(scheduleRepository);
//        writer.setMethodName("save");
//        return writer;
//    }
//
//    @Bean
//    public RepositoryItemWriter<UserState> userStateWriter(){
//        RepositoryItemWriter<UserState> writer = new RepositoryItemWriter<>();
//        writer.setRepository(userStateRepository);
//        writer.setMethodName("save");
//        return writer;
//    }
//
//    @Bean
//    public RepositoryItemWriter<PerEvaluation> perEvaluationWriter(){
//        RepositoryItemWriter<PerEvaluation> writer = new RepositoryItemWriter<>();
//        writer.setRepository(perEvaluationRepository);
//        writer.setMethodName("save");
//        return writer;
//    }
//
//    @Bean
//    public Step appointmentToScheduleStep() {
//        return new StepBuilder("appointments", jobRepository)
//                .<AppointmentBatch, Schedule>chunk(1000, platformTransactionManager)
//                .reader(appointmentReader())
//                .processor(scheduleProcessor())
//                .writer(scheduleWriter())
//                .taskExecutor(taskExecutor())
//                .build();
//    }
//
//    @Bean Step userStateToUserStep() throws Exception {
//        return new StepBuilder("userState", jobRepository)
//                .<User, UserState>chunk(1000, platformTransactionManager)
//                .reader(userReader())
//                .processor(userStateProcessor())
//                .writer(userStateWriter())
//                .taskExecutor(taskExecutor())
//                .build();
//    }
//
//    @Bean Step workHourToPerEvaluationStep() throws Exception {
//        return new StepBuilder("userState", jobRepository)
//                .<WorkHourBatch, PerEvaluation>chunk(1000, platformTransactionManager)
//                .reader(workHourReader())
//                .processor(workHourProcessor())
//                .writer(perEvaluationWriter())
//                .taskExecutor(taskExecutor())
//                .build();
//    }
//
//
//    @Bean
//    @Qualifier("schedule")
//    public Job runJobSchedule() throws Exception {
//        return new JobBuilder("importSchedules", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(appointmentToScheduleStep())
//                .build();
//    }
//
//    @Bean
//    @Qualifier("userstate")
//    public Job runJobUserState() throws Exception {
//        return new JobBuilder("importUserStates", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(userStateToUserStep())
//                .build();
//    }
//
//    @Bean
//    @Qualifier("perevaluation")
//    public Job runJobPreEvaluation() throws Exception {
//        return new JobBuilder("importPreEvaluations", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(workHourToPerEvaluationStep())
//                .build();
//    }
//
//
//
//    @Bean
//    public TaskExecutor taskExecutor() {
//        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
//        asyncTaskExecutor.setConcurrencyLimit(10);
//        return asyncTaskExecutor;
//    }
//
//    private DefaultLineMapper<AppointmentBatch> lineMapperAppointment() {
//        DefaultLineMapper<AppointmentBatch> lineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setStrict(false);
//        lineTokenizer.setNames("id", "name", "hostid", "joinid", "start", "end", "detail", "type", "room", "info");
//        BeanWrapperFieldSetMapper<AppointmentBatch> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(AppointmentBatch.class);
//        lineMapper.setLineTokenizer(lineTokenizer);
//        lineMapper.setFieldSetMapper(fieldSetMapper);
//        return lineMapper;
//    }
//
//    @Bean
//    public SqlPagingQueryProviderFactoryBean queryProviderUserState() {
//        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
//        queryProvider.setDataSource(dataSource);
//        queryProvider.setSelectClause("select *");
//        queryProvider.setFromClause("from user");
//        queryProvider.setSortKey("id");
//        return queryProvider;
//    }
//
//    @Bean
//    public SqlPagingQueryProviderFactoryBean queryProviderPerEvaluation() {
//        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
//        queryProvider.setDataSource(dataSource);
//        queryProvider.setSelectClause("select *");
//        queryProvider.setFromClause("from workhour");
//        queryProvider.setSortKey("id");
//        return queryProvider;
//    }
}