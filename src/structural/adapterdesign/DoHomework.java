package structural.adapterdesign;

import structural.adapterdesign.chargers.IphoneAndroidAdapter;
import structural.adapterdesign.chargers.IphoneCharger;

class ChargeIphone {
    private IphoneCharger iphoneCharger;

    public IphoneCharger getIphoneCharger() {
        return iphoneCharger;
    }

    public void setIphoneCharger(IphoneCharger charger) {
        iphoneCharger = charger;
    }

    public void chargeTillPercent(int p) {
        iphoneCharger.doChargingTill(p);
        System.out.println("Your iphone charged till " + p);
    }
}

public class DoHomework {
    public static void main(String[] args) {
        ChargeIphone myIphone = new ChargeIphone();
        IphoneAndroidAdapter iphoneAndroidAdapter = new IphoneAndroidAdapter();
        myIphone.setIphoneCharger(iphoneAndroidAdapter);
        myIphone.chargeTillPercent(90);
    }
}
