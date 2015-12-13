package ua.bakum.aa.view.inform;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import oracle.security.xmlsec.saml2.metadata.Contact;

public class Statistics {
    static List<Inform> info = new ArrayList<Inform>();


    private static void Initiate() {
        info.add(new Inform("Продукция1", new BigDecimal(20), new BigDecimal(1736), new BigDecimal(542),
                            new BigDecimal(638)));
        info.add(new Inform("Продукция1", new BigDecimal(41), new BigDecimal(3558.8), new BigDecimal(1112.1),
                            new BigDecimal(638)));
        info.add(new Inform("Продукция1", new BigDecimal(60), new BigDecimal(5208), new BigDecimal(1626),
                            new BigDecimal(638)));
        info.add(new Inform("Продукция2", new BigDecimal(10), new BigDecimal(886), new BigDecimal(342),
                            new BigDecimal(366.6)));
        info.add(new Inform("Продукция2", new BigDecimal(21), new BigDecimal(1860.6), new BigDecimal(719.4),
                            new BigDecimal(366.6)));
        info.add(new Inform("Продукция2", new BigDecimal(40), new BigDecimal(3544), new BigDecimal(1368),
                            new BigDecimal(366.6)));
    }

    public Statistics() {
        super();
        Initiate();
    }

    public static List<Inform> findAllInform() {
        return info;
    }

    public static void clearBase() {
        info.clear();
        Initiate();
    }
}
