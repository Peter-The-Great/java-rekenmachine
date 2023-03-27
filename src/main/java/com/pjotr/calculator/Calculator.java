package com.pjotr.calculator;

public class Calculator extends CalculatorOperation {

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
            if (start != 0 && Character.isDigit(ConsoleValue.charAt(start - 1)))
                ConsoleValue = ConsoleValue.replace(x, "*" + findAnswers());
            //anders als de start niet gelijk is aan 0 en de character op de positie start-1 een - is, dan wordt er een * toegevoegd.
            else if (start != 0 && ConsoleValue.charAt(start - 1) == '-') {
                String y = ConsoleValue.substring(start - 1, end + 1);
                ConsoleValue = ConsoleValue.replace(y, -1 + "*" + findAnswers());
            }
            //anders als de start niet gelijk is aan 0 en de character op de positie start-1 een * is, dan wordt er een * toegevoegd.
            else if (start != 0 && ConsoleValue.charAt(start - 1) == '*')
                ConsoleValue = ConsoleValue.replace(x, String.valueOf(findAnswers()));

            //anders als de start niet gelijk is aan 0 en de character op de positie start-1 een / is, dan wordt er een * toegevoegd.
            else

                ConsoleValue = ConsoleValue.replace(x, String.valueOf(findAnswers()));
            System.out.println(ConsoleValue);
        }
        Operation(ConsoleValue);
    }

    /**
     * @findAnswers Deze methode berekent de uitkomst van de berekening. Het vindt de uitkomst van de berekening door de volgorde van de berekeningen te volgen.
     */
    public Double findAnswers() {
        power();
        division();
        multiplication();
        AdditionAndSubtraction();
        return FinalValue;
    }
    /**
     * @Reformat Deze methode zorgt ervoor dat de haakjes goed staan.
     * @param co De consolevalue
     * @return De consolevalue met de juiste haakjes.
     */
    String Reformat(String co)
    {
        int c1=0,c2=0;
        for (int i=0;i<co.length();i++){
            if (co.charAt(i)=='(')
                c1++;
            if (co.charAt(i)==')')
                c2++;
        }
        if ((c1-c2)>0){
            co = co + ")".repeat(Math.max(0, (c1 - c2)));
        }
        if ((c1-c2)<0){
            co=co.substring(0,(co.length()-(c2-c1)));
        }
        return co;
    }
    /**
     * @Reorganized Deze methode zorgt ervoor dat de consolevalue goed staat.
     * @param str De consolevalue
     * @return De consolevalue met de juiste tekens.
     */
    String Reorganized(String str){
        StringBuilder tem= new StringBuilder();
        //voor elke character in de consolevalue wordt er gekeken of het een getal is.
        for (int i=0;i<str.length();i++)
        {
            //als de character een getal is, dan wordt het toegevoegd aan de stringbuilder.
            if ((i!=0)&&(str.charAt(i)=='S'||str.charAt(i)=='s'||
                    str.charAt(i)=='C'||str.charAt(i)=='c'||
                    str.charAt(i)=='T'||str.charAt(i)=='t'||
                    str.charAt(i)=='L'|| str.charAt(i)=='l'
                    ||str.charAt(i)=='e'||str.charAt(i)=='π'||str.charAt(i)=='r')
                    &&(Character.isDigit(str.charAt(i-1))||str.charAt(i-1)==')'))
            {
                    tem.append("*").append(str.charAt(i));
            }
            //anders als de character een getal is, dan wordt het toegevoegd aan de stringbuilder.
            else if((i!=0&&Character.isDigit(str.charAt(i))&&str.charAt(i-1)==')')||
                    (i!=0&&Character.isDigit(str.charAt(i))&&
                            ((str.charAt(i-1)=='π')||(str.charAt(i-1)=='e')||(str.charAt(i-1)=='!')))){
                tem.append("*").append(str.charAt(i));
            }
            //anders als de character een getal is en heeft een pi input, dan wordt het toegevoegd aan de stringbuilder.
            else if ((i!=0&&str.charAt(i)=='e'&&str.charAt(i-1)=='π')||((i!=0&&str.charAt(i)=='π'&&str.charAt(i-1)=='e')))
                tem.append("*").append(str.charAt(i));
            else if ((i!=0&&str.charAt(i)=='π'&&str.charAt(i-1)=='π')||((i!=0&&str.charAt(i)=='e'&&str.charAt(i-1)=='e')))
                tem.append("*").append(str.charAt(i));
            else tem.append(str.charAt(i));
        }
        return tem.toString();
    }
}
