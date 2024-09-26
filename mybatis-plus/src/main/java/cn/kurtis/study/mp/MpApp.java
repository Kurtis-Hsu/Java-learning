package cn.kurtis.study.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.kurtis.study.mp.mapper")
@SpringBootApplication // @formatter:off
public class MpApp { public static void main(String[] args) { SpringApplication.run(MpApp.class, args); }}

