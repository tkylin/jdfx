package com.tkylin.jdfx.core;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Created by tkyli on 2017/3/8.
 */
public class H5Client {
    public static HtmlPage load(String url) {
        WebClient client = new WebClient(BrowserVersion.CHROME);
        client.getOptions().setJavaScriptEnabled(false);//启用JS解释器，默认为true
        client.getOptions().setCssEnabled(false); //禁用css支持
        client.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常
        client.getOptions().setTimeout(20000);
        client.getOptions().setActiveXNative(false);
        HtmlPage page = null;
        try {
            page = client.getPage(url);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }
}
