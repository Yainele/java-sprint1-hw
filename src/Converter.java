public class Converter {
    final  int a = 100000;
    final  int b = 1000;
    final int x = 75;
    final int y = 50;
        double distanceCalculation(double steps){
            return (steps * x) / a;
        }
        double caloriesCalculation(double steps){
            return (steps * y) / b;
        }

}
