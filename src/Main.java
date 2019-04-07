import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculate("122+123-8"));
        }

    public static double calculate(String str) {
        StringBuilder sB = new StringBuilder();
        StringBuilder sBchar = new StringBuilder();
        List<String> list = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        int strlength = str.length();
        for (int i = 0; i < strlength; i++){ //цикл перебора символов
            char c = str.charAt(i);
            if(47 < c  && c < 58){// добавляет символ в СБ
                sB.append(c);
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == strlength-1){ //Если знак операции, цифру в лист и обнулить StringBuilder
                if(!(i==strlength-1)){ characters.add(c); }
                list.add(sB.toString());
                sB.setLength(0);
            }
        }
        List<Double> list2 = new ArrayList<>();
        for(int i =0; i < list.size(); i++){ //convert to Double
            String s1 = list.get(i);
            list2.add(Double.parseDouble(s1));
        }
        System.out.println(characters.toString());
        System.out.println(list2.toString());
        int listsize = list2.size();
        double result = 0;
        for(int i = 1; i < listsize; i++ ){
            result = result + determiner(list2.get(i), characters.get(i-1));

        }
        return result+list2.get(0);

    }

    public static double determiner(double d1, char str){

            double res =0;
            switch (str){
                case ('+'):
                    res =+ d1;
                    break;
                case ('-'):
                    res =res - d1;
                    break;
                case ('*'):
                    res =1 * d1;
                    break;
                case ('/'):
                    res =res/ d1;
                    break;
            }

        return res;
    }
}
