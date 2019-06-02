import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-04-22 20:17
 */
@Slf4j
public class WriteThread extends Thread{
    public DataCache dataCache;

    public WriteThread(String str, DataCache dataCache) {
        super(str);
        this.dataCache = dataCache;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String result = "" + dataCache.write(name, "DATA-"+name);
        System.out.println(name + " write to current cache!");
    }
}
