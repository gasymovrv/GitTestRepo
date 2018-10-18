import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        System.out.println("еще один коммит в новую ветку");
        System.out.println("не надо мне тут бла-бла-бла");
        Class entityClass = Entity.class;
        Method[] methods = entityClass.getMethods();
        Connection connection = new Connection();
        System.out.println(connection.connect());
        int i = 0;
        String s = "string";
        for (Method m :
                methods) {
            try {
                if (m.getDeclaringClass().equals(entityClass)) {
                    System.out.println(m.invoke(entityClass.newInstance(),s+i,i++));
                }
            } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
    public static void util(){
        System.out.println("печатаем из develop");
    }
}
