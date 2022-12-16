
public class StepTracker {
    int stepGoal = 10000;
    int [][] monthOfYear;
    Converter converter = new Converter();
    public StepTracker() {
        monthOfYear = new int[12][30];
    }
    void enterSteps(int month, int dayOfMonth, int steps) {
        monthOfYear[month][dayOfMonth - 1] = steps;
        System.out.println("Значение сохранено!\n");
    }
    void takenSteps(int month){
        StringBuffer sBuffer = new StringBuffer();
        System.out.println("Количество пройденных шагов по дням: \n" );
        for (int i = 0; i < monthOfYear[month].length; i++) {
            sBuffer.append(i + 1).append(" день").append(": ").append(monthOfYear[month][i]).append(" шагов, ");
        }
        System.out.println(sBuffer);
    }
    double totalSteps(int month){
        double sumOfSteps = 0;
        for (int i = 0; i < monthOfYear[month].length; i++) {
            sumOfSteps += monthOfYear[month][i];
        }
        return sumOfSteps;
    }
    int maxAmount(int month){
        int maxSteps = 0;
        for (int i = 0; i < monthOfYear[month].length; i++) {
            if(monthOfYear[month][i] > maxSteps){
                maxSteps = monthOfYear[month][i];
            }
        }
        return maxSteps;
    }
    double avgNumOfSteps(int month){
        return totalSteps(month) / monthOfYear[month].length;
    }
    int bestSeries(int month){
        int bestSeries = 0;
        int maxBestSeries = 0;
        for (int i = 0; i < monthOfYear[month].length; i++) {
            if(monthOfYear[month][i] >= stepGoal){
                ++bestSeries;
            } else{
                bestSeries = 0;
            }
            if(maxBestSeries < bestSeries){
                maxBestSeries = bestSeries;
            }
        }
        return maxBestSeries;
    }
    void printStatistic(int month) {
        double stepsKm = converter.distanceCalculation(totalSteps(month));
        double kilocalories = converter.caloriesCalculation(totalSteps(month));
        takenSteps(month);
        System.out.println("\nОбщее количество шагов за месяц: " + totalSteps(month) + "\n" +
                           "Максимальное количество шагов за месяц: " + maxAmount(month) + "\n" +
                           "Среднее количество шагов за месяц: " + avgNumOfSteps(month) + "\n" +
                           "Лучшая серия: " + bestSeries(month) + "\n" +
                           "Дистанция в километрах: " + stepsKm + "\n" +
                           "Количество сожжённых килокалорий: " + kilocalories + "\n");
    }
    void changeStepGoal(int newStepGoal) {
        stepGoal = newStepGoal;
        System.out.println("Значение сохранено! Ваша текущая цель по шагам: " + stepGoal);
    }
}