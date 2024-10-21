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


import com.dao.JieyuezheDao;
import com.entity.JieyuezheEntity;
import com.service.JieyuezheService;
import com.entity.vo.JieyuezheVO;
import com.entity.view.JieyuezheView;

@Service("jieyuezheService")
public class JieyuezheServiceImpl extends ServiceImpl<JieyuezheDao, JieyuezheEntity> implements JieyuezheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JieyuezheEntity> page = this.selectPage(
                new Query<JieyuezheEntity>(params).getPage(),
                new EntityWrapper<JieyuezheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JieyuezheEntity> wrapper) {
		  Page<JieyuezheView> page =new Query<JieyuezheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JieyuezheVO> selectListVO(Wrapper<JieyuezheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JieyuezheVO selectVO(Wrapper<JieyuezheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JieyuezheView> selectListView(Wrapper<JieyuezheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JieyuezheView selectView(Wrapper<JieyuezheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
