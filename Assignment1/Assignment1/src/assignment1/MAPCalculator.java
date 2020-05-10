/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author 12102452
 */
// Class to calculate the MAP value and category value
public class MAPCalculator {

    public MAPCalculator() {
        // no code required
    }

    // Method to calculate & return map value
    public double value(double sbp, double dbp) {
        double map = 0;// Variable for storing MAP value
        map = (1.0 / 3.0) * sbp + (2.0 / 3.0) * dbp; // MAP value computation 
        return map; // Returning MAP value
    }

    // Method to check category on the basis of map value
    public String category(double map) {
        // Check whether the map value is "HIGH", "LOW" or "NORMAL"
        if (map >= 70 && map < 100) {
            return "NORMAL";   // Return  normal value
        } else if (map < 70) {
            return "LOW"; // Return low value
        } else {
            return "HIGH";// Return high value
        }
    }

}
