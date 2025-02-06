package org.example;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.*;

public class CircleAreaSteps {

    private double radius;
    private double area;
    private CircleAreaCalculator calculator;
    private Exception exception;

    @Дано("радиус равен {double}")
    public void радиус_равен(double radius) {
        this.radius = radius;
        this.calculator = new CircleAreaCalculator();
    }

    @Когда("я вычисляю площадь")
    public void я_вычисляю_площадь() {
        try {
            this.area = calculator.calculateArea(radius);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Тогда("площадь должна быть приблизительно {double}")
    public void площадь_должна_быть_приблизительно(double expectedArea) {
        assertNull(exception);
        assertEquals(expectedArea, this.area, 0.001);
    }
}

// УДАЛИТЬ ЭТОТ МЕТОД, ЕСЛИ НЕ ТРЕБУЕТСЯ ТЕСТИРОВАТЬ ОТРИЦАТЕЛЬНЫЙ РАДИУС
/*@Тогда("должно быть выброшено исключение")
public void должно_быть_выброшено_исключение() {
    assertNotNull(exception);
    assertTrue(exception instanceof IllegalArgumentException);
}*/