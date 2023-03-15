package com.solvd.carina.globalsqa.firststep.progressbar;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProgressBarTest implements IAbstractTest {


    @Test
    public void fileGetsDownloaded(){
        DownloadManagerPage downloadManager = new DownloadManagerPage(getDriver());
        downloadManager.open();
        Assert.assertTrue(downloadManager.isPageOpened(),"Download manager page isn't opened");

    }

}