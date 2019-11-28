package we.blog.web.api.aspects;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataAspect {
    @Pointcut("execution(* we.blog.web.api.service.Impl.DataServiceImpl.*(..))")
    public void pointcut() {
        System.out.println("TestAspct");
    }
    @Around(("DataAspect.pointcut()"))
    public void around(ProceedingJoinPoint point){
        Signature signature = point.getSignature();
        System.out.println(String.format("[%s].[%s] args：%s",signature.getDeclaringType(),
                                            signature.getName(),
                                            JSONObject.toJSON(point.getArgs())
                ));
        try {
            point.proceed();
        } catch (Throwable e) {
            System.out.println(e);
        }
    }
    //抛出异常时调用
    @AfterThrowing(pointcut = "DataAspect.pointcut()", throwing = "e")
    public void afterException(Throwable e) {
        System.out.println(e);
    }
}
