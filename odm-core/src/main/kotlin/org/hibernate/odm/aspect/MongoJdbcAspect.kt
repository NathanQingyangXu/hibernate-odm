package org.hibernate.odm.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.hibernate.odm.jdbc.AbstractCloseable

@Aspect
class MongoJdbcAspect {

  @Pointcut("within(org.hibernate.odm.jdbc)")
  fun withinJdbcPackage() {
    // no-op
  }

  @Pointcut("target(AbstractCloseable)")
  fun isJdbcCloseable() {
    // no-op
  }

  @Pointcut("execution(* AbstractCloseable+.*(..))")
  fun invokeAbstractClosableMethod() {
    // no-op
  }

  @Pointcut("execution(public !static * *(..))")
  fun invokePublicInstanceMethods() {
    // no-op
  }

  @Before(
      "withinJdbcPackage() && isJdbcCloseable()" +
          " && invokePublicInstanceMethods() && !invokeAbstractClosableMethod()")
  fun ensureNotClosed(joinPoint: JoinPoint) {
    (joinPoint.`this` as AbstractCloseable).ensureNotClosed()
  }
}
