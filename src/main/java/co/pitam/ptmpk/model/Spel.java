package co.pitam.ptmpk.model;

import java.util.Date;
import java.util.GregorianCalendar;

public class Spel {
    public record Inventor(String name, Date birthday, String nationality, String[] inventionsArray){

    }

    public static Inventor TELSA=new Inventor("Nikola Telsa",
    new GregorianCalendar(1856,7,9).getTime(),"Serbian",
            new String[]{"induction motor","commutator for dynamo"}
    );

}
