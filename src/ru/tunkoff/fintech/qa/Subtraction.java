package ru.tunkoff.fintech.qa;

public class Subtraction extends Operation {

    @Override
    double execute(double fistValue, double secondValue) {
        return fistValue - secondValue;
    }
}
