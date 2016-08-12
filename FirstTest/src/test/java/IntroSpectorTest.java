import com.shuyun.entity.Student;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by shuyun on 2016/8/2.
 * 对java内省测试
 */
public class IntroSpectorTest {
    public static void main(String[] args) throws Exception {
        Class cla = Student.class;
        Object obj = cla.newInstance();
        Field[] fields = cla.getDeclaredFields();
        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), cla);
            Method methods = pd.getWriteMethod();
            System.out.println(field.getType());
            if (field.getName().equals("stuName")) {
                methods.invoke(obj, "文佳");
            } else {
                methods.invoke(obj, 12);
            }
        }

        String name = null;
        int id = 0;
        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), cla);
            System.out.println(pd.getName());
            Method method = pd.getReadMethod();
            if (pd.getName().equals("stuName")) {
                name = (String) method.invoke(obj);
            } else {
                id = (Integer) method.invoke(obj);
            }
        }
        System.out.println("name=" + name + "      id=" + id);
    }

}
