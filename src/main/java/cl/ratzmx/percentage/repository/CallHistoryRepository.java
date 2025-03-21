package cl.ratzmx.percentage.repository;

import cl.ratzmx.percentage.domain.entities.CallHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface CallHistoryRepository extends JpaRepository<CallHistory, Long>{

  @Query("SELECT c FROM CallHistory c WHERE (:startDate IS NULL OR CAST(c.timestamp AS date) >= :startDate) " +
          "AND (:endDate IS NULL OR CAST(c.timestamp AS date) <= :endDate)")
  Page<CallHistory> findWithFilters(
          @Param("startDate") LocalDate startDate,
          @Param("endDate") LocalDate endDate,
          Pageable pageable);

}
