/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viva1;

/**
 *
 * @author ethan
 */
import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        String[] vehicles = {"Compact Hatch", "Family SUV", "Delivery Van", "E-Scooter"};
        String[] batteryAndPower = {"(40kWh, max 50 kW)", "(75 kWh, max 120 kW)", "(90 kWh, max 80 kW)", "(4 kWh, max 3 kW)"};
        double hubBattery = 150.0, chargeTime, energyDelivered, drawnFromHub, chargeLevel, targetCharge, actualCharge = 0, totalEnergy = 0, cost = 0, totalRevenue = 0;
        double[] vehicleBattery = {40.0, 75.0, 90.0, 4.0};
        boolean[] charged = new boolean[4];
        int choice, chargeCount = 0, chargePower;
        int[] maxPower = {50, 120, 80, 3};
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("===== Solar EV Charging Hub =====");
            System.out.printf("Hub Battery: %.2f kWh\n", hubBattery);
            for (int i = 0; i < vehicles.length; i++){
                if(charged[i]){
                    System.out.println((i+1) + ". " + vehicles[i] + " " + batteryAndPower[i] + " [DONE]");
                }
                else{
                    System.out.println((i+1) + ". " + vehicles[i] + " " + batteryAndPower[i]);
                }
            }
            System.out.println("0. Close Hub");
            System.out.print("Select a vehicle (0-4): ");
            choice = in.nextInt();
            if (choice < 0 || choice > 4){
                System.out.println("Error: Please enter an integer from 0 and 4.\n");
                continue;
            }
            if (choice == 0){
                System.out.println("Hub closed by operator.\n");
                break;
            }
            if (charged[choice - 1]){
                System.out.println("Error: This vehicle has already been charged.\n");
                continue;
            }
            while(true){
                System.out.print("Enter current battery level (0-99): ");
                chargeLevel = in.nextInt();
                if (chargeLevel < 0 || chargeLevel > 99){
                    System.out.println("Error: Battery level must be between 0 and 99.");
                    continue;
                }
                break;
            }
            while(true){
                System.out.printf("Enter target battery level (%d-100): ", (int) chargeLevel + 1);
                targetCharge = in.nextInt();
                if (targetCharge <= chargeLevel || targetCharge > 100){
                    System.out.println("Error: Target must be higher than current level and at most 100.");
                    continue;
                }
                break;
            }
            if (maxPower[choice-1] < 60){
                chargePower = maxPower[choice-1];
            } else {
                chargePower = 60;
            }
            energyDelivered = vehicleBattery[choice-1] * (targetCharge - chargeLevel) / 100.0;
            drawnFromHub = energyDelivered / 0.9;
            if (drawnFromHub > hubBattery){
                drawnFromHub = hubBattery;
                energyDelivered = drawnFromHub * 0.9;
                actualCharge = (chargeLevel + (energyDelivered / vehicleBattery[choice-1])) * 100.0;
                }
            chargeTime = energyDelivered / chargePower * 60;
            hubBattery -= drawnFromHub;
            if (energyDelivered > 30){
                cost = (1.2 * energyDelivered) * 0.95;
            }
            else{
                cost = (1.2 * energyDelivered);
            }
            totalEnergy += energyDelivered;
            totalRevenue += cost;
            charged[choice-1] = true;
            chargeCount++;
            System.out.println("\n--- Charging Summary ---");
            System.out.println("Vehicle: " + vehicles[choice - 1]);
            System.out.printf("Battery: %d%% -> %d%%%n",(int) chargeLevel, (int) targetCharge);
            System.out.printf("Charging Power: %d kW%n", chargePower);
            System.out.printf("Energy Delivered: %.2f kWh (drawn from hub: %.2f kWh)%n",energyDelivered, drawnFromHub);
            System.out.printf("Charging Time: %.2f minutes%n", chargeTime);
            System.out.printf("Cost: RM%.2f%n", cost);
            if (hubBattery > 0){
            System.out.printf("Remaining Hub Battery: %.2f kWh%n",hubBattery);
            }
            else{
            System.out.printf("Hub Battery Depleted! Vehicle only reached %.2f%%.%n",actualCharge);
            System.out.println("------------------------\n");
            break;
            }
            System.out.println("------------------------\n");
        }
        System.out.println("===== Hub Report =====");
        System.out.println("Vehicles charged: " + chargeCount);
        System.out.printf("Total Energy Delivered: %.2f kWh%n", totalEnergy);
        System.out.printf("Total Revenue: RM%.2f%n", totalRevenue);
        System.out.printf("Hub Battery Left: %.2f kWh%n", hubBattery);
        in.close();
    }
}

