package com.sys.tryxx.Controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestShardingController {

  @ApiOperation(value = "分片查询", notes = "分组")
  @PostMapping(value = "/getGroup")
  public String sharding(@RequestParam String temail) {
//    String strs = temail.substring(temail.indexOf("@") - 1);
//    String zimu = String.valueOf(strs.charAt(0));
    //这两种哪个好些
    char c = temail.charAt(temail.indexOf("@") - 1);
    String zimu = String.valueOf(c);
    String group = "";
    if (zimu.matches("[0-9]")) {
      group = Integer.parseInt(zimu) + 1 + "";
    } else if(zimu.matches("[a-z]||[A-Z]")){
      switch (zimu.toLowerCase()) {
        case "a":
        case "b":
        case "c":
        case "d":
          group = "11";
          break;
        case "e":
        case "f":
        case "h":
          group = "12";
          break;
        case "g":
          group = "13";
          break;
        case "i":
        case "j":
        case "k":
        case "l":
        case "m":
          group = "14";
          break;
        case "n":
          group = "15";
        case "o":
        case "p":
        case "q":
        case "r":
        case "s":
        case "t":
          group = "16";
          break;
        default:
          group = "17";
      }
    }else{
      group = "17";
    }
    return group;
  }

}