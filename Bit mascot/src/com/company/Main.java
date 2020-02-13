package com.company;



public class Main {

        public static void main(String[] args)
        {
          Thread t1 = new getContent();
          Thread t2 = new printContent();
          t1.start();
          t2.start();
            System.out.println("done");
        }

}
