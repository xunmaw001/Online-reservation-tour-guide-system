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


import com.dao.DiscusslvyouxindeDao;
import com.entity.DiscusslvyouxindeEntity;
import com.service.DiscusslvyouxindeService;
import com.entity.vo.DiscusslvyouxindeVO;
import com.entity.view.DiscusslvyouxindeView;

@Service("discusslvyouxindeService")
public class DiscusslvyouxindeServiceImpl extends ServiceImpl<DiscusslvyouxindeDao, DiscusslvyouxindeEntity> implements DiscusslvyouxindeService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusslvyouxindeEntity> page = this.selectPage(
                new Query<DiscusslvyouxindeEntity>(params).getPage(),
                new EntityWrapper<DiscusslvyouxindeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusslvyouxindeEntity> wrapper) {
		  Page<DiscusslvyouxindeView> page =new Query<DiscusslvyouxindeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusslvyouxindeVO> selectListVO(Wrapper<DiscusslvyouxindeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusslvyouxindeVO selectVO(Wrapper<DiscusslvyouxindeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusslvyouxindeView> selectListView(Wrapper<DiscusslvyouxindeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusslvyouxindeView selectView(Wrapper<DiscusslvyouxindeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
