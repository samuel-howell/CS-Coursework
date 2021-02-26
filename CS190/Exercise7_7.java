package com.company;
//Samuel Howell 10-28-19
public class Exercise7_7 {

    public static void main(String[] args) {
     int[]counts = new int[10];                              //create an array to hold the counts of ten values (0-9)


        for(int k = 0; k<100; k++) {                        //k will equal 0-99, which is 100 total
            int i = 1;                                       //i is the value that will be added to an array whenever the random number equals that array number
            int randomNumber = (int) (Math.random() * 10); //create a random number 0-9
            switch(randomNumber) {                          //create a switch statement to decide which array the random letter goes in
                case 0: counts[0] = i + counts[0]; break;
                case 1: counts[1] = i + counts[1]; break;
                case 2: counts[2] = i + counts[2]; break;
                case 3: counts[3] = i + counts[3]; break;
                case 4: counts[4] = i + counts[4]; break;
                case 5: counts[5] = i + counts[5]; break;
                case 6: counts[6] = i + counts[6]; break;
                case 7: counts[7] = i + counts[7]; break;
                case 8: counts[8] = i + counts[8]; break;
                case 9: counts[9] = i + counts[9]; break;
            }
        }
      for (int j = 0;j< counts.length; j++) { //j will equal 0-9, and will print out the array at each of those positions
          System.out.print(counts[j] + " ");
      }
    }
}
