package quantitymeasurement.repository;

import quantitymeasurement.entity.QuantityMeasurementEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents QuantityMeasurementCacheRepository.
 */
public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {
    /**
     * Property cache.
     */
    private final List<QuantityMeasurementEntity> cache = new ArrayList<>();

    /**
     * Execution logic for save.
     */
    @Override
    public void save(QuantityMeasurementEntity entity) {
        cache.add(entity);
    }

    /**
     * Execution logic for findAll.
     */
    @Override
    public List<QuantityMeasurementEntity> findAll() {
        return new ArrayList<>(cache);
    }
}
