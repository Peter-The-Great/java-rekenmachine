package com.pjotr.calculator;

import java.util.ArrayList;

public class MathUtils {
    /**
     * @multiplication
     * Deze methode berekent het vermenigvuldigde getal.
     * @return het vermenigvuldigde nummer.
     */
    public void multiplication(ArrayList<Integer> multiplicationOperator, ArrayList<Double> Memory) {
        for (int j = 0; j < multiplicationOperator.size(); j++) {
            Memory.set(multiplicationOperator.get(j), Memory.get(multiplicationOperator.get(j)) * Memory.get(multiplicationOperator.get(j) + 1));
            Memory.remove(multiplicationOperator.get(j) + 1);
            multiplicationOperator = sizeReducer(multiplicationOperator, multiplicationOperator, j);
        }
    }
    /**
     * @division
     * Deze methode berekent het gedeelde getal.
     * @return het gedeelde nummer.
     */
    public void division(ArrayList<Integer> divisionOperator, ArrayList<Integer> multiplicationOperator, ArrayList<Double> Memory) {
        for (int i = 0; i < divisionOperator.size(); i++) {
            Memory.set(divisionOperator.get(i), Memory.get(divisionOperator.get(i)) / Memory.get(divisionOperator.get(i) + 1));
            Memory.remove(divisionOperator.get(i) + 1);
            divisionOperator = sizeReducer(divisionOperator, divisionOperator, i);
            multiplicationOperator = sizeReducer(multiplicationOperator, divisionOperator, i);
        }
    }
    /**
     * @power
     * Deze methode zorgt ervoor dat de ^ operator wordt uitgevoerd.
     * Dan krijg je het getal dat je hebt ingevoerd tot de macht van het getal dat je hebt ingevoerd.
     * @return the factorial of the number.
     */
    public void power(ArrayList<Integer> powerOperator, ArrayList<Integer> divisionOperator, ArrayList<Integer> multiplicationOperator, ArrayList<Double> Memory) {
        for (int j = 0; j < powerOperator.size(); j++) {
            Memory.set(powerOperator.get(j), Math.pow(Memory.get(powerOperator.get(j)), (Memory.get(powerOperator.get(j) + 1))));
            Memory.remove(powerOperator.get(j) + 1);
            powerOperator = sizeReducer(powerOperator, powerOperator, j);
            divisionOperator = sizeReducer(divisionOperator, powerOperator, j);
            multiplicationOperator = sizeReducer(multiplicationOperator, powerOperator, j);
        }
    }

    /**
     * @addition
     * Deze methode berekent het opgetelde getal of afgetrokken getal.
     * @return het opgetelde nummer.
     */
    public void AdditionAndSubtraction(ArrayList<Double> Memory, Double FinalValue) {
        for (Double aDouble : Memory) FinalValue = FinalValue + aDouble;
    }

    /**
     * @factorial
     * Deze methode berekent het faculteit van een getal.
     * @return het faculteit van een getal.
     */
    public double factorial(double n) {
        double f = 1;
        for (int i = 1; i <= n; i++) f = f * i;
        return f;
    }
    /**
     * @sizeReducer Deze methode zorgt ervoor dat de arraylist wordt aangepast als er een operator wordt uitgevoerd.
     * @param memoryList1 de arraylist die wordt aangepast, memoryList2 de arraylist die wordt gebruikt om de memoryList1 aan te passen,
     * int a de index van de arraylist die wordt gebruikt om de memoryList1 aan te passen.
     */
    public ArrayList<Integer> sizeReducer(ArrayList<Integer> memoryList1, ArrayList<Integer> memoryList2, int a) {
        for (int b = 0; b < memoryList1.size(); b++) {
            if ((memoryList2.get(a)) < memoryList1.get(b)) memoryList1.set(b, (memoryList1.get(b) - 1));
        }
        return memoryList1;
    }
}
