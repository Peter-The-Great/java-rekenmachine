package com.pjotr.calculator;

/**
 * @Formating Deze class zorgt ervoor dat de consolevalue juist wordt geformatteerd naar de reversed polish notation.
 * Daarnaast reorganiseert deze class de consolevalue om ze verder te verwerken in de stringbuilder.
 */
public class Formating extends CalculatorOperation{
    /**
     * @Reformat Deze methode zorgt ervoor dat de consolevalue goed staat.
     * @param co De consolevalue
     * @return De consolevalue met de juiste tekens.
     */
    String Reformat(String co)
    {
        int c1=0,c2=0;
        for (int i=0;i<co.length();i++){
            if (co.charAt(i)=='(') c1++;
            if (co.charAt(i)==')') c2++;
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
            else if ((i!=0&&str.charAt(i)=='e'&&str.charAt(i-1)=='π')||((i!=0&&str.charAt(i)=='π'&&str.charAt(i-1)=='e'))) tem.append("*").append(str.charAt(i));
            else if ((i!=0&&str.charAt(i)=='π'&&str.charAt(i-1)=='π')||((i!=0&&str.charAt(i)=='e'&&str.charAt(i-1)=='e'))) tem.append("*").append(str.charAt(i));
            else tem.append(str.charAt(i));
        }
        return tem.toString();
    }
}
