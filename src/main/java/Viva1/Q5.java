/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viva1;

/**
 *
 * @author Yue Herng
 */
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int X, Y, B;
        boolean Input = false;

        do {
            System.out.print("Enter width X: ");
            X = in.nextInt();
            System.out.print("Enter height Y: ");
            Y = in.nextInt();
            System.out.print("Enter block size B: ");
            B = in.nextInt();

            boolean testX = (X >= 7 && X <= 29 && X % 2 != 0);
            boolean testY = (Y >= 7 && Y <= 29 && Y % 2 != 0);
            boolean testB = (B >= 1 && B <= 3);

            if (testX && testY && testB) {
                Input = true;
            } else {
                System.out.println("Error: X and Y must be odd numbers between 7 and 29, and B must be between 1 and 3.");
                System.out.println();
            }
        } while (!Input);

        int centreRow = Y / 2;
        int centreCol = X / 2;

        for (int r = 0; r < Y; r++) {
            int diag1 = (int) Math.round((double) r * (X - 1) / (Y - 1));
            int diag2 = (X - 1) - diag1;

            for (int c = 0; c < X; c++) {
                boolean FirstOrLastRow = (r == 0 || r == Y - 1);
                boolean FirstOrLastCol = (c == 0 || c == X - 1);

                if (FirstOrLastRow && FirstOrLastCol) {
                    System.out.print("+");
                } else if (FirstOrLastRow) {
                    System.out.print("=");
                } else if (FirstOrLastCol) {
                    System.out.print("|");
                } else if (r == centreRow && c == centreCol) {
                    System.out.print("@");
                } else if (c == diag1 || c == diag2) {
                    System.out.print("X");
                } else if (r == centreRow) {
                    System.out.print("-");
                } else if (c == centreCol) {
                    System.out.print("|");
                } else if ((r / B + c / B) % 2 == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("o");
                }
            }
            System.out.println();
        }

        in.close();
    }
}