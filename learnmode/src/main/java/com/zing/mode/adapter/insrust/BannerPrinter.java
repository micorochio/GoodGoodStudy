package com.zing.mode.adapter.insrust;

/**
 * @author zing
 * @date 2018/3/7 10:37
 */
public class BannerPrinter extends Printer {
    Banner banner;

    public BannerPrinter(String slogan) {
        this.banner = new Banner(slogan);
    }

    @Override
    public void printWeak() {
        banner.showWithParten();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
