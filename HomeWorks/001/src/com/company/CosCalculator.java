package com.company;

/*
    cosx = 1 - x^2/2! + x^4/4! - x^6/6! + ...
*/
public class CosCalculator {

    public double calc(int x, int iterationCount) {
        int numerator   = 1;
        int ourCount    = 0; // специальный счетчик, который мы будем каждый раз увеличивать на 2
        int denominator = 1;
        int changeMark  = 1;
        double result   = 1D;

        for(int iterationCountCurrent = 2; iterationCountCurrent <= iterationCount; iterationCountCurrent++) {
            ourCount += 2; // увеличиваем на 2
            numerator = exponent(x, ourCount); // расчет числителя
            denominator *= (ourCount - 1); // расчет знаменателя
            denominator *= ourCount; // расчет знаменателя
            changeMark *= -1; // каждый раз меняем знак при новой итерации
            result += (double) changeMark * ( (double) numerator / (double) denominator );
        }
        return result;
    }

    // возводим в степень
    static int exponent(int a, int b){
        int result = 1;
        for (int i = 1; i <= b; i++){
            result = result * a;
        }
        return result;
    }

}
