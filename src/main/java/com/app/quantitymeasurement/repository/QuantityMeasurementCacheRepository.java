package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents QuantityMeasurementCacheRepository.
 */
public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {
    /**
     * Property logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(QuantityMeasurementCacheRepository.class);
    /**
     * Property cache.
     */
    private final List<QuantityMeasurementEntity> cache = new ArrayList<>();

    /**
     * Execution logic for save.
     */
    @Override
    public QuantityMeasurementEntity save(QuantityMeasurementEntity entity) {
        cache.add(entity);
        logger.info("Saved entity to cache: {}", entity.getOperation());
        return entity;
    }

    /**
     * Execution logic for getAllMeasurements.
     */
    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return new ArrayList<>(cache);
    }

    /**
     * Execution logic for getMeasurementsByOperation.
     */
    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByOperation(String operation) {
        List<QuantityMeasurementEntity> result = new ArrayList<>();
        for (QuantityMeasurementEntity entity : cache) {
            if (operation.equalsIgnoreCase(entity.getOperation())) {
                result.add(entity);
            }
        }
        return result;
    }

    /**
     * Execution logic for getMeasurementsByType.
     */
    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByType(String measurementType) {
        List<QuantityMeasurementEntity> result = new ArrayList<>();
        for (QuantityMeasurementEntity entity : cache) {
            if (measurementType.equalsIgnoreCase(entity.getMeasurementType())) {
                result.add(entity);
            }
        }
        return result;
    }

    /**
     * Execution logic for getTotalCount.
     */
    @Override
    public int getTotalCount() {
        return cache.size();
    }

    /**
     * Execution logic for deleteAll.
     */
    @Override
    public void deleteAll() {
        cache.clear();
        logger.info("Cleared cache repository.");
    }
}
