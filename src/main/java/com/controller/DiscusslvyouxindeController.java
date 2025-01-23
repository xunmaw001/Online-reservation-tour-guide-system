package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusslvyouxindeEntity;
import com.entity.view.DiscusslvyouxindeView;

import com.service.DiscusslvyouxindeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 旅游心得评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
@RestController
@RequestMapping("/discusslvyouxinde")
public class DiscusslvyouxindeController {
    @Autowired
    private DiscusslvyouxindeService discusslvyouxindeService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusslvyouxindeEntity discusslvyouxinde, 
		HttpServletRequest request){

        EntityWrapper<DiscusslvyouxindeEntity> ew = new EntityWrapper<DiscusslvyouxindeEntity>();


		PageUtils page = discusslvyouxindeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusslvyouxinde), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusslvyouxindeEntity discusslvyouxinde, 
		HttpServletRequest request){
        EntityWrapper<DiscusslvyouxindeEntity> ew = new EntityWrapper<DiscusslvyouxindeEntity>();

		PageUtils page = discusslvyouxindeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusslvyouxinde), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusslvyouxindeEntity discusslvyouxinde){
       	EntityWrapper<DiscusslvyouxindeEntity> ew = new EntityWrapper<DiscusslvyouxindeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusslvyouxinde, "discusslvyouxinde")); 
        return R.ok().put("data", discusslvyouxindeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusslvyouxindeEntity discusslvyouxinde){
        EntityWrapper< DiscusslvyouxindeEntity> ew = new EntityWrapper< DiscusslvyouxindeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusslvyouxinde, "discusslvyouxinde")); 
		DiscusslvyouxindeView discusslvyouxindeView =  discusslvyouxindeService.selectView(ew);
		return R.ok("查询旅游心得评论表成功").put("data", discusslvyouxindeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusslvyouxindeEntity discusslvyouxinde = discusslvyouxindeService.selectById(id);
        return R.ok().put("data", discusslvyouxinde);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusslvyouxindeEntity discusslvyouxinde = discusslvyouxindeService.selectById(id);
        return R.ok().put("data", discusslvyouxinde);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusslvyouxindeEntity discusslvyouxinde, HttpServletRequest request){
    	discusslvyouxinde.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusslvyouxinde);

        discusslvyouxindeService.insert(discusslvyouxinde);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusslvyouxindeEntity discusslvyouxinde, HttpServletRequest request){
    	discusslvyouxinde.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusslvyouxinde);

        discusslvyouxindeService.insert(discusslvyouxinde);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusslvyouxindeEntity discusslvyouxinde, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusslvyouxinde);
        discusslvyouxindeService.updateById(discusslvyouxinde);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusslvyouxindeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
