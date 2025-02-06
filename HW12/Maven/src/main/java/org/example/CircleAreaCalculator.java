package org.example;

public class CircleAreaCalculator {
    public double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус должен быть неотрицательным");
        }
        return Math.PI * radius * radius;
    }
}