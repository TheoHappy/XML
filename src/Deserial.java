import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Deserial {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        xstream.processAnnotations(ValCurs.class);
        xstream.processAnnotations(Valute.class);
//
//        String xml = "<ValCurs Date=\"26.02.1994\" name=\"Обменные ставки\"><Valute ID=\"44\"><NumCode>840</NumCode><CharCode>USD</CharCode><Nominal>1</Nominal><Name>Доллар США</Name><Value>3.8500</Value></Valute><Valute ID=\"43\"><NumCode>804</NumCode><CharCode>UAK</CharCode><Nominal>0</Nominal><Name>Украинский Карбованец</Name><Value>0.0000</Value></Valute></ValCurs>";
        String data = null;
        try {
            data = new String(Files.readAllBytes(Paths.get("courses.xml")));
        }catch(IOException e){
            e.printStackTrace();
        }
        ValCurs valCurs = (ValCurs)xstream.fromXML(data);

        for(Valute currentVal : valCurs.getValutes())  {
            System.out.println(currentVal);
        }

    }
}
