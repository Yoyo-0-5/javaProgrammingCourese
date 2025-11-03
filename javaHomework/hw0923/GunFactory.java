package javaHomework.hw0923;

public class GunFactory extends AbstractGunFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T extends AbstractGun> T generateGun(Class<T> c) {
        AbstractGun gun = null;
        try {
            gun = c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) gun;
    }

}
