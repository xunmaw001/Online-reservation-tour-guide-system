package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslvyouxindeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslvyouxindeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslvyouxindeView;


/**
 * 旅游心得评论表
 *
 * @author 
 * @email 
 * @date 2023-05-09 16:54:51
 */
public interface DiscusslvyouxindeService extends IService<DiscusslvyouxindeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslvyouxindeVO> selectListVO(Wrapper<DiscusslvyouxindeEntity> wrapper);
   	
   	DiscusslvyouxindeVO selectVO(@Param("ew") Wrapper<DiscusslvyouxindeEntity> wrapper);
   	
   	List<DiscusslvyouxindeView> selectListView(Wrapper<DiscusslvyouxindeEntity> wrapper);
   	
   	DiscusslvyouxindeView selectView(@Param("ew") Wrapper<DiscusslvyouxindeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslvyouxindeEntity> wrapper);
   	

}

