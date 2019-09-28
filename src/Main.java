import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Trains trains = (Trains) XmlWorker.unmarshal(new File("trains.xml"), Trains.class);
        trains.addTrain(new Train("Moscow", "Warsaw", new Date(), "16:45"));
        XmlWorker.marshal(trains, new File("trains.xml"));
        System.out.println(trains);
        System.out.println("List of trains that depart today:");
        trains.getTrainList().stream()
                .filter(d -> new SimpleDateFormat("dd.MM.yyyy").format(d.getDate()).equals(new SimpleDateFormat("dd.MM.YYYY").format(new Date())))
                .forEach(System.out::println);
    }
}
