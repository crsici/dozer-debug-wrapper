package com.flyingsh4rk;

import com.flyingsh4rk.test.model.A;
import com.flyingsh4rk.test.model.B;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.dozer.DozerBeanMapper;

import java.util.Arrays;

/**
 * Created by pthanhtrung on 11/15/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getParent());

        Thread.currentThread().setContextClassLoader(new ClassLoader() {
            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                System.out.println(name);
                return super.loadClass(name, resolve);
            }




        });
        System.out.println("Something interesting");
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList("test-mapping.xml"));
        B b = mapper.map(new A(), B.class);
        System.out.println(ReflectionToStringBuilder.toString(b));

    }
}
