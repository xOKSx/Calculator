package ru.tunkoff.fintech.qa;

public class Division extends Operation {

    @Override
    double execute(double fistValue, double secondValue) {
        return fistValue / secondValue;
    }
}
