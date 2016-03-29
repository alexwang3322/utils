package alex.demo;

import android.content.SharedPreferences;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by alex on 16/2/20.
 *
 * 还需要增加更多测试.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class , sdk = 18)
public class SelectionTest {

    private static SelectionUtil prefSelection ;

    @Before
    public void setUp(){
//        prefSelection = SelectionUtil.getInstance();
        prefSelection = new SelectionUtil("analytics_array", "pref_array");
    }
//    @Test
//    public void testSend(){
//        Assert.assertEquals(prefSelection.getSendFileName(), "1");
//    }
//
//    @Test
//    public void testUpd(){
//        prefSelection.getSendFileName();
//        Assert.assertEquals(prefSelection.updateFileArray(), true);
//    }

    /**     状况一 测试成功       2016-2-22 10:58 , 11:57 */
    @Test
    public void testSendDel(){
        String str = prefSelection.getSendFileName(); // 取到要发送文件
        prefSelection.updateFileArray(); // 发送失败,需要更新当前发送文件
        String str1 = prefSelection.getSendFileName(); // 再次发送，取到要发送的文件 (可以加个取待发送文件列表的方法)
        Assert.assertEquals(prefSelection.delSendFile(), true); // 再次发送，发送成功，删除当前发送的文件
        String str2 = prefSelection.getSendFileName(); // 再次发送，取到要发送的文件
        // excepted result : null | 1 | null
        // actual result   : null | 1 | null
        Assert.assertNull(str);
        Assert.assertEquals(str1, "1");
        Assert.assertNull(str2);
//        System.out.println("str = " + str + " str1 = " + str1 + " str2 = " + str2);
    }

    /**     状况二 测试成功       2016-2-22 11:46 */
    @Test
    public void testWritableSendDelLoopUntilDone2(){
        String str = null;
        str = prefSelection.getWritableFileName(); // 取到要写入的文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        String str1;
        String strLast = null;
        while((str1 = prefSelection.getSendFileName())!=null){// 轮训取代发送文件时候，因为该方法有默认值，所以条件一直为真;
            Assert.assertEquals(prefSelection.delSendFile(), true); // 再次发送，发送成功，删除当前发送的文件
            strLast = str1;
        }
        String str2 = prefSelection.getSendFileName(); // 再次发送，取到要发送的文件
        // excepted result : 1 | null | 3 | null
        // actual result   : 1 | null | 3 | null
        Assert.assertEquals(str, "1");
        Assert.assertNull(str1);
        Assert.assertEquals(strLast, "3");
        Assert.assertNull(str2);
//        System.out.println("str = " + str + " str1 = " + str1 + " strLast = " + strLast + " str2 = " + str2 );
    }

    @Test
    public void testStandardSent(){
        prefSelection.getWritableFileName();
        prefSelection.getSendFileName();
        prefSelection.delSendFile();
        prefSelection.getWritableFileName();
        Assert.assertEquals(prefSelection.getSendFileName(), "1");
    }

    /**
     * [1,2,3]
     * [2,3]
     * [2,3,4]
     * 测试通过 2016-2-23 10:40
     * */
    @Test
    public void testCondition2(){
        String str = null;
        str = prefSelection.getWritableFileName(); // 取到要写入的文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.delSendFile();
        prefSelection.updateFileArray();
        // excepted result : 4
        // actual result   : 4
        Assert.assertEquals(prefSelection.getWritableFileName(), "4");
//        System.out.println(prefSelection.getWritableFileName());
    }

    /**
     * 测试通过 2016-2-23 10:41
     * */
    @Test
    public void testConditionSendNameIsCorrect1(){
        String str = null;
        str = prefSelection.getWritableFileName(); // 取到要写入的文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.delSendFile();
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();
        // excepted result : 2
        // actual result   : 2
        Assert.assertEquals(prefSelection.getSendFileName() , "2");
//        System.out.println(prefSelection.getSendFileName());
    }

    /**
     * 测试通过 2016-2-23 11:15
     * **/
    @Test
    public void testUploadToServer(){
        String str = null , str2 = null;
        str = prefSelection.getWritableFileName(); // 取到要写入的文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();

        int i = 0 ;
        while((str2 = prefSelection.getSendFileName())!= null){
            // 上传成功后
            prefSelection.delSendFile();
            i++;
        }
        Assert.assertEquals(i, prefSelection.DEFAULT_FILE_ARRAY_LENGTH);
//        System.out.println("finished i = " + i);
    }
    /**
     * 测试通过 2016-2-23 10:47
     * */
    @Test
    public void  testCondition4(){
        String str = null;
        str = prefSelection.getWritableFileName(); // 取到要写入的文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();

        /** when {@code prefSelection.DEFAUL...} equals 5 , values below is available **/
        Assert.assertEquals(prefSelection.getSendFileName(), "1");
        Assert.assertEquals(prefSelection.getWritableFileName(), "5");

//        System.out.println(prefSelection.getSendFileName());
//        System.out.println(prefSelection.getWritableFileName());
//        System.out.println();

        prefSelection.delSendFile();
        prefSelection.delSendFile();
        prefSelection.delSendFile();
        prefSelection.delSendFile();
        prefSelection.delSendFile();

        /** when {@code prefSelection.DEFAUL...} equals 5 , values below is available **/
        Assert.assertNull(prefSelection.getSendFileName());
        Assert.assertEquals(prefSelection.getWritableFileName(), "1");
        Assert.assertEquals(prefSelection.getSendFileName(), "1");

//        System.out.println(prefSelection.getSendFileName());
//        System.out.println(prefSelection.getWritableFileName());
    }


    /**
     * 文件里出现   [1,2,3,1,2,3,1]
     * */
    @Test
    public void testConditionQueueCycleIsAvaliable(){
        // 是否是上层对此工具操作不当导致?
        // 由于一直update没有做边界检查导致？

        String str = null;
        str = prefSelection.getWritableFileName(); // 取到要写入的文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();

        /** when {@code prefSelection.DEFAUL...} equals 5 , values below is available **/

        Assert.assertEquals(prefSelection.getSendFileName(), "5");
        Assert.assertEquals(prefSelection.getWritableFileName(), "4");

//        System.out.println(prefSelection.getQueue().toString());
//        System.out.println("send     = "+prefSelection.getSendFileName());
//        System.out.println("writable = "+prefSelection.getWritableFileName());
    }

    /** 2016-2-23 1:48 **/
    @Test
    public void testConditionSendAvaliable(){
        prefSelection.getWritableFileName(); // 取到要写入的文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray();

        prefSelection.delSendFile(); //del 1
        Assert.assertNotNull(prefSelection.getSendFileName());
        prefSelection.delSendFile(); //del 2
        Assert.assertNotNull(prefSelection.getSendFileName());
        prefSelection.delSendFile(); //del 3
        Assert.assertNotNull(prefSelection.getSendFileName());
        prefSelection.delSendFile(); //del 4
//        Assert.assertNotNull(prefSelection.getSendFileName());
//        prefSelection.delSendFile(); //del 5

//        System.out.println(prefSelection.getWritableFileName()); // excepted : 1   ; actual : 1
//        System.out.println(prefSelection.getQueue().toString()); // excepted : [1] ; actual : [1]
        Assert.assertNotNull(prefSelection.getSendFileName()); // asserted , and of course queue is empty;
    }

    @Test
    public void testConditionUpdate(){
        prefSelection.getWritableFileName(); // 取到要写入的文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray(); // 写满当前文件，使用新文件
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();
        prefSelection.updateFileArray();
    }

}
