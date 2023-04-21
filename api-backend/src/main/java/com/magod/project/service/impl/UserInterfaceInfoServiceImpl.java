package com.magod.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magod.project.common.ErrorCode;
import com.magod.project.exception.BusinessException;
import com.magod.project.mapper.UserInterfaceInfoMapper;
import com.magod.project.service.UserInterfaceInfoService;
import org.magod.apicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

/**
 * @author ASUS
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
 * @createDate 2023-04-20 09:42:10
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Long userId = userInterfaceInfo.getUserId();
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (interfaceInfoId<=0 || userId<=0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"请求用户或参数不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId<=0 || userId<=0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"请求用户或参数不存在");
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper=new UpdateWrapper();
        updateWrapper.eq("interfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }
}




