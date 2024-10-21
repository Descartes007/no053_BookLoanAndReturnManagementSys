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

import com.entity.TushuguihaiEntity;
import com.entity.view.TushuguihaiView;

import com.service.TushuguihaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书归还
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
@RestController
@RequestMapping("/tushuguihai")
public class TushuguihaiController {
    @Autowired
    private TushuguihaiService tushuguihaiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushuguihaiEntity tushuguihai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jieyuezhe")) {
			tushuguihai.setJieyuezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("chujiezhe")) {
			tushuguihai.setChujiezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TushuguihaiEntity> ew = new EntityWrapper<TushuguihaiEntity>();

		PageUtils page = tushuguihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuguihai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TushuguihaiEntity tushuguihai, 
		HttpServletRequest request){
        EntityWrapper<TushuguihaiEntity> ew = new EntityWrapper<TushuguihaiEntity>();

		PageUtils page = tushuguihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuguihai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushuguihaiEntity tushuguihai){
       	EntityWrapper<TushuguihaiEntity> ew = new EntityWrapper<TushuguihaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushuguihai, "tushuguihai")); 
        return R.ok().put("data", tushuguihaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushuguihaiEntity tushuguihai){
        EntityWrapper< TushuguihaiEntity> ew = new EntityWrapper< TushuguihaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushuguihai, "tushuguihai")); 
		TushuguihaiView tushuguihaiView =  tushuguihaiService.selectView(ew);
		return R.ok("查询图书归还成功").put("data", tushuguihaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushuguihaiEntity tushuguihai = tushuguihaiService.selectById(id);
        return R.ok().put("data", tushuguihai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushuguihaiEntity tushuguihai = tushuguihaiService.selectById(id);
        return R.ok().put("data", tushuguihai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushuguihaiEntity tushuguihai, HttpServletRequest request){
    	tushuguihai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushuguihai);
        tushuguihaiService.insert(tushuguihai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushuguihaiEntity tushuguihai, HttpServletRequest request){
    	tushuguihai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushuguihai);
        tushuguihaiService.insert(tushuguihai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushuguihaiEntity tushuguihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuguihai);
        tushuguihaiService.updateById(tushuguihai);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushuguihaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<TushuguihaiEntity> wrapper = new EntityWrapper<TushuguihaiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jieyuezhe")) {
			wrapper.eq("jieyuezhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("chujiezhe")) {
			wrapper.eq("chujiezhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = tushuguihaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
