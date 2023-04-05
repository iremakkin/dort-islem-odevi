import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operator;
        int finalNum = 0;
        int finalGap;
        int newNum;
        int kalan=0;
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

        while (areAvailibleNumbersExist) {

                System.out.print("select one of the numbers: ");
                selectedNums[0] = input.nextInt();
                System.out.println(" ");
                System.out.print("select another number: ");
                selectedNums[1] = input.nextInt();
                System.out.println(" ");
                System.out.print("select an operator one of +,-,*,/");
                operator = input.nextLine();
                newNum = calculator(selectedNums[0], selectedNums[1], operator);

                for (int i=0; i<6 ; i++){
                    if(selectedNums[0] == availibleNums[i]){
                        availibleNums[i] = 0;
                        break;
                    }
                }
                for (int i=0; i<6 ; i++){
                    if(selectedNums[1] == availibleNums[i]){
                        availibleNums[i] = 0;
                        break;
                    }
                }
                for (int i=0; i<6 ; i++){
                    if(availibleNums[i] == 0){
                        availibleNums[i] = newNum;
                        break;
                    }
                }

                System.out.println(" ");
                System.out.print("numbers that left: ");

                for (int i=0; i<6 ; i++){
                    if(availibleNums[i]!=0){
                        System.out.print(availibleNums[i]+ " ");
                    }
                }



                for (int i=0; i<6 ; i++){
                    if(availibleNums[i]!=0){
                        kalan++;
                    }
                }

                if (kalan == 1){

                    for (int i=0; i<6 ; i++){
                        if(availibleNums[i]!=0){
                            finalNum = availibleNums[i];
                        }
                    }
                    areAvailibleNumbersExist = false;
                }
        }


        System.out.println(" ");
        System.out.println("the final number you found: "+ finalNum);
        System.out.println("the goal number: "+ threeDigitNum);
        finalGap = calculator(finalNum, threeDigitNum, "-");
        System.out.println("the gap between them is " + finalGap );
        if(finalGap < 9){
            System.out.println("YOU WON");
        } else if (finalGap > 9) {
            System.out.println("YOU LOST");
        } else {
            System.out.println("CLOSE ENOUGH");
        }
        System.exit(-1);


    }
    static int randomOneDigit(){
        return (int)(Math.random() * 10);
    }

    static int randomTwoDigit(){
        return (int) (Math.random() * 9 + 1) * 10;
    }

    static int randomThreeDigit(){
        return (int) (Math.random() * 899 + 100);
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
