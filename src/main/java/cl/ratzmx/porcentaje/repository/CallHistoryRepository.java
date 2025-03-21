package cl.ratzmx.porcentaje.repository;

import cl.ratzmx.porcentaje.domain.entities.CallHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallHistoryRepository extends JpaRepository<CallHistory, Long> {
}
