package json.chao.com.wanandroid.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import json.chao.com.wanandroid.test.EspressoIdlingResource;
import me.yokeyword.fragmentation.SupportActivity;
import json.chao.com.wanandroid.component.ActivityCollector;
import android.support.test.espresso.IdlingResource;


/**
 * Common simple Activity
 *
 * @author quchao
 * @date 2017/11/28
 */

/**
 * 关于所有 Activity 的共通处理，如：ButterKnife绑定以及向ActivityCollector中添加创建的Activity
 * 以及一些方法的执行流程，如 getLayoutId() ---> onViewCreated() --> initToolbar--->initEventAndData
 */

public abstract class AbstractSimpleActivity extends SupportActivity {

    private Unbinder unBinder;
    protected AbstractSimpleActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        mActivity = this;
        ActivityCollector.getInstance().addActivity(this);
        onViewCreated();
        initToolbar();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }

    /**
     * 在initEventAndData()之前执行
     */
    protected abstract void onViewCreated();

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化ToolBar
     */
    protected abstract void initToolbar();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

}
