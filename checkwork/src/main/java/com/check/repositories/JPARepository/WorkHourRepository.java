package com.check.repositories.JPARepository;

import com.check.models.WorkHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
//@EnableJpaRepositories
public interface WorkHourRepository extends JpaRepository<WorkHour, Integer>, JpaSpecificationExecutor<WorkHour> {
}
