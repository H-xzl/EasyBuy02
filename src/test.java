import com.dao.impl.UserDaoImp;
import com.entity.Level;
import com.entity.User;
import com.service.impl.LevelServiceImp;
import com.service.impl.ShopServiceImp;
import com.service.impl.UserServiceImp;
import com.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.List;

public class test {
    public static void main(String[] args) throws Exception {
//        User user=new User(2, "tyui", "asd01", "123456789", "nan", 1);
//        System.out.println(new UserServiceImp().addUser(user));

//        List<User> list=new UserServiceImp().selPageList(1,5);
//        System.out.println(list.size());
//        User user=list.get(2);
//        System.out.println(user.getLoginname());
       //System.out.println(new UserServiceImp().delUser(5));
        //System.out.println(new UserServiceImp().selectById(1).getUsername());
//        System.out.println(new UserServiceImp().updUserById(user)  );

        //System.out.println(new ShopServiceImp().allShopsNum());

//        System.out.println(new ShopServiceImp().selPageshopInfo(1, 5).size());
//        System.out.println(new ShopServiceImp().delShopInfo(5));
//        System.out.println(new LevelServiceImp().insLevelInfo(new Level(null,"手机")));
       // System.out.println(new LevelServiceImp().selLevelInfo().size());
//        System.out.println(new LevelServiceImp().delLevelInfo(6));
        System.out.println(new LevelServiceImp().updLevelInfo(new Level(11,"冰箱")));

    }
}
