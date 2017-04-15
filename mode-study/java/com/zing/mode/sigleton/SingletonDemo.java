package com.zing.mode.sigleton;

/**
 * Created by zing on 2017/4/9.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        HungerSingleton s1 = HungerSingleton.getInstance();
        HungerSingletonWithStatic s2 = HungerSingletonWithStatic.getInstance();
        LazySingletonUnSafe s3 = LazySingletonUnSafe.getInstance();
        LazySingletonSafe s4 = LazySingletonSafe.getInstance();
        LazySingletonDoubleCheck s5 = LazySingletonDoubleCheck.getInstance();
        SingletonWithStaticHolder s6 = SingletonWithStaticHolder.getInstance();
        SingletonEnum s7 = SingletonEnum.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
    }
}

/**
 * 饿汉模式
 */
class HungerSingleton {
    private static HungerSingleton singleton = new HungerSingleton();

    private HungerSingleton() {
    }

    public static HungerSingleton getInstance() {
        return singleton;
    }
}

/**
 * 饿汉模式变种
 */
class HungerSingletonWithStatic {
    private static HungerSingletonWithStatic singleton;

    static {
        singleton = new HungerSingletonWithStatic();

    }

    private HungerSingletonWithStatic() {
    }

    public static HungerSingletonWithStatic getInstance() {
        return singleton;
    }
}


/**
 * 懒汉模式不安全
 */
class LazySingletonUnSafe {
    private static LazySingletonUnSafe singleton = null;

    private LazySingletonUnSafe() {
    }

    public static LazySingletonUnSafe getInstance() {
        if (null == singleton) {
            singleton = new LazySingletonUnSafe();
        }
        return singleton;
    }
}

/**
 * 懒汉模式 安全
 */
class LazySingletonSafe {
    private static LazySingletonSafe singleton = null;

    private LazySingletonSafe() {
    }

    public static synchronized LazySingletonSafe getInstance() {
        if (null == singleton) {
            singleton = new LazySingletonSafe();
        }
        return singleton;
    }
}

/**
 * 懒汉模式 安全 双层检查
 */
class LazySingletonDoubleCheck {
    private static LazySingletonDoubleCheck singleton = null;

    private LazySingletonDoubleCheck() {
    }

    public static LazySingletonDoubleCheck getInstance() {
        if (null == singleton) {
            synchronized (LazySingletonDoubleCheck.class) {
                if (null == singleton) {
                    singleton = new LazySingletonDoubleCheck();
                }
            }
        }
        return singleton;
    }
}


/**
 * 静态内部类
 */
class SingletonWithStaticHolder {

    private static class ClassHolder {
        static SingletonWithStaticHolder singleton = new SingletonWithStaticHolder();
    }

    private SingletonWithStaticHolder() {
    }

    public static SingletonWithStaticHolder getInstance() {
        return ClassHolder.singleton;
    }
}

/**
 * 枚举单利
 */
enum SingletonEnum {
    SINGLETON_Instance;

    public static SingletonEnum getInstance() {
        return SINGLETON_Instance;
    }
}