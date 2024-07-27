package structural.adapterdesign.chargers;

import java.text.MessageFormat;

public class AndroidCharger {
    public void doCharge(int p) {
        System.out.println(MessageFormat.format("Your phone has been charged till {0} from android charger", p));
    }
}
