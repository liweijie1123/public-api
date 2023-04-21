package com.magod.project.service.impl.inner;

import com.magod.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.magod.apicommon.service.InnerUserInterfaceInfoService;

import javax.annotation.Resource;

/**
 * @program: api-backend
 * @description:
 * @author: ma
 * @create: 2023-04-21 09:34
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
