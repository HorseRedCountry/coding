package aboutaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/*
    动态代理

 */
public class DynamicRentHouseProxy implements InvocationHandler {
    private Object rentHouse;

    public DynamicRentHouseProxy(Object rentHouse) {
        this.rentHouse = rentHouse;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("中介：搜集房源......");
        System.out.println("中介：对比市场价格......");
        System.out.println("中介：确定租金......");
        System.out.println("中介：前房屋租赁合同......");
        System.out.println("中介：装修装修，摆点物件......");
        Object result=method.invoke(rentHouse,args);
        System.out.println("中介：租房完毕......");
        return result;
    }
}
