package aboutaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/*
    测试
    结果：中介：搜集房源......
         中介：对比市场价格......
         中介：确定租金......
         中介：前房屋租赁合同......
         中介：装修装修，摆点物件......
         租客：我想租房！
         中介：租房完毕......
 */
public class ProxyDemo {
    public static void main(String[] args) {
        /*RentHouse rentHouse=new Tenant();
        RentHouseProxy proxy=new RentHouseProxy(rentHouse);
        proxy.rentHouse();*/
        RentHouse tenant=new Tenant();
        InvocationHandler handler=new DynamicRentHouseProxy(tenant);
        /*
            newProxyInstance运用反射的原理为我们生成一个代理类对象
         */
        RentHouse rentHouse=(RentHouse) Proxy.newProxyInstance(Tenant.class.getClassLoader(),
                Tenant.class.getInterfaces(),handler);
        rentHouse.rentHouse();
    }
}

