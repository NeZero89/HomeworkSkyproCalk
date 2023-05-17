package Skypro.HomeworkSkyproCalk.service;

import org.springframework.stereotype.Service;


@Service
class CalculatorServiceInk implements CalculatorServce {
    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if (num2 != 0) {
            return num1 / num2;
        }
        throw new IllegalArgumentException("На ноль делить нельзя");
    }

}

