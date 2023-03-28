package com.pjotr.calculator;
public class Calculator extends Formating {

    /** @mem Een variabele dat de memory van de rekenmachine behoudt. */
    String mem;
    /**
     * @Calculator Deze class is de hoofd class van de calculator
     * @param ConsoleValue
     * @param measureSystem
     */
    public Calculator(String ConsoleValue, char measureSystem)
    {
        system=measureSystem;
        int start = 0, end = 0;
        ConsoleValue=Reformat(ConsoleValue);
        mem=ConsoleValue;
        ConsoleValue=ConsoleValue.replace("√","r");
        ConsoleValue=ConsoleValue.replace("asin","s");
        ConsoleValue=ConsoleValue.replace("acos","c");
        ConsoleValue=ConsoleValue.replace("atan","t");
        ConsoleValue=ConsoleValue.replace("sin","S");
        ConsoleValue=ConsoleValue.replace("cos","C");
        ConsoleValue=ConsoleValue.replace("tan","T");
        ConsoleValue=ConsoleValue.replace("log","L");
        ConsoleValue=ConsoleValue.replace("ln","l");
        ConsoleValue=Reorganized(ConsoleValue);
        System.out.println(ConsoleValue);

        //Terwijl de consolevalue een haakje bevat, wordt de code uitgevoerd.
        while (ConsoleValue.contains("(") || ConsoleValue.contains(")"))
        {
            for (int i = 0; i < ConsoleValue.length(); i++)
            {
                if (ConsoleValue.charAt(i) == '(')
                    start = i;
                if (ConsoleValue.charAt(i) == ')') {
                    end = i;
                    break;
                }
            }
            String x = ConsoleValue.substring(start, end + 1);
            Operation(ConsoleValue.substring(start + 1, end));
            //als de start niet gelijk is aan 0 en de character op de positie start-1 een cijfer is, dan wordt er een * toegevoegd.
            if (start != 0 && Character.isDigit(ConsoleValue.charAt(start - 1))) ConsoleValue = ConsoleValue.replace(x, "*" + findAnswers());
            //anders als de start niet gelijk is aan 0 en de character op de positie start-1 een - is, dan wordt er een * toegevoegd.
            else if (start != 0 && ConsoleValue.charAt(start - 1) == '-') {
                String y = ConsoleValue.substring(start - 1, end + 1);
                ConsoleValue = ConsoleValue.replace(y, -1 + "*" + findAnswers());
            }
            //anders als de start niet gelijk is aan 0 en de character op de positie start-1 een * is, dan wordt er een * toegevoegd.
            else if (start != 0 && ConsoleValue.charAt(start - 1) == '*') ConsoleValue = ConsoleValue.replace(x, String.valueOf(findAnswers()));

            //anders als de start niet gelijk is aan 0 en de character op de positie start-1 een / is, dan wordt er een * toegevoegd.
            else ConsoleValue = ConsoleValue.replace(x, String.valueOf(findAnswers())); System.out.println(ConsoleValue);
        }
        Operation(ConsoleValue);
    }

    /**
     * @findAnswers Deze methode berekent de uitkomst van de berekening. Het vindt de uitkomst van de berekening door de volgorde van de berekeningen te volgen.
     */
    public Double findAnswers() {
        power(powerOperator, divisionOperator, multiplicationOperator, Memory );
        division(divisionOperator, multiplicationOperator, Memory);
        multiplication(multiplicationOperator, Memory);
        AdditionAndSubtraction(Memory, FinalValue);
        return FinalValue;
    }

}
