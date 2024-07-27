package structural.adapterdesign.chargers;

public class IphoneAndroidAdapter implements IphoneCharger {
    AndroidCharger androidCharger = new AndroidCharger();

    @Override
    public void doChargingTill(int p) {
        androidCharger.doCharge(p);
    }
}
