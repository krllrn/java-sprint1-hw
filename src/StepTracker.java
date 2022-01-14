import java.util.HashMap;

public class StepTracker {
    Converter converter = new Converter();
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    int yourGoal = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    class MonthData {
        int[] dayNumber = new int[30];
    }

    public void daysAndSteps(int monthNumber, int dayNumber, int steps) {
        monthToData.get(monthNumber).dayNumber[dayNumber-1] += steps;
        System.out.println("Данные сохранены.");
    }

    public void monthStatistic(int monthNumber) {
        int sumOfSteps = 0;
        int maxOfSteps = 0;
        byte bestSeries = 0;
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < monthToData.get(monthNumber).dayNumber.length; i++) {
            System.out.println((i+1)+" день: "+monthToData.get(monthNumber).dayNumber[i]);
            sumOfSteps += monthToData.get(monthNumber).dayNumber[i];
            if (monthToData.get(monthNumber).dayNumber[i] > maxOfSteps) {
                maxOfSteps = monthToData.get(monthNumber).dayNumber[i];
            }
            if (monthToData.get(monthNumber).dayNumber[i] > yourGoal &&
                    (monthToData.get(monthNumber).dayNumber[i+1] > yourGoal
                            || monthToData.get(monthNumber).dayNumber[i-1] > yourGoal)) {
                bestSeries +=1;
            }
        }
        System.out.println("Общее количество шагов за месяц: "+sumOfSteps);
        System.out.println("Максимальное количество шагов за месяц: "+maxOfSteps);
        System.out.println("Среднее количество шагов за месяц: "+(sumOfSteps/monthToData.get(monthNumber).dayNumber.length));
        System.out.println("Пройденная дистанция (в км): "+converter.distance(sumOfSteps));
        System.out.println("Количество сожженных килокалорий: "+converter.kkal(sumOfSteps));
        System.out.println("Лушая серия: "+bestSeries);
    }
} 