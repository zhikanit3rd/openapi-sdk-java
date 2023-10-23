package com.liga.api.method.response.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadResponse {
    
    /**文件key */
    private String fileKey;

    /**文件名称 */
    private String fileName;

    /**文件类型 */
    private String fileType;

    /**文件大小；单位：字节 */
    private Long fileSize;

    /**上传用户id */
    private Long uploadUserId;

    /**上传用户名称 */
    private String uploadUserName;

    /**上传时间 */
    private Date uploadTime;

    /**原图地址 */
    private String originalUrl;

    /**文件后缀 */
    private String fileSuffix;
}
