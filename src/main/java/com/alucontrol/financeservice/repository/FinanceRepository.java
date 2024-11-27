package com.alucontrol.financeservice.repository;

import com.alucontrol.financeservice.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long> {
}
