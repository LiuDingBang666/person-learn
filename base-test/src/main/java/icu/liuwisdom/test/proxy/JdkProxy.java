package icu.liuwisdom.test.proxy;

import icu.liuwisdom.test.aspect.TestAspect;
import icu.liuwisdom.test.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Jdk动态代理
 *
 * @author LDB
 * @version 1.0
 * @date 2023-02-19 23:09
 */
public class JdkProxy implements InvocationHandler {
    private Service target;

    public Object create(Service target) {
        this.target = target;
        final ClassLoader loader = JdkProxy.class.getClassLoader();
        final Class<?>[] interfaces = Service.class.getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, this);
    }

    /**
     * @param proxy  被代理类
     * @param method 被代理类方法
     * @param args   参数
     * @return java.lang.Object
     * @author LDB
     * @date 2023-02-19
     **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TestAspect aspect = new TestAspect();
        aspect.start();
        final Object o = method.invoke(target, args);
        aspect.stop();
        return o;
    }
}
