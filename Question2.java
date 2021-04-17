import java.util.Scanner;
public class Question2 {
    //MAIN
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in); //scanner object
        System.out.println("Enter a sentence in English: ");
       String string1 = input1.nextLine();
        System.out.println(englishToMorse(string1));


        Scanner input2 = new Scanner(System.in); //scanner object
        System.out.println("\nEnter a sentence in Morse: ");
        String string2= input2.nextLine();
        System.out.println(morseToEnglish(string2));

    }

    //conversion table
    static String[][] englishAndMorseTable = {
            //english alphabet
            {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                    "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                    "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"},
            //morse alphabet
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---"
                    , "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "..."
                    , "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                    ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"}
    };

    //converts english to morse
    public static String englishToMorse(String s) {
        String translation = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));

            //conversion
            for (int j = 0; j < englishAndMorseTable[0].length; j++) {
                if (temp.equals(englishAndMorseTable[0][j])) {
                    translation += (englishAndMorseTable[1][j]+ " ");
                }
            }
            if (temp.equals(" ")){
                translation += "  "; //2 spaces + 1 after the last letter = 3
            }
        }
        return translation;
        }


        //converts morse to English
    public static String morseToEnglish(String s){
       String translation = "";
       String temp = "";
       boolean spaceExists = true;

       while (spaceExists){
           int substringStart = 1;
           int indexOfSpace = s.indexOf(" ");
           if(indexOfSpace < 0) {
               temp = s;
               spaceExists = false;
           }
           else if (indexOfSpace == 0){ //to record spaces
               temp = s.substring(0,1);
               substringStart = 2;
           }
           else{
               temp = s.substring(0, indexOfSpace);
           }
           //conversion
           for (int i =0; i< englishAndMorseTable[0].length; i++){
               if (temp.equals((englishAndMorseTable[1][i]))){
                   translation += englishAndMorseTable[0][i];
               }
           }
           if(temp.equals(" ")){
               translation += " ";
           }
           s = s.substring(indexOfSpace+substringStart);
       }
return translation;
    }
}






























