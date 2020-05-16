package com.company.db.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.db.common.pojo.JsonResult;

@Controller
public class PageController {

	@RequestMapping("hello")
	@ResponseBody
	public JsonResult<Map<String, String>> showHello() {
		System.out.println("PageController.showHello()");
		Map<String, String> map = new HashMap<String, String>();
		map.put("hello", "world");
		return JsonResult.getSuccessJR(map);
	}

	@RequestMapping("/")
	public String showStarter() {
		System.out.println("PageController.showIndex()");
		return "starter";
	}

	@RequestMapping("/sys/{subPage}")
	public String showStarterSubPage(@PathVariable("subPage") String pageName) {
		return "sys/" + pageName;
	}

	@RequestMapping("/common/page")
	public String showFloorBtn() {
		return "common/page";
	}

	@RequestMapping("/login_page")
	public String findloginPage() {
		return "login";
	}
}
