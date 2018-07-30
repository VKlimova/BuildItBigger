package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.text.TextUtils;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Testable Android AsyncTask as example:
 * https://web.archive.org/web/20170618224249/http://www.making-software.com/2012/10/31/testable-android-asynctask/
 */
@RunWith(AndroidJUnit4.class)
public class DownloadAsyncTaskTests extends TestCase  implements IDownloadListener
{
    EndpointsAsyncTask downloader;//= new EndpointsAsyncTask(this);
    CountDownLatch signal;
    String recievedString;

//    @UiThreadTest

    @Test
    public void testDownload() throws Exception
    {
        setUp();
        Context mContext= InstrumentationRegistry.getTargetContext();
        downloader.execute(new Pair<Context, String>(mContext, "friend"));
        signal.await(30, TimeUnit.SECONDS);
        assertTrue( "Recieved String = " + recievedString, TextUtils.isEmpty(recievedString));
    }

    protected void setUp() throws Exception {
        super.setUp();

        signal = new CountDownLatch(1);
        downloader = new EndpointsAsyncTask(this);
    }

    @Override
    public void downloadCompleted(String jokeTxt)
    {
        recievedString = jokeTxt;
        signal.countDown();
    }
}

