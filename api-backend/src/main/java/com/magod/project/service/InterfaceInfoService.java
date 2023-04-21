package com.magod.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.magod.apicommon.model.entity.InterfaceInfo;

/**
* @author ASUS
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-04-11 09:52:09
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
