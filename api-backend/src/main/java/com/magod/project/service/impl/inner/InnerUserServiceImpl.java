package com.magod.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.magod.project.common.ErrorCode;
import com.magod.project.exception.BusinessException;
import com.magod.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.magod.apicommon.model.entity.User;
import org.magod.apicommon.service.InnerUserService;

import javax.annotation.Resource;

/**
 * @program: api-backend
 * @description:
 * @author: ma
 * @create: 2023-04-21 09:33
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
