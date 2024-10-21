package com.dao;

import com.entity.ChuzushouruEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChuzushouruVO;
import com.entity.view.ChuzushouruView;


/**
 * 出租收入
 * 
 * @author 
 * @email 
 * @date 2023-02-24 16:38:17
 */
public interface ChuzushouruDao extends BaseMapper<ChuzushouruEntity> {
	
	List<ChuzushouruVO> selectListVO(@Param("ew") Wrapper<ChuzushouruEntity> wrapper);
	
	ChuzushouruVO selectVO(@Param("ew") Wrapper<ChuzushouruEntity> wrapper);
	
	List<ChuzushouruView> selectListView(@Param("ew") Wrapper<ChuzushouruEntity> wrapper);

	List<ChuzushouruView> selectListView(Pagination page,@Param("ew") Wrapper<ChuzushouruEntity> wrapper);
	
	ChuzushouruView selectView(@Param("ew") Wrapper<ChuzushouruEntity> wrapper);
	

}
