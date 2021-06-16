package jvm;

public class T001_ClassLoadLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(T001_ClassLoadLevel.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T001_ClassLoadLevel.class.getClassLoader().getClass().getClassLoader());
    }

    public void prints() {
        System.out.println("类加载成功");
    }
}
