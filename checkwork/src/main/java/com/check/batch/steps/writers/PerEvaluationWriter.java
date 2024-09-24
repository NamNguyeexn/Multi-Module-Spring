package com.check.batch.steps.writers;

import com.check.models.PerEvaluation;
import com.check.repositories.JPARepository.PerEvaluationRepository;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PerEvaluationWriter {
    @Autowired
    private PerEvaluationRepository perEvaluationRepository;
    @Bean
    public RepositoryItemWriter<PerEvaluation> getWriter(){
        RepositoryItemWriter<PerEvaluation> writer = new RepositoryItemWriter<>();
        writer.setRepository(perEvaluationRepository);
        writer.setMethodName("save");
        return writer;
    }
}
