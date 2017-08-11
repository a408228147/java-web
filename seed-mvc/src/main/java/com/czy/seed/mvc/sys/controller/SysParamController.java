package com.czy.seed.mvc.sys.controller;

import com.czy.seed.mvc.sys.entity.SysDept;
import com.czy.seed.mvc.sys.entity.SysParam;
import com.czy.seed.mvc.sys.service.SysParamService;
import com.czy.seed.mvc.util.Res;
import com.czy.seed.mybatis.base.QueryParams;
import com.czy.seed.mybatis.tool.NullUtil;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("sys/param")
@RestController
public class SysParamController {

    @Autowired
    private SysParamService sysParamService;

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("sys/param");
    }

    @RequestMapping("/selectPageByParams")
    public Res selectPageByParams(@RequestParam  Map<String, Object> params) {
        Integer pageNum = Integer.parseInt(params.get("pageNum").toString());
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        QueryParams queryParams = new QueryParams(SysDept.class);
        if (params.containsKey("name") && NullUtil.isNotEmpty(params.get("name"))) {
            QueryParams.Criteria criteria = queryParams.createCriteria();
            criteria.andLike("name", "%" + params.get("name") + "%");
        }
        Page<SysParam> page = sysParamService.selectPageByParams(pageNum, pageSize, queryParams);
        Map<String, Object> pageInfo = new HashMap<String, Object>();
        pageInfo.put("total", page.getTotal());
        pageInfo.put("page", page);
        return Res.ok(pageInfo);
    }

    @RequestMapping("/save")
    public Res save(@RequestBody SysParam sysParam) {
        if (sysParam.getId() == null) {
            sysParamService.insert(sysParam);
        } else {
            sysParamService.updateSelectiveByPrimaryKey(sysParam);
        }
        return Res.ok(sysParam.getId());
    }

}
