package com.dao;

import com.entity.LvyouxindeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LvyouxindeVO;
import com.entity.view.LvyouxindeView;


/**
 * 旅游心得
 * 
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
public interface LvyouxindeDao extends BaseMapper<LvyouxindeEntity> {
	
	List<LvyouxindeVO> selectListVO(@Param("ew") Wrapper<LvyouxindeEntity> wrapper);
	
	LvyouxindeVO selectVO(@Param("ew") Wrapper<LvyouxindeEntity> wrapper);
	
	List<LvyouxindeView> selectListView(@Param("ew") Wrapper<LvyouxindeEntity> wrapper);

	List<LvyouxindeView> selectListView(Pagination page,@Param("ew") Wrapper<LvyouxindeEntity> wrapper);
	
	LvyouxindeView selectView(@Param("ew") Wrapper<LvyouxindeEntity> wrapper);
	

}
