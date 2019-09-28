import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "train")
@XmlType(propOrder = {"from", "to", "date", "departure", "id"})
public class Train {
    private String from;
    private String to;
    private Date date;
    private String departure;
    private static int countId = 0;
    private int id;

    public Train() {
        countId++;
    }

    public Train(String from, String to, Date date, String departure) {
        this.from = from;
        this.to = to;
        this.date = date;
        if (departure.matches("([0-1]?[0-9]|2[0-3])[:]([0-5][0-9])")) {
            this.departure = departure;
        } else {
            this.departure = "unknown";
            System.out.println("You entered an invalid date format!");
        }
        countId++;
        id = countId;
    }

    @XmlElement
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement
    @XmlJavaTypeAdapter(DateFormatter.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlElement
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @XmlAttribute()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(from, train.from) &&
                Objects.equals(to, train.to) &&
                Objects.equals(date, train.date) &&
                Objects.equals(departure, train.departure);
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, to, date, departure);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "Train{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + sdf.format(date) + '\'' +
                ", departure='" + departure + '\'' +
                ", id=" + id +
                '}';
    }
}
