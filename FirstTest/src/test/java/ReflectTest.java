import com.shuyun.entity.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by shuyun on 2016/8/2.
 * 反射的测试类
 */
public class ReflectTest {
    @Test
    public void test() {
        // Class cla=String.class;
        Class cla = null;
        try {
            cla = Class.forName("com.shuyun.entity.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor[] constructor = cla != null ? cla.getDeclaredConstructors() : new Constructor[0];
        for (Constructor aConstructor : constructor) {
            Class prev[] = aConstructor.getParameterTypes();
            for (int j = 0; j < prev.length; j++) {
                System.out.println("parm#" + j + "  " + prev[j]);
            }
            System.out.println(aConstructor.getName());
        }
        //获取类的字段
        Field[] fields = cla != null ? cla.getDeclaredFields() : new Field[0];
        for (Field field : fields) {
            //获取字段名
            System.out.println("########");
            System.out.println("fieldName=" + field.getName());
            System.out.println("class=" + field.getDeclaringClass());
            System.out.println("fieldType=" + field.getType());
            int mod = field.getModifiers();
            System.out.println("字符的修饰语=" + Modifier.toString(mod));
            System.out.println("********");
        }
        //根据方法的名称来执行方法
        try {
            //得到类的实例
            Object obj = cla != null ? cla.newInstance() : null;
            //根据属性名获得属性
            Field field = cla != null ? cla.getDeclaredField("stuName") : null;
            //根据方法名和属性类型获取方法
            Method method = cla.getDeclaredMethod("setStuName", field.getType());
            method.invoke(obj, "wenjia");
            Student student=(Student)obj;
            System.out.println( "得到名字："+student.getStuName());
            System.out.println("得到方法的类型"+method.getReturnType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Method[] methods = cla != null ? cla.getDeclaredMethods() : new Method[0];
        for (Method method : methods) {
            System.out.println(method.toString());
        }
    }
}
