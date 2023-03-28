package com.pjotr.calculator;
import java.util.ArrayList;

public class CalculatorOperation extends MathUtils {
    /** @sign is een variabele die gebruikt wordt om te kijken of het getal positief of negatief is. */
    /** @finalSign is een variabele die gebruikt wordt om te kijken of het getal positief of negatief is. */
    int sign, finalSign;
    public Double FinalValue = 0.0;
    ArrayList<Double> Memory = new ArrayList<>();
    ArrayList<Integer> divisionOperator = new ArrayList<>();
    ArrayList<Integer> multiplicationOperator = new ArrayList<>();
    ArrayList<Integer> powerOperator = new ArrayList<>();
    /** @tem tem is een string variable die temporary getalen opslaat. */
    String tem = "";

    /** @testvalue is een variabele die gebruikt wordt om tests uit te voeren. */
    Double testvalue = 0.0;

    /** @system system is een is een variabele die gebruikt wordt voor trigonometry */
    char system;

    /**
     * @param ConsoleValue is de string die de console inleest.
     * @return void
     * @Operation is een methode die de string van de console in een arraylist zet.
     * Deze functie maakt gebruik van reverse polish notation. Om zo makkelijk de berekening te kunnen uitvoeren via een for loop.
     */
    public Double Operation(String ConsoleValue) {
        Memory.clear();
        divisionOperator.clear();
        multiplicationOperator.clear();
        powerOperator.clear();
        tem = "";
        sign = 1;
        finalSign = 1;
        FinalValue = 0.0;
        ConsoleValue = ConsoleValue + "+";
        //for loop die de string in een arraylist zet
        for (int i = 0; i < ConsoleValue.length(); i++) {
            //als het getal een cijfer is of een punt of een E dan wordt het getal in de tem variable gezet.
            if ((Character.isDigit(ConsoleValue.charAt(i)) || ConsoleValue.charAt(i) == '.') || ConsoleValue.charAt(i) == 'E') {
                tem = String.format("%s%s", tem, ConsoleValue.charAt(i));
                //als het getal een E is dan wordt er gekeken of het een positief of negatief getal is.
                if (ConsoleValue.charAt(i) == 'E' && ConsoleValue.charAt(i + 1) == '-') {
                    tem = String.format("%s%s", tem, '-');
                    tem = String.format("%s%s", tem, ConsoleValue.charAt(i + 2));
                    i = i + 2;
                }
                //als tem.length() 1 is dan wordt de finalSign variable gezet.
                if (tem.length() == 1)
                    finalSign = sign;
            }
            //als het getal een ! is dan wordt de factorial methode aangeroepen.
            if (ConsoleValue.charAt(i) == '!') {
                tem = String.valueOf(factorial(Long.parseLong(tem)));
            }
            //als het getal een e is dan wordt het getal vervangen door de waarde van het euler getal.
            if (ConsoleValue.charAt(i) == 'e')
                tem = String.valueOf(Math.E);
            //als het getal een π is dan wordt het getal vervangen door de waarde van het pi getal.
            if (ConsoleValue.charAt(i) == 'π')
                tem = String.valueOf(Math.PI);
            //als het getal een S is dan wordt de sinus methode aangeroepen.
            if (ConsoleValue.charAt(i) == 'S') {
                i = function(i, 'S', ConsoleValue);
            }
            //als het getal een C is dan wordt de cosinus methode aangeroepen.
            if (ConsoleValue.charAt(i) == 'C') {
                i = function(i, 'C', ConsoleValue);
            }
            //als het getal een T is dan wordt de tangens methode aangeroepen.
            if (ConsoleValue.charAt(i) == 'T') {
                i = function(i, 'T', ConsoleValue);
            }
            //als het getal een l is dan wordt de log methode aangeroepen.
            if (ConsoleValue.charAt(i) == 'l') {
                i = function(i, 'l', ConsoleValue);
            }
            //als het getal een L is dan wordt de log inverse methode aangeroepen.
            if (ConsoleValue.charAt(i) == 'L') {
                i = function(i, 'L', ConsoleValue);
            }
            //als het getal een s is dan wordt de arctangens methode aangeroepen.
            if (ConsoleValue.charAt(i) == 's') {
                i = function(i, 's', ConsoleValue);
            }
            //als het getal een c is dan wordt de arccosinus methode aangeroepen.
            if (ConsoleValue.charAt(i) == 'c') {
                i = function(i, 'c', ConsoleValue);
            }
            //als het getal een t is dan wordt de arcsinus methode aangeroepen.
            if (ConsoleValue.charAt(i) == 't') {
                i = function(i, 't', ConsoleValue);
            }
            //als het getal een r is dan wordt de wortel methode aangeroepen.
            if (ConsoleValue.charAt(i) == 'r') {
                i = function(i, 'r', ConsoleValue);
            }
            //als het getal een - is dan wordt de sign variable gezet. Dan is het een negatief getal.
            if (ConsoleValue.charAt(i) == '-') {
                sign = (-1);
            }
            //als het getal een + is dan wordt de sign variable gezet. Dan is het een positief getal.
            if (ConsoleValue.charAt(i) == '+')
                sign = 1;
            //als het getal een - of een + is dan wordt de tem variable in de arraylist gezet.
            if (ConsoleValue.charAt(i) == '-' || ConsoleValue.charAt(i) == '+') {
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem) * finalSign);
                    tem = "";
                }
            }
            //als het getal een / is dan wordt de tem variable in de arraylist gezet en wordt de divisionOperator arraylist aangevuld.
            if (ConsoleValue.charAt(i) == '/') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem) * finalSign);
                    tem = "";
                }
                divisionOperator.add(Memory.size() - 1);
            }
            //als het getal een * is dan wordt de tem variable in de arraylist gezet en wordt de multiplicationOperator arraylist aangevuld.
            if (ConsoleValue.charAt(i) == '*') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem) * finalSign);
                    tem = "";
                }
                multiplicationOperator.add(Memory.size() - 1);
            }
            //als het getal een ^ is dan wordt de tem variable in de arraylist gezet en wordt de powerOperator arraylist aangevuld.
            if (ConsoleValue.charAt(i) == '^') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem) * finalSign);
                    tem = "";
                }
                powerOperator.add(Memory.size() - 1);
                testvalue = Memory.get(0);
            }
        }
        return testvalue;
    }
    /**
     * @power
     * Deze methode zorgt ervoor dat de ^ operator wordt uitgevoerd.
     * Dan krijg je het getal dat je hebt ingevoerd tot de macht van het getal dat je hebt ingevoerd.
     * @return the factorial of the number.
     */
    public Double power() {
        for (int j = 0; j < powerOperator.size(); j++) {
            Memory.set(powerOperator.get(j), Math.pow(Memory.get(powerOperator.get(j)), (Memory.get(powerOperator.get(j) + 1))));
            Memory.remove(powerOperator.get(j) + 1);
            powerOperator = sizeReducer(powerOperator, powerOperator, j);
            divisionOperator = sizeReducer(divisionOperator, powerOperator, j);
            multiplicationOperator = sizeReducer(multiplicationOperator, powerOperator, j);
        }
        testvalue = Memory.get(0);
        return testvalue;
    }

    /**
     * @division
     * Deze methode berekent het gedeelde getal.
     * @return het gedeelde nummer.
     */
    public Double division() {
        for (int i = 0; i < divisionOperator.size(); i++) {
            Memory.set(divisionOperator.get(i), Memory.get(divisionOperator.get(i)) / Memory.get(divisionOperator.get(i) + 1));
            Memory.remove(divisionOperator.get(i) + 1);
            divisionOperator = sizeReducer(divisionOperator, divisionOperator, i);
            multiplicationOperator = sizeReducer(multiplicationOperator, divisionOperator, i);
        }
        testvalue = Memory.get(0);
        return testvalue;
    }

    /**
     * @multiplication
     * Deze methode berekent het vermenigvuldigde getal.
     * @return het vermenigvuldigde nummer.
     */
    public Double multiplication() {
        for (int j = 0; j < multiplicationOperator.size(); j++) {
            Memory.set(multiplicationOperator.get(j), Memory.get(multiplicationOperator.get(j)) * Memory.get(multiplicationOperator.get(j) + 1));
            Memory.remove(multiplicationOperator.get(j) + 1);
            multiplicationOperator = sizeReducer(multiplicationOperator, multiplicationOperator, j);
        }
        testvalue = Memory.get(0);
        return testvalue;
    }

    /**
     * @addition
     * Deze methode berekent het opgetelde getal of afgetrokken getal.
     * @return het opgetelde nummer.
     */
    public Double AdditionAndSubtraction() {
        for (Double aDouble : Memory) FinalValue = FinalValue + aDouble;
        testvalue = FinalValue;
        return testvalue;
    }

    /**
     * @function Dit is de functie die de functies aanroept
     * @param i     de index van de character in de string
     * @param type  het type functie
     * @param Data  de string
     * @return      de index van de character in de string
     */
    public int function(int i, char type, String Data) {
        i = i + 1;
        tem = "";
        finalSign = sign;
        //terwijl de applicatie draait wordt de tem variable gevuld met de getallen die er achter de functie staan.
        while (true) {
            //als de character een getal is dan wordt de tem variable gevuld met de getallen die er achter de functie staan.
            if (Character.isDigit(Data.charAt(i)) || Data.charAt(i) == '.' || Data.charAt(i) == 'E' || tem.equals("")) {
                if (Data.charAt(i) == 'E' && Data.charAt(i + 1) == '-') {
                    tem = tem + "E" + "-";
                    i = i + 2;
                } else {
                    tem = tem + Data.charAt(i);
                    i = i + 1;
                }
            } else {
                if (system == 'R') { //Trigonometrie in radialen functies
                    if (type == 'S') tem = String.valueOf(Math.sin(Double.parseDouble(tem)));
                    if (type == 'C') tem = String.valueOf(Math.cos(Double.parseDouble(tem)));
                    if (type == 'T') tem = String.valueOf(Math.tan(Double.parseDouble(tem)));
                    if (type == 's') tem = String.valueOf(Math.asin(Double.parseDouble(tem)));
                    if (type == 'c') tem = String.valueOf(Math.acos(Double.parseDouble(tem)));
                    if (type == 't') tem = String.valueOf(Math.atan(Double.parseDouble(tem)));
                }
                if (system == 'D') {// Trigonometrie in graden functies
                    if (type == 'S') tem = String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(tem))));
                    if (type == 'C') tem = String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(tem))));
                    if (type == 'T') {
                        if (!tem.equals("90.0")) tem = String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(tem))));
                        else tem = "Infinity";
                    }
                    if (type == 's') tem = String.valueOf(Math.toDegrees(Math.asin(Double.parseDouble(tem))));
                    if (type == 'c') tem = String.valueOf(Math.toDegrees(Math.acos(Double.parseDouble(tem))));
                    if (type == 't') {
                        if (!tem.equals("90.0")) tem = String.valueOf(Math.toDegrees(Math.atan(Double.parseDouble(tem))));
                        else tem = "Infinity";
                    }
                }
                //log and inverse log
                if (type == 'l') tem = String.valueOf(Math.log(Double.parseDouble(tem)));
                if (type == 'L') tem = String.valueOf(Math.log10(Double.parseDouble(tem)));
                //for root function
                if (type == 'r') tem = String.valueOf(Math.sqrt(Double.parseDouble(tem)));
                break;
            }
        }
        return i;
    }
}
