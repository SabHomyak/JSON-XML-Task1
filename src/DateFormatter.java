import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter extends XmlAdapter<String, Date> {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public Date unmarshal(String v) throws Exception {
        return sdf.parse(v);

    }

    @Override
    public String marshal(Date v) {
        return sdf.format(v);
    }

}
