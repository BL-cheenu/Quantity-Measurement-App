package quantitymeasurement.repository;

import quantitymeasurement.entity.QuantityMeasurementEntity;
import java.util.List;

/**
 * Represents IQuantityMeasurementRepository.
 */
public interface IQuantityMeasurementRepository {
    void save(QuantityMeasurementEntity entity);
    List<QuantityMeasurementEntity> findAll();
}
