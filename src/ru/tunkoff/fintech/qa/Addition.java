package ru.tunkoff.fintech.qa;

public class Addition extends Operation {

    @Override
    double execute(double fistValue, double secondValue) {
        return fistValue + secondValue;
    }
}
