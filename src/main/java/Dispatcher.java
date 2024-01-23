import comtroller.BankController;
import comtroller.RequsetMapping;
import lombok.AllArgsConstructor;

import java.lang.reflect.Method;

/**
 * 책임 : 라우팅
 */
@AllArgsConstructor
public class Dispatcher {
    private BankController con;

    public void route(String url) {
        Method[] methods = con.getClass().getDeclaredMethods();
        //System.out.println(methods.length);

        for (Method method : methods) {
            //System.out.println(method.getName());
            RequsetMapping rm = method.getDeclaredAnnotation(RequsetMapping.class);

            if (rm == null)continue;

            if (rm.uri().equals(url)) {
                try {
                    method.invoke(con);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
