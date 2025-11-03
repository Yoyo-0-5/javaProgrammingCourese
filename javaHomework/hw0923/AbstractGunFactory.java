package javaHomework.hw0923;

public abstract class AbstractGunFactory {

    public abstract <T extends AbstractGun> T generateGun(Class<T> c);
}
