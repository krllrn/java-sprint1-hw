public class Converter {

    Double distance(int steps) {
        double distance = 0.0;
        distance = (steps*75)/100000;
        return distance;
    }

    Double kkal(int steps) {
        double kkal = 0.0;
        kkal = (steps*50)/1000;
        return kkal;
    }
}