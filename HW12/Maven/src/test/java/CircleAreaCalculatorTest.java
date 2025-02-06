package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;


import static org.junit.jupiter.api.Assertions.*;

class CircleAreaCalculatorTest {

    private CircleAreaCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new CircleAreaCalculator();
    }

    @Test
    @DisplayName("Тест вычисления площади круга с положительным радиусом")
    void testCalculateAreaWithPositiveRadius() {
        double radius = 5.0;
        double expectedArea = Math.PI * 5.0 * 5.0;
        double actualArea = calculator.calculateArea(radius);
        assertEquals(expectedArea, actualArea, 0.001); // Точность до 0.001
    }

    @Test
    @DisplayName("Тест вычисления площади круга с радиусом 0")
    void testCalculateAreaWithZeroRadius() {
        double radius = 0.0;
        double expectedArea = 0.0;
        double actualArea = calculator.calculateArea(radius);
        assertEquals(expectedArea, actualArea, 0.001);
    }

    @Test
    @DisplayName("Тест вычисления площади круга с отрицательным радиусом")
    void testCalculateAreaWithNegativeRadius() {
        double radius = -5.0;
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateArea(radius));
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, 3.141592653589793",
            "2.5, 19.634954084936208",
            "7.3, 167.41547737044233"
    })
    @DisplayName("Параметризованный тест вычисления площади круга")
    void testCalculateAreaParameterized(double radius, double expectedArea) {
        double actualArea = calculator.calculateArea(radius);
        assertEquals(expectedArea, actualArea, 0.001);
    }
}