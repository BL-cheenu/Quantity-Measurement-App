package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.entity.QuantityDTO;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Represents QuantityMeasurementController.
 */
@RestController
@RequestMapping("/api/measurement")
public class QuantityMeasurementController {
    /**
     * Property logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(QuantityMeasurementController.class);

    /**
     * Property service.
     */
    private final IQuantityMeasurementService service;

    /**
     * Execution logic for QuantityMeasurementController.
     */
    @Autowired
    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    /**
     * Execution logic for compare.
     */
    @PostMapping("/compare")
    public ResponseEntity<QuantityMeasurementEntity> compare(@RequestBody CompareRequest request) {
        QuantityMeasurementEntity result = service.compare(request.getQ1(), request.getQ2());
        logger.info(result.toString());
        return result.hasError() ? ResponseEntity.badRequest().body(result) : ResponseEntity.ok(result);
    }

    /**
     * Execution logic for add.
     */
    @PostMapping("/add")
    public ResponseEntity<QuantityMeasurementEntity> add(@RequestBody ArithmeticRequest request) {
        QuantityMeasurementEntity result = service.add(request.getQ1(), request.getQ2(), request.getTargetUnit());
        logger.info(result.toString());
        return result.hasError() ? ResponseEntity.badRequest().body(result) : ResponseEntity.ok(result);
    }

    /**
     * Execution logic for subtract.
     */
    @PostMapping("/subtract")
    public ResponseEntity<QuantityMeasurementEntity> subtract(@RequestBody ArithmeticRequest request) {
        QuantityMeasurementEntity result = service.subtract(request.getQ1(), request.getQ2(), request.getTargetUnit());
        logger.info(result.toString());
        return result.hasError() ? ResponseEntity.badRequest().body(result) : ResponseEntity.ok(result);
    }

    /**
     * Execution logic for divide.
     */
    @PostMapping("/divide")
    public ResponseEntity<QuantityMeasurementEntity> divide(@RequestBody CompareRequest request) {
        QuantityMeasurementEntity result = service.divide(request.getQ1(), request.getQ2());
        logger.info(result.toString());
        return result.hasError() ? ResponseEntity.badRequest().body(result) : ResponseEntity.ok(result);
    }

    /**
     * Execution logic for convert.
     */
    @PostMapping("/convert")
    public ResponseEntity<QuantityMeasurementEntity> convert(@RequestBody ConvertRequest request) {
        QuantityMeasurementEntity result = service.convert(request.getQ1(), request.getTargetUnit());
        logger.info(result.toString());
        return result.hasError() ? ResponseEntity.badRequest().body(result) : ResponseEntity.ok(result);
    }

    // Inner classes for request payloads
    public static class CompareRequest {
        /**
         * Property q1.
         */
        private QuantityDTO q1;
        /**
         * Property q2.
         */
        private QuantityDTO q2;
        /**
         * Execution logic for getQ1.
         */
        public QuantityDTO getQ1() { return q1; }
        /**
         * Execution logic for setQ1.
         */
        public void setQ1(QuantityDTO q1) { this.q1 = q1; }
        /**
         * Execution logic for getQ2.
         */
        public QuantityDTO getQ2() { return q2; }
        /**
         * Execution logic for setQ2.
         */
        public void setQ2(QuantityDTO q2) { this.q2 = q2; }
    }

    /**
     * Represents ArithmeticRequest.
     */
    public static class ArithmeticRequest {
        /**
         * Property q1.
         */
        private QuantityDTO q1;
        /**
         * Property q2.
         */
        private QuantityDTO q2;
        private QuantityDTO.IMeasurableUnit targetUnit;
        /**
         * Execution logic for getQ1.
         */
        public QuantityDTO getQ1() { return q1; }
        /**
         * Execution logic for setQ1.
         */
        public void setQ1(QuantityDTO q1) { this.q1 = q1; }
        /**
         * Execution logic for getQ2.
         */
        public QuantityDTO getQ2() { return q2; }
        /**
         * Execution logic for setQ2.
         */
        public void setQ2(QuantityDTO q2) { this.q2 = q2; }
        public QuantityDTO.IMeasurableUnit getTargetUnit() { return targetUnit; }
        /**
         * Execution logic for setTargetUnit.
         */
        public void setTargetUnit(QuantityDTO.IMeasurableUnit targetUnit) { this.targetUnit = targetUnit; }
    }

    /**
     * Represents ConvertRequest.
     */
    public static class ConvertRequest {
        /**
         * Property q1.
         */
        private QuantityDTO q1;
        private QuantityDTO.IMeasurableUnit targetUnit;
        /**
         * Execution logic for getQ1.
         */
        public QuantityDTO getQ1() { return q1; }
        /**
         * Execution logic for setQ1.
         */
        public void setQ1(QuantityDTO q1) { this.q1 = q1; }
        public QuantityDTO.IMeasurableUnit getTargetUnit() { return targetUnit; }
        /**
         * Execution logic for setTargetUnit.
         */
        public void setTargetUnit(QuantityDTO.IMeasurableUnit targetUnit) { this.targetUnit = targetUnit; }
    }

    // Retaining legacy method for test compatibility
    public void compare(QuantityDTO q1, QuantityDTO q2) {
        QuantityMeasurementEntity result = service.compare(q1, q2);
        logger.info(result.toString());
    }

    /**
     * Execution logic for demonstrateAddition.
     */
    public void demonstrateAddition(QuantityDTO q1, QuantityDTO q2, QuantityDTO.IMeasurableUnit targetUnit) {
        QuantityMeasurementEntity result = service.add(q1, q2, targetUnit);
        logger.info(result.toString());
    }
}
