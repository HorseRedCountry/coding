package aboutaop;
/*
    第三步：定义中介，中介是要帮租户实现租房子的
           需求，所以也要实现租房接口
 */
public class RentHouseProxy implements RentHouse{
    private RentHouse rentHouse;
    public RentHouseProxy(RentHouse rentHouse){
        this.rentHouse=rentHouse;
    }
    public void rentHouse() {
        System.out.println("中介：搜集房源......");
        System.out.println("中介：对比市场价格......");
        System.out.println("中介：确定租金......");
        System.out.println("中介：前房屋租赁合同......");
        System.out.println("中介：装修装修，摆点物件......");
        rentHouse.rentHouse();
        System.out.println("中介：租房完毕......");
    }
}
