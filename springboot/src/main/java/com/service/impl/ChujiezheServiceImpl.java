package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChujiezheDao;
import com.entity.ChujiezheEntity;
import com.service.ChujiezheService;
import com.entity.vo.ChujiezheVO;
import com.entity.view.ChujiezheView;

@Service("chujiezheService")
public class ChujiezheServiceImpl extends ServiceImpl<ChujiezheDao, ChujiezheEntity> implements ChujiezheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChujiezheEntity> page = this.selectPage(
                new Query<ChujiezheEntity>(params).getPage(),
                new EntityWrapper<ChujiezheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChujiezheEntity> wrapper) {
		  Page<ChujiezheView> page =new Query<ChujiezheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChujiezheVO> selectListVO(Wrapper<ChujiezheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChujiezheVO selectVO(Wrapper<ChujiezheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChujiezheView> selectListView(Wrapper<ChujiezheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChujiezheView selectView(Wrapper<ChujiezheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
