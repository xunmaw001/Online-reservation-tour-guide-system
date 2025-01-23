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

import com.entity.YuyuedingdanEntity;
import com.entity.view.YuyuedingdanView;

import com.service.YuyuedingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 预约订单
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
@RestController
@RequestMapping("/yuyuedingdan")
public class YuyuedingdanController {
    @Autowired
    private YuyuedingdanService yuyuedingdanService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuedingdanEntity yuyuedingdan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("daoyou")) {
			yuyuedingdan.setDaoyouzhenghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			yuyuedingdan.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuedingdanEntity> ew = new EntityWrapper<YuyuedingdanEntity>();


		PageUtils page = yuyuedingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuedingdan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuedingdanEntity yuyuedingdan, 
		HttpServletRequest request){
        EntityWrapper<YuyuedingdanEntity> ew = new EntityWrapper<YuyuedingdanEntity>();

		PageUtils page = yuyuedingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuedingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuedingdanEntity yuyuedingdan){
       	EntityWrapper<YuyuedingdanEntity> ew = new EntityWrapper<YuyuedingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuedingdan, "yuyuedingdan")); 
        return R.ok().put("data", yuyuedingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuedingdanEntity yuyuedingdan){
        EntityWrapper< YuyuedingdanEntity> ew = new EntityWrapper< YuyuedingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuedingdan, "yuyuedingdan")); 
		YuyuedingdanView yuyuedingdanView =  yuyuedingdanService.selectView(ew);
		return R.ok("查询预约订单成功").put("data", yuyuedingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuedingdanEntity yuyuedingdan = yuyuedingdanService.selectById(id);
        return R.ok().put("data", yuyuedingdan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuedingdanEntity yuyuedingdan = yuyuedingdanService.selectById(id);
        return R.ok().put("data", yuyuedingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuedingdanEntity yuyuedingdan, HttpServletRequest request){
    	yuyuedingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuedingdan);

        yuyuedingdanService.insert(yuyuedingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuedingdanEntity yuyuedingdan, HttpServletRequest request){
    	yuyuedingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuedingdan);

        yuyuedingdanService.insert(yuyuedingdan);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuedingdanEntity yuyuedingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuedingdan);
        yuyuedingdanService.updateById(yuyuedingdan);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuedingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
