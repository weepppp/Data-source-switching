package com.example.doublesourse.dd;

import com.example.doublesourse.annotation.Ds;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * @author weepppp 2022/7/14 13:46
 **/

/**
 * @功能 此切面类目的在于获取到所有添加了自定义注解的方法的value值
 * 定义切点和通知
 * 切点条件为：所有加了自定义注解的方法或者类
 * 通知作用为：获得这些方法的注解，从而获得注解的value值
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class DynamicDataSourceAspect {

    // 定义哪些方法被拦截---加了ds注解的方法
    @Pointcut("@annotation(com.example.doublesourse.annotation.Ds) || @within(com.example.doublesourse.annotation.Ds)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Ds ds = getDs(point); // point代指每一个被切的方法
        String value = ds.value();
        try {
            DynamicDataSourceContextHolder.setDsType(value);
            return point.proceed(); // 执行切点方法
        } finally {
            DynamicDataSourceContextHolder.removeDsType();
        }

    }

    private Ds getDs(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();  // 拿到切点标记的实际方法
        Ds annotation = AnnotationUtils.findAnnotation(signature.getMethod(), Ds.class); // 查找实际方法上的ds注解
        if (annotation == null) {
            annotation = AnnotationUtils.findAnnotation(signature.getDeclaringType(), Ds.class); // 方法上没有，就去类上找
        }
        return annotation;
    }

}
