package com.tkylin.jdfx.core;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tkyli on 2017/3/8.
 */
public class H5Client {
    public static HtmlPage load(String url) {
        WebClient client = new WebClient(BrowserVersion.CHROME);
        client.getOptions().setJavaScriptEnabled(false);//启用JS解释器，默认为true
        client.getOptions().setCssEnabled(false); //禁用css支持
        client.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);
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

    public static HtmlPage loadFX(String url) {
        HtmlPage page = null;
        try {
            WebClient client = new WebClient(BrowserVersion.CHROME);
            WebRequest request = new WebRequest(new URL(url));

            //init client setting
            client.getOptions().setJavaScriptEnabled(false);//启用JS解释器，默认为true
            client.getOptions().setCssEnabled(false); //禁用css支持
            client.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常
            client.getOptions().setTimeout(20000);
            client.getOptions().setActiveXNative(false);
            client.getCookieManager().setCookiesEnabled(true);

            //init request
            request.setAdditionalHeader("Referer", "https://fxhh.jd.com/index.html");
            request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");

            page = client.getPage(request);
            client.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return page;
    }
}
