import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Trains {
    private List<Train> trainList = new ArrayList<>();

    public Trains() {
    }

    public Trains(List<Train> trainList) {
        this.trainList = trainList;
    }

    @XmlElement(name = "train")
    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    public void addTrain(Train train) {
        if (trainList.contains(train)) {
            System.out.println("This train already exists!");
        } else {
            trainList.add(train);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        trainList.forEach(t -> sb.append(t + System.lineSeparator()));
        return sb.toString();
    }
}
