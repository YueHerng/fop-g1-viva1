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

        int x, y, b;

        while (true) {
            System.out.print("Enter width X: ");
            if (in.hasNextInt()) {
                x = in.nextInt();
            } else {
                in.next();                    
                x = -1;
            }
            System.out.print("Enter height Y: ");
            if (in.hasNextInt()) {
                y = in.nextInt();
            } else {
                in.next();
                y = -1;
            }
            System.out.print("Enter block size B: ");
            if (in.hasNextInt()) {
                b = in.nextInt();
            } else {
                in.next();
                b = -1;
            }

            boolean xOk = x >= 7 && x <= 29 && x % 2 == 1;
            boolean yOk = y >= 7 && y <= 29 && y % 2 == 1;
            boolean bOk = b >= 1 && b <= 3;
            if (xOk && yOk && bOk) {
                break;
            }
            System.out.println("Error: X and Y must be odd numbers between 7 and 29, and B must be between 1 and 3.");
        }

        int centreRow = y / 2;
        int centreCol = x / 2;

        for (int r = 0; r < y; r++) {
            int diag1 = (int) Math.round((double) r * (x - 1) / (y - 1));
            int diag2 = (x - 1) - diag1;

            for (int c = 0; c < x; c++) {
                boolean edgeRow = r == 0 || r == y - 1;
                boolean edgeCol = c == 0 || c == x - 1;
                char ch;

                if (edgeRow && edgeCol) {
                    ch = '+';
                } else if (edgeRow) {
                    ch = '=';
                } else if (edgeCol) {
                    ch = 'I';
                } else if (r == centreRow && c == centreCol) {
                    ch = '@';
                } else if (c == diag1 || c == diag2) {
                    ch = 'X';
                } else if (r == centreRow) {
                    ch = '-';
                } else if (c == centreCol) {
                    ch = '|';
                } else if ((r / b + c / b) % 2 == 0) {
                    ch = '.';
                } else {
                    ch = 'o';
                }
                System.out.print(ch);
            }
            System.out.println();
        }
        in.close();
    }
}
