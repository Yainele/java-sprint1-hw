public class StepTracker {
    int stepGoal = 10000;
    int [][] monthOfYear;
    Converter converter = new Converter();
    public StepTracker() {
        monthOfYear = new int[12][30];
    }
    boolean isMonthCorrect(int month){
        if(month < 0 || month > 11){
            System.out.println("Ошибка! Введите месяц в диапозоне от 0 до 11\n");
            return false;
        }
        else {
            return true;
        }
    }
    boolean isDayCorrect(int dayOfMonth){
        if(dayOfMonth < 1 || dayOfMonth > 30){
            System.out.println("Ошибка! Введите день в диапозоне от 1 до 30\n");
            return false;
        }
        else {
            return true;
        }
    }
    boolean isStepsCorrect(int steps){
        if(steps < 0){
            System.out.println("Ошибка! Введите положительное количество шагов.\n");
            return false;
        }
        else {
            return true;
        }
    }
    void enterSteps(int month, int dayOfMonth, int steps) {
        if(!isMonthCorrect(month) || !isDayCorrect(dayOfMonth) || !isStepsCorrect(steps)){
            return;
        }
        for (int i = 0; i < monthOfYear.length; i++) {
            for(int j = 0; j < monthOfYear[i].length; j++) {
                if (month == i && (dayOfMonth - 1) == j) {
                    int swap = steps;
                    steps = monthOfYear[month][dayOfMonth - 1];
                    monthOfYear[month][dayOfMonth - 1] = swap;
                }
            }
        }
        System.out.println("Значение сохранено!\n");
    }
    void takenSteps(int month){
        System.out.println("Количество пройденных шагов по дням: \n" );
        for (int i = 0; i < 30; i++) {
            System.out.println("День " + (i+1) + ": " + monthOfYear[month][i] + " шагов;");
        }
    }
    double totalSteps(int month){
        double sumOfSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumOfSteps += monthOfYear[month][i];
        }
        return sumOfSteps;
    }
    int maxAmount(int month){
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if(monthOfYear[month][i] > maxSteps){
                maxSteps = monthOfYear[month][i];
            }
        }
        return maxSteps;
    }
    double avgNumOfSteps(int month){
        return totalSteps(month) / 30;
    }
    int bestSeries(int month){
        int bestSeries = 0;
        int maxBestSeries = 0;
        for (int i = 0; i < 30; i++) {
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
        if(!isMonthCorrect(month)){
            return;
        }
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
        if (!isStepsCorrect(newStepGoal)){
            return;
        }
        stepGoal = newStepGoal;
        System.out.println("Значение сохранено! Ваша текущая цель по шагам: " + stepGoal);
    }
}