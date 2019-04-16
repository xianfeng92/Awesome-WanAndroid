package json.chao.com.wanandroid.di.component;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import json.chao.com.wanandroid.core.DataManager;
import json.chao.com.wanandroid.app.WanAndroidApp;
import json.chao.com.wanandroid.di.module.AbstractAllActivityModule;
import json.chao.com.wanandroid.di.module.AbstractAllDialogFragmentModule;
import json.chao.com.wanandroid.di.module.AbstractAllFragmentModule;
import json.chao.com.wanandroid.di.module.AppModule;
import json.chao.com.wanandroid.di.module.HttpModule;

/**
 * @author quchao
 * @date 2017/11/27
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllActivityModule.class,
        AbstractAllFragmentModule.class,
        AbstractAllDialogFragmentModule.class,
        AppModule.class,
        HttpModule.class})
public interface AppComponent {

    /**
     * 注入WanAndroidApp实例
     *
     * @param wanAndroidApp WanAndroidApp
     */
    void inject(WanAndroidApp wanAndroidApp);


    /*
     * 将 AppComponent 中可以提供的依赖暴露出来，以便于其他依赖（dependencies）于 AppComponent 的Component调用
     * */

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    WanAndroidApp getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();

}
