package com.check.chain_of_responsibility.repository;

import com.check.chain_of_responsibility.models.ENUM.Category;
import com.check.chain_of_responsibility.models.Payslip;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface PayslipRepository extends JpaRepository<Payslip, Integer>, JpaSpecificationExecutor<Payslip> {
    interface Specs{
        static Specification<Payslip> byId(int id){
            return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id"), id);
        }
        static Specification<Payslip> byUsername(String username){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("username"), username)
            ;
        }
        static Specification<Payslip> byAfterTime(LocalDate time){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("time"), time)
            ;
        }
        static Specification<Payslip> byType(Category category){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("category"), category)
            ;
        }
        static Specification<Payslip> byValue(long value){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("value"), value)
            ;
        }
    }
}
