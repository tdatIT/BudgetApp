package com.datit.log;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class WriteLog {
    private static Logger log = LogManager.getLogger(WriteLog.class);
    public static void writeLog(Exception e,String classname){
        log.info("INFO: {}",classname);
        log.error("{}",e);
    }
}
