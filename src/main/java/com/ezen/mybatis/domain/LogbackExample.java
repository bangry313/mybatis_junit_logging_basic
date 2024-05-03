package com.ezen.mybatis.domain;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogbackExample {
    //static Logger logger = LoggerFactory.getLogger(LogbackExample.class);

    public void some(){
        log.info("{}", "바보");

    }

    public static void main(String[] args) {
//        System.out.println("");
//        logger.trace("재잘재잘 메시지");
//        logger.debug("디버깅 메시지");
//        logger.info("정보 메시지");
//        logger.warn("경고 메시지");
//        logger.error("치명적 에러 메시지");
//        logger.debug("메시지 : {}", "방그리");
//
//        int x = 10, y = 20;
//
//        logger.info("x: "+x+", y:"+ y); // X
//        logger.warn("x: "+x+", y:"+ y); // X
//
//        logger.info("x: {}, y: {}", x, y); // O
        LogbackExample example = new LogbackExample();
        example.some();
    }
}
