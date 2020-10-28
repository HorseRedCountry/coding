package aboutaop;
/**
    第二步：定义租客，实现租房接口，表明租客有租房的需求
 */
public class Tenant implements RentHouse{
    @Override
    public void rentHouse() {
        System.out.println("租客：我想租房！");
    }
}
