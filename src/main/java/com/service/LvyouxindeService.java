package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LvyouxindeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LvyouxindeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LvyouxindeView;


/**
 * 旅游心得
 *
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
public interface LvyouxindeService extends IService<LvyouxindeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LvyouxindeVO> selectListVO(Wrapper<LvyouxindeEntity> wrapper);
   	
   	LvyouxindeVO selectVO(@Param("ew") Wrapper<LvyouxindeEntity> wrapper);
   	
   	List<LvyouxindeView> selectListView(Wrapper<LvyouxindeEntity> wrapper);
   	
   	LvyouxindeView selectView(@Param("ew") Wrapper<LvyouxindeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LvyouxindeEntity> wrapper);
   	

}

