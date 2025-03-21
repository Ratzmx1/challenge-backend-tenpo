package cl.ratzmx.percentage.repository;

import cl.ratzmx.percentage.domain.entities.CallHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallHistoryRepository extends JpaRepository<CallHistory, Long> {
}
