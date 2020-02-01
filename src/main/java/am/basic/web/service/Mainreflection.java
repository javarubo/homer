package am.basic.web.service;

import am.basic.web.model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Mainreflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Class clazz = Class.forName("am.basic.web.model.User");
        Object object = clazz.newInstance();
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(object, "karen");

        Field fields[] = clazz.getDeclaredFields();

        for (Field fieldz : fields) {
            System.out.println(fieldz.getName());

        Annotation annotation[]=fieldz.getDeclaredAnnotations();
            for ( Annotation annot:annotation) {
                System.out.println(annot.annotationType());

            }









        }



    }
}
