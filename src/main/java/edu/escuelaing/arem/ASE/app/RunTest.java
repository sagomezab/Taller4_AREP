package edu.escuelaing.arem.ASE.app;

import java.lang.reflect.Method;

public class RunTest {
    public static void main (String[] args) throws Exception{
        int passed = 0, failed = 0;
        for (String className : args){
            for (Method m : Class.forName(className).getMethods()){
                if(m.isAnnotationPresent(Test.class)){
                    try {
                        m.invoke(null);
                        passed++;
                    } catch (Throwable e) {
                        System.out.printf("Test %s failed: %s %n", m, e.getCause());
                        failed++;
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}
