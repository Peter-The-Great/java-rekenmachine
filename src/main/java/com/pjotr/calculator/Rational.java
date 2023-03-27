package com.pjotr.calculator;

public class Rational
{
    private long a, b,pos=0,l=0;
    /**
     * @Rational
     * Deze functie zet een String om naar een breuk. Deze functie wordt gebruikt in de {@link com.pjotr.calculator.Calculator #Calculator() Calculator} class.
     * De functie is nodig om de String om te zetten naar een breuk, zodat deze kan worden vergeleken met andere breuken.
     * @param String input
     */
    Rational(String input){
        StringBuilder num=new StringBuilder();
        if (!input.contains("."))
            input = input + ".0";
        boolean condition = true;
        l = input.length();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.' && condition) {
                pos = input.indexOf(".") + 1;
                condition = false;
            } else {
                num.append(input.charAt(i));
            }
        }
        a = Long.parseLong(num.toString());
        b = (long) Math.pow(10, l - pos);
    }
    /**
     * @P_by_QForm
     * Deze functie voegt 2 breuken bij elkaar en geeft het resultaat terug.
     * Met behulp van de {@link #GCD(long a, long b) GCD} wordt de breuk vereenvoudigd naar een eenvoudige breuk.
     * @param Rational r
     * @return The sum of the 2 fractions
     */
    public String P_by_QForm() {
        return a / GCD(a, b) + "/" + b / GCD(a, b);
    }
    /**
     * @GCD
     * Deze functie berekent de grootste gemene deler van 2 getallen a en b,
     * hiermee wordt een breuk vereenvoudigd naar een eenvoudige breuk.
     * Dit is handig voor het vergelijken van breuken.
     * @param a
     * @param b
     * @return The Greatest common divisor
     */
    private long GCD(long a, long b) {
        long gdc = 0, count = 0;
        for (long i = 1; i <= Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gdc = Math.max(i, gdc);
            } else {
                count++;
                if (count == 500)
                    break;
            }
        }
        return gdc;
    }
}
