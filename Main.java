import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operator;
        int newNum;
        int[] selectedNums = new int[2];
        int[] oneDigitNum = new int[5];
        int[] availibleNums = new int[6];
        int twoDigitNum = randomTwoDigit();
        int threeDigitNum = randomThreeDigit();


        availibleNums[0] = twoDigitNum;

        for (int i=0; i<5; i++){
           oneDigitNum[i] = randomOneDigit();
           availibleNums[i+1] = oneDigitNum[i];
           System.out.print(oneDigitNum[i] + " ");
        }

        boolean areAvailibleNumbersExist = true, userDidSelectRight = true;

        System.out.println(twoDigitNum);
        System.out.println("with these numbers, try to get close the number " + threeDigitNum + " using the operators of (+, - , *, /). ");












    }
    static int randomOneDigit(){
        return (int)(math.random * 10);
    }

    static int randomTwoDigit(){
        return (int) (math.random() * 9 + 1) * 10;
    }

    static int randomThreeDigit(){
        return (int) (math.random() * 899 + 100);
    }

    static int calculator(int n1, int n2, String operator){

        int sonuc;

        switch (operator) {
            case "+" -> sonuc = n1 + n2;
            case "-" -> {
                if (n1 >= n2) {
                    sonuc = n1 - n2;
                } else sonuc = n2 - n1;
            }
            case "*" -> sonuc = n1 * n2;
            case "/" -> {
                if (n1 >= n2) {
                    sonuc = (int) (n1 / n2);
                } else sonuc = (int) (n2 / n1);
            }
            default -> {
                System.out.println("Unvalid choice");
                sonuc = -1;
            }
        }

        return sonuc;
    }


}
