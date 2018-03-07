package com.zing.mode.adapter.extend;

/**
 * @author zing
 * @date 2018/3/6 18:15
 */
public class VoltageAdapter extends VeryHeightVoltage implements PowerAdapter {

    public VoltageAdapter() {
    }

    public int usePowerSupply() {
        int height = super.power();
        System.out.println("降压50%");
        return height / 2;
    }
}
