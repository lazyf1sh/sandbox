//package com.github.lazyf1sh.sandbox.java.jxbrowser;
//
//import com.teamdev.jxbrowser.chromium.Browser;
//import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
//import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
//
///**
// * No maven artifact available for this example. Jar should be downloaded manually and placed to the classpath.
// *
// */
//public class App
//{
//    public static void main( String[] args )
//    {
//        Browser browser = new Browser();
//        browser.addLoadListener(new LoadAdapter() {
//            @Override
//            public void onFinishLoadingFrame(FinishLoadingEvent event) {
//                if (event.isMainFrame()) {
//                    System.out.println("HTML = " + event.getBrowser().getHTML());
//                }
//            }
//        });
//
//        browser.loadURL("https://www.wildberries.ru/catalog/6232983/detail.aspx?targetUrl=BP");
//        System.out.println(browser);
//
//    }
//}
