package com.sys.tryxx.Controller;

import com.sys.tryxx.domain.ReplyMsg;
import com.sys.tryxx.service.UserService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tryxx
 * @description:
 * @author: xiao
 * @create: 2019-07-12 10:42
 **/
@RestController
public class MongoTest {

  @Autowired
  UserService userService;

  @ApiOperation("mongo查询")
  @GetMapping(value = "/mongo/like")
  public List<ReplyMsg> testtest2(@RequestParam String domain){
//    return uRepo.findById("2500001").get();
    return userService.mongoTest2(domain);
  }
}