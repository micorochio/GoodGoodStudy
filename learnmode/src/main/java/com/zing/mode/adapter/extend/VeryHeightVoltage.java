package com.zing.mode.adapter.extend;

/**
 * @author zing
 * @date 2018/3/6 18:06
 */
public class VeryHightVoltage {
    private int voltage = 120;

    public int usePowerSupply() {
        System.out.println("电源提供电压：" + voltage);
        return voltage;
    }

}
