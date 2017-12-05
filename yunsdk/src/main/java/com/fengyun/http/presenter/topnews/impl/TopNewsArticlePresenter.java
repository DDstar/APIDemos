package com.fengyun.http.presenter.topnews.impl;


import android.support.v7.app.AlertDialog;

import com.fengyun.app.fragment.ITopNewsArticleFragment;
import com.fengyun.config.Urls;
import com.fengyun.http.presenter.impl.BasePresenter;
import com.fengyun.http.presenter.topnews.ITopNewsArticlePresenter;
import com.fengyun.model.topnews.NewsDetailBean;
import com.fengyun.util.OkHttpUtils;
import com.fengyun.util.topnews.TopNewsJSONUtils;


/**
 * Created by 蔡小木 on 2016/4/26 0026.
 */
public class TopNewsArticlePresenter extends BasePresenter implements ITopNewsArticlePresenter {

    private ITopNewsArticleFragment mITopNewsFragment;

    public TopNewsArticlePresenter(ITopNewsArticleFragment topNewsFragment) {
        if (topNewsFragment == null)
            throw new IllegalArgumentException(" must not be null");
        mITopNewsFragment = topNewsFragment;
    }
    private String getDetailUrl(String docId) {
        StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
        sb.append(docId).append(Urls.END_DETAIL_URL);
        return sb.toString();
    }

    @Override
    public void getDescribleMessage(final String docid) {
        mITopNewsFragment.showProgressDialog();
        String url = getDetailUrl(docid);
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                NewsDetailBean newsDetailBean = TopNewsJSONUtils.readJsonNewsDetailBeans(response, docid);
               mITopNewsFragment.updateListItem(newsDetailBean);
            }

            @Override
            public void onFailure(Exception e) {
                mITopNewsFragment.showError(e.toString());
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);

    }
}
