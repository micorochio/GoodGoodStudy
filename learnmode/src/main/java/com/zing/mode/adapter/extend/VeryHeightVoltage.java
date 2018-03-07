package com.zing.mode.adapter.extend;

/**
 * @author zing
 * @date 2018/3/6 18:06
 */
public class VeryHeightVoltage {
    private int voltage = 120;

    public int power() {
        System.out.println("电源提供电压：" + voltage);
        return voltage;
    }

}
