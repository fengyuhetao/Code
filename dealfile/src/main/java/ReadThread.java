import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.util.TreeMap;

/**
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-04-22 20:18
 */
@Slf4j
public class ReadThread extends Thread {
    public DataCache dataCache;

    public ReadThread(String name, DataCache dataCache) {
        super(name);
        this.dataCache = dataCache;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        long result =  dataCache.readSize();
        System.out.println(name + " read current cache size is:" + result);
    }
}
