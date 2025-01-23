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


import com.dao.LvyouxindeDao;
import com.entity.LvyouxindeEntity;
import com.service.LvyouxindeService;
import com.entity.vo.LvyouxindeVO;
import com.entity.view.LvyouxindeView;

@Service("lvyouxindeService")
public class LvyouxindeServiceImpl extends ServiceImpl<LvyouxindeDao, LvyouxindeEntity> implements LvyouxindeService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LvyouxindeEntity> page = this.selectPage(
                new Query<LvyouxindeEntity>(params).getPage(),
                new EntityWrapper<LvyouxindeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LvyouxindeEntity> wrapper) {
		  Page<LvyouxindeView> page =new Query<LvyouxindeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LvyouxindeVO> selectListVO(Wrapper<LvyouxindeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LvyouxindeVO selectVO(Wrapper<LvyouxindeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LvyouxindeView> selectListView(Wrapper<LvyouxindeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LvyouxindeView selectView(Wrapper<LvyouxindeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
