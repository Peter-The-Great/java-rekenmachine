package com.pjotr.calculator;

import java.util.ArrayList;

public class MathUtils {

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
