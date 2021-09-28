package com.company;


import java.io.EOFException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberToWord {
    int[] number = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,1000,100000,10000000};
    String[] words = {"One","Two","Three","four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen",
            "Fourteen","Fifteen","Sixteen","Seventeen" , "Eighteen","Nineteen","Twenty","thirty","forty","Fifty","Sixty","Seventy",
            "Eighty","Ninety","Hundred","Thousand","Lakh","Crore"};


   private void display(int number,String string_value){
        System.out.printf("Number:\t%d\n",number);
        System.out.printf("In Words:\t%s\n",string_value);
    }


    public String wordOflessThan_20(int number) {
       String complete_str=null;
        if (number == 0) {
            display(number, "Zero");
            System.exit(0);
        } else{
            for (int i = 1; i <= 20; i++) {
                if (number == this.number[i]) {
                    complete_str = words[i];
                }
            }
        }
        return complete_str;
    }


    public String wordOfLessThan_100(int number){
       int n = number;
        int last_value;
        last_value = number % 10;
        String orginal_word=null;
        if (last_value == 0) {
            try {
                for (int j = 20; j < 31; j++) {
                    if (n == this.number[j]) {
                        orginal_word = words[j];
                        System.exit(0);
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } else {
            try {
                //without last vlaue
                int vlaue = (n / 10) * 10;
                String first_word = null;
                String last_word = null;
                String space="-";
                String intermidate_word =null;
                String whole_word;
                for (int i = 20; i < 27; i++) {
                    if (vlaue == this.number[i]) {
                        first_word = words[i];
                        for (int j = 1; j < 10; j++) {
                            if (last_value == this.number[j]) {
                                last_word = words[j];
                                break;
                            }
                        }
                        break;
                    }
                }
                intermidate_word = first_word.concat(space);
                whole_word = intermidate_word.concat(last_word.toLowerCase());
                orginal_word = whole_word;
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return orginal_word;
        }


        public String wordOfLessThan_1000(int number){
            int real_number = number;
              String first_str=null;
              String last_str = null;
              String complete_str = null;
             if (number == 100) {
                 display(number, "One-hundred");
                 System.exit(0);
             }
             try {
                 int last_value = number % 100;
                 int first_value = real_number /100 ;
                 if (last_value == 0){//it's for 200/300 to 900
                     for (int i = 1;i<=9;i++){
                         if (first_value == this.number[i]){
                             first_str = words[i];
                             break;
                         }
                     }
                     complete_str = first_str.concat(" hundreds");
                 }
                 else {
                     for (int i = 1;i<=9;i++){
                         if (first_value == this.number[i]){
                             first_str = words[i];
                         }
                     }
                     last_str = wordOfLessThan_100(last_value);
                     complete_str=(first_str.concat(" hundreds ")).concat(last_str.toLowerCase());
                 }

             }catch (Exception e){
                 System.out.println(e);
             }
//             display(number,complete_str);
            return complete_str;
        }
        public String wordOfLessThan_100000(int number){
            int real_number = number;
            String first_str=null;
            String last_str = null;
            String complete_str = null;
            if (number == 1000){
                display(number,"One-thousand");
                System.exit(0);
            }
            try {
                int last_value = number % 1000;
                System.out.println(last_value);
                int first_value = real_number /1000 ;
                System.out.println(first_value);
                if (last_value == 0){//it's for 200/300 to 900
                    if (first_value<=20){
                        first_str = wordOflessThan_20(first_value);
                    }
                    else {
                        first_str = wordOfLessThan_100(first_value);
                    }
                    complete_str = first_str.concat(" thousands");
                }
                else {
                    if (first_value<=20){
                        first_str = wordOflessThan_20(first_value);
                    }
                    else {
                        first_str = wordOfLessThan_100(first_value);
                    }
                    last_str = wordOfLessThan_1000(last_value);
                    complete_str = (first_str.concat(" thousands ")).concat(last_str.toLowerCase());
                }
            }catch (Exception e){
                System.out.println(e);
            }
            return complete_str;
        }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter a number:");
        int number = scan.nextInt();
        NumberToWord num = new NumberToWord();
        if (number<=20){
            num.display(number,num.wordOflessThan_20(number));
        }
        else if (number<100){
            num.display(number,num.wordOfLessThan_100(number));
        }
        else if (number<1000){
            num.display(number,num.wordOfLessThan_1000(number));
        }
        else if (number<100000){
            num.display(number,num.wordOfLessThan_100000(number));
        }
    }
}