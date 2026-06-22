  - `VolumeUnit` implements `IMeasurable` and supports `LITRE`, `MILLILITRE`, and `GALLON`.
  - `TemperatureUnit` implements `IMeasurable` and supports `CELSIUS` and `FAHRENHEIT`.
- **Compile-Time Category Safety**: The `Quantity<U>` class is strictly parameterized. Attempts to mix categories (e.g. `LengthUnit` + `VolumeUnit`) will fail to compile. This replaces error-prone runtime checks.
- **Centralized & Validated Arithmetic Operations (DRY)**: 
  - `add(...)`, `subtract(...)`, `divide(...)`: Generic arithmetic methods wrapping `performOperation`.
  - Under the hood, these methods delegate to a private helper `performOperation`, which validates whether the `IMeasurable` category supports arithmetic (via `validateOperationSupport`).
  - Attempts to perform arithmetic on Temperature objects safely fail with an `UnsupportedOperationException`.
- **Robust Validation**: Rejects invalid states like `null` units, `NaN` values, and `Infinite` values via `IllegalArgumentException`. Division by zero explicitly throws an exception.
- **Comprehensive Testing**: JUnit 5 tests utilizing generic parameters to verify equality, conversions, arithmetic, unsupported constraints, and isolated category tests for Length, Weight, Volume, and Temperature.

1. **Controller Layer (`QuantityMeasurementController.java`)**: 
   - Acts as the presentation entry-point.
   - Delegates all business requests to the underlying Service layer and prints out the results cleanly.

2. **Service Layer (`IQuantityMeasurementService` & `QuantityMeasurementServiceImpl`)**:
   - Encapsulates core business logic and logic-flow operations.
   - Explicitly ensures that arithmetic or comparisons are only executed after validating that the two distinct units belong to compatible measurement domains (e.g., Length and Length).

3. **Repository Layer (`IQuantityMeasurementRepository` & `QuantityMeasurementCacheRepository`)**:
   - Completely decouples the data access layer.
   - Currently implemented as an in-memory cache repository (`List<QuantityMeasurementEntity> cache`) allowing for seamless replacement with a persistent DB in the future.

4. **Entity/Model Layer**:
   - **`QuantityDTO`**: A robust Data Transfer Object representing the value and unit of a measurement being passed from the frontend/Controller.
   - **`QuantityModel`**: The core logic model containing the generic type validation rules, conversions, and math logic.
   - **`QuantityMeasurementEntity`**: A specialized POJO designed to store the operation history and result states of every calculation securely.

5. **Testing & Verification**:
   - Re-aligned the existing JUnit 5 test suite to run against the new architecture cleanly. 
   - The refactored N-Tier architecture continues to securely pass all 67 Unit Tests without breaking previously established constraints.

## Running the Code

**Build and Run Tests:**
```bash
mvn clean test
```

**Run the Application:**
```bash
mvn exec:java -Dexec.mainClass="quantitymeasurement.QuantityMeasurementApp"
```
