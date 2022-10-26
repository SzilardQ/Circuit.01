/*Maxim Dondiuc
Matrikelnummer 23193627
 */

import java.util.Scanner;
import java.lang.Math;

public class Circuit {


    public static void main(String[] args) {
        System.out.println("Bitte geben Sie einen Wert des Vorwiederstandes ein");
        Scanner scRes = new Scanner(System.in); // Scanner fuer die Eingabe des Vorwiederstandes

        double voltage, d1,d2,a1, a2, resistor1, resistor2,protectiveResistor;
        protectiveResistor = scRes.nextDouble();
        voltage=5; //Ohm
        d1 = 0.003; //meter
        d2 = 0.004; //meter
        a1 = 0.00097; //sqmeter
        a2 = 0.00051; //sqmeter
        resistor1 = 1000; //Ohm
        resistor2 = 472; //Ohm
        final double EPSILON_0 = 8.854 * Math.pow(10, -12);

        if (protectiveResistor > 0) {
            //Berechnung der Stromstaerke und die Leistung
            double current = voltage / protectiveResistor;
            double power = current * current * protectiveResistor;
            System.out.println("Curent " + current + " Apmere " + power + " Watt");
            System.out.println("Bitte geben sie ein Modul ein");

            Scanner scMod = new Scanner(System.in); // Scanner fuer die Eingabe der Module
            String module = scMod.nextLine();

            // die Konfiguration der Steckplatte

            switch  (module) {
                case "cap":
                    System.out.println("Kondensatoren");

                    //die Berechnung der Kapazitaet eines Plattenkondensators
                    double capacity1 = (EPSILON_0 * a1) / d1;
                    double capacity2 = (EPSILON_0 * a2) / d2;
                    System.out.println("Capacity1: " + capacity1 + " Farad");
                    System.out.println("Capacity2: " + capacity2 + " Farad");
                    
                    //die Berechnung der Gesamtkapazitaet der Schaltung
                    double totalCapacity = capacity1 + capacity2;
                    System.out.println("The total capacity is: " + totalCapacity + "Farad");
                    break;
                case "res":
                    System.out.println("Wiederstaende");
                    double totalResistance = (1 / resistor1) + (1 / resistor2);
                    System.out.println("The total resistence is: " + totalResistance + " Ohm");
                    break;
                case "short":
                    System.out.println("Kurzschuesse");
                    System.out.println("Board shorted - No modules installed!");
                    break;
                default:
                    System.err.println("Bitte das Programm neustarten und richtiges Modul eingeben");

                    break ;
            }


            scMod.close();
        } else {
            System.err.println("Bitte das Programm neustarten und positive Zahl eingeben");


        }

        scRes.close();


    }
}
