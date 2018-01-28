package com.zing.nio_study.kans;

public class DuiZhan {
    private String orderNo;
    private int amount;
    private String state;

    public DuiZhan(String orderNo, int amount, String state) {
        this.orderNo = orderNo;
        this.amount = amount;
        this.state = state;
    }

    public String di() {
        return String.valueOf(orderNo.hashCode() + amount + state.hashCode());
    }

    @Override
    public int hashCode() {
        return di().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DuiZhan duiZhan = (DuiZhan) o;

        if (amount != duiZhan.amount) return false;
        if (orderNo != null ? !orderNo.equals(duiZhan.orderNo) : duiZhan.orderNo != null) return false;
        return state != null ? state.equals(duiZhan.state) : duiZhan.state == null;
    }

    @Override
    public String toString() {
        return "DuiZhan{" +
                "orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                ", state='" + state + '\'' +
                '}';
    }
}
