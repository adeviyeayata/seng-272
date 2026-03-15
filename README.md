# Software System Quality Evaluation (ISO/IEC 25010 & 25023)

This project is a Java-based measurement tool designed to evaluate software quality using international standards. It was developed as part of the SENG 272 Lab Assignment.

## Features
- **ISO/IEC 25010 Compliance**: Evaluates characteristics like Functional Suitability, Reliability, Performance Efficiency, and Maintainability.
- **ISO/IEC 25023 Metrics**: Uses specific formulas to calculate scores from raw measurement data.
- **Automated Scoring**: Normalizes values to a 1-5 scale and rounds them to the nearest 0.5.
- **Gap Analysis**: Identifies the weakest quality dimension and calculates the distance to perfection (5.0).

## Project Structure
- `Criterion.java`: Handles individual metric calculations and evaluation directions.
- `QualityDimension.java`: Manages groups of metrics and calculates weighted averages.
- `SWSystem.java`: Represents the software product and generates the final report.
- `SWSystemData.java`: Data factory that stores system categories using HashMaps.

## Quality Labels
- **4.5 - 5.0**: Excellent Quality
- **3.5 - 4.4**: Good Quality
- **2.5 - 3.4**: Needs Improvement
- **1.0 - 2.4**: Poor Quality