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


import com.dao.ChuzushouruDao;
import com.entity.ChuzushouruEntity;
import com.service.ChuzushouruService;
import com.entity.vo.ChuzushouruVO;
import com.entity.view.ChuzushouruView;

@Service("chuzushouruService")
public class ChuzushouruServiceImpl extends ServiceImpl<ChuzushouruDao, ChuzushouruEntity> implements ChuzushouruService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuzushouruEntity> page = this.selectPage(
                new Query<ChuzushouruEntity>(params).getPage(),
                new EntityWrapper<ChuzushouruEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuzushouruEntity> wrapper) {
		  Page<ChuzushouruView> page =new Query<ChuzushouruView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChuzushouruVO> selectListVO(Wrapper<ChuzushouruEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChuzushouruVO selectVO(Wrapper<ChuzushouruEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChuzushouruView> selectListView(Wrapper<ChuzushouruEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuzushouruView selectView(Wrapper<ChuzushouruEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
