package json.chao.com.wanandroid.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author quchao
 * @date 2018/2/13
 */

/*
 * 自定义的注解 ActivityScope
 * @Scope作用是控制所提供依赖的生命周期，使其与容器的生命周期相同，从而实现局部单例或全局单例
 * @Scope注解的名字是为了增强可读性，所以起名字的时候，一定要起得言简意赅
 *
 * */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
