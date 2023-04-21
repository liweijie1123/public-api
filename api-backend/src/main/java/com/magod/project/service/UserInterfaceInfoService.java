package com.magod.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.magod.apicommon.model.entity.UserInterfaceInfo;

/**
* @author ASUS
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-04-20 09:42:10
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
    boolean invokeCount(long interfaceInfoId,long userId);
}
