public class Converter {
    final int centToKilometer = 100000;
    final int caloriesToKilo = 1000;
    final int oneStepInCm = 75;
    final int oneStepInCalories = 50;
        double distanceCalculation(double steps){
            return (steps * oneStepInCm) / centToKilometer;
        }
        double caloriesCalculation(double steps){
            return (steps * oneStepInCalories) / caloriesToKilo;
        }

}
