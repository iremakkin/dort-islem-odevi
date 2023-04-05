public class Main {
    public static void main(String[] args) {



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

        switch (operator){
            case "+":
                sonuc = n1 + n2;
                break;
            case "-":
                if(n1 >= n2){
                    sonuc = n1-n2;}
                else sonuc = n2-n1;
                break;
            case "*":
                sonuc = n1 * n2;
                break;
            case "/":
                if(n1 >= n2){
                    sonuc = (int)(n1/n2);}
                else sonuc = (int)(n2/n1);
                break;
            default:
                System.out.println("Gecersiz secim");
                sonuc = -1;
                break;
        }

        return sonuc;
    }

}
